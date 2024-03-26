window.onload = function () {
    const urlParams = new URLSearchParams(window.location.search);
    const sessionId = urlParams.get('sessionId');
    const questionType = urlParams.get('questionType');
    const question = urlParams.get('question');
    const repo = urlParams.get("repo");

    if (question && repo) {
        let combinedText = `${question} \n\n ${repo}`;
        $('#question-container').text(combinedText);
    } else if (question) {
        $('#question-container').text(question);
    } else if (repo) {
        $('#question-container').text(repo);
    }
    uploadValidAnswer();
};

function uploadValidAnswer() {
    $('#upload-btn').prop('disabled', true);
    const urlParams = new URLSearchParams(window.location.search);
    let sessionId = urlParams.get('sessionId');
    let questionType = urlParams.get('questionType');
    const question = urlParams.get('question');
    const repo = urlParams.get("repo");
    console.log("Session ID:", sessionId);
    console.log("Question Type:", questionType);
    console.log("Question:", question);
    console.log("repo:", repo);

    $('#answerText').on('keydown', function (event) {
        if (event.key === 'Enter' && !event.shiftKey) {
            event.preventDefault();
            $('#submit-btn').trigger('click');
        }
    });

    $('#submit-btn').on('click', function () {
        const text = $('#answerText').val();
        if (sessionId && text) {
            let userAnswerDiv = $('<div>', {
                class: 'message-bubble',
                text: text
            });
            $('#user-answer-container').append(userAnswerDiv);
            const sampleDtoForAnswer = {
                sessionId: sessionId,
                questionType: questionType,
                answerText: text
            };
            $.ajax({
                url: 'http://121.43.138.108:8800/medical/qa',
                method: 'POST',
                data: JSON.stringify(sampleDtoForAnswer),
                contentType: 'application/json',
                processData: false,
                success: function (responseData) {
                    questionType = responseData.questionType;
                    sessionId = responseData.sessionId;

                    handleResponse(responseData);
                    $('#answerText').val('');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.error(textStatus, errorThrown);
                    alert('提交失败，请重试');
                }
            });

        } else {
            alert('请确保已输入答案文本');
        }
    });
}

function handleResponse(responseData) {
    if (responseData.question) {
        let serverResponseDiv = $('<div>', {
            class: 'message-bubble',
            text: responseData.question
        });
        $('#server-response-container').append(serverResponseDiv);
        $('.chat-container').animate({
            scrollTop: $('.chat-container')[0].scrollHeight
        }, 'fast');
    }
    if (responseData.question) {
        $('#question-container').text(responseData.question);
    } else {
        $('#question-container').empty();
    }

    if (responseData.questionType !== 'reports') {
        let formattedOptions = [];
        if (responseData.question === "其他部位有类似情况吗？") {
            for (const option of responseData.options) {
                let cleanOption = option.replace(/[{}\[\]"]+/g, '').trim();
                formattedOptions.push(`${cleanOption.charAt(0).toUpperCase()}${cleanOption.slice(1)} ${cleanOption.split(/\s+/).slice(1).join(' ')}`);
            }
            const optionsList = $('<ul>', {
                class: 'list-unstyled'
            });

            for (const formattedOption of formattedOptions) {
                const optionItem = $('<li>', {
                    class: 'option-item',
                    style: 'padding: 5px 10px; cursor: pointer;'
                }).text(formattedOption);

                optionItem.hover(
                    function () {
                        $(this).css('background-color', '#f0f0f0');
                    },
                    function () {
                        $(this).css('background-color', '');
                    }
                );

                optionsList.append(optionItem);
            }
            $('#option-list-container').empty().append(optionsList);
        } else if (responseData.options) {
            const optionsList = $('<ul>', {
                class: 'list-unstyled'
            });

            for (const option of responseData.options) {
                const optionItem = $('<li>', {
                    class: 'option-item',
                    style: 'padding: 5px 10px; cursor: pointer;'
                }).text(option);

                optionItem.hover(
                    function () {
                        $(this).css('background-color', '#f0f0f0');
                    },
                    function () {
                        $(this).css('background-color', '');
                    }
                );

                optionsList.append(optionItem);
            }
            $('#option-list-container').empty().append(optionsList);
        } else {
            $('#option-list-container').empty();
        }
    }
    if (responseData.questionType === 'reports') {
        const report = {
            allergies: JSON.parse(responseData.reports.allegries)[0],
            complications: JSON.parse(responseData.reports.complications)[0],
            diseaseCourse: JSON.parse(responseData.reports.diseaseCourse)[0],
            /* bbox: JSON.parse(responseData.reports.bbox),*/
            /*diagResultsEn: JSON.parse(responseData.reports.diagResultsEn),*/
            diagResults: JSON.parse(responseData.reports.diagResults),
            bodyParts: JSON.parse(responseData.reports.bodyParts)[0],
            symptoms: JSON.parse(responseData.reports.symptoms)[0],
            diseaseHistory: JSON.parse(responseData.reports.diseaseHistory)[0],
            medications: JSON.parse(responseData.reports.medications)[0],
            /*diagProbEn: JSON.parse(responseData.reports.diagProbEn),*/
            diagProb: JSON.parse(responseData.reports.diagProb),
            iqa_score: parseFloat(responseData.reports.iqa_score),
            age: JSON.parse(responseData.reports.age)[0]
        };
        const diagProb = report.diagProb;
        const maxEntry = Object.entries(diagProb).reduce((max, current) => {
            return parseFloat(current[1]) > parseFloat(max[1]) ? current : max;
        }, [null, -Infinity]);
        let reportNarrative = `您好根据Dr.T生成的诊断报告如下：\n\n`;
        reportNarrative += `这位患者年龄为：${report.age}岁。\n`;
        reportNarrative += `在过敏史方面，记录显示为：${report.allergies}。\n`;
        reportNarrative += `关于并发症情况，当前记录为：${report.complications}。\n`;
        reportNarrative += `患者的病程时间为：${report.diseaseCourse}。\n`;
        reportNarrative += `本次报告关注的身体部位为：${report.bodyParts}。\n`;
        reportNarrative += `症状描述显示为：${report.symptoms}。\n`;
        reportNarrative += `既往疾病史记录显示为：${report.diseaseHistory}。\n`;
        reportNarrative += `患者用药记录显示为：${report.medications}。\n`;
        reportNarrative += `症状的诊断概率数据为：${maxEntry[0]}。\n`;
        /* reportNarrative += `整体上，本次诊断的准确率为${report.iqa_score}%。\n`;*/
        reportNarrative += `应该怎么处理？\n\n`;
        console.log(reportNarrative)
        let serverResponseDiv;
        if ($('#server-response-div').length > 0) { // 如果该元素已经存在于DOM中
            serverResponseDiv = $('#server-response-div');
        } else { // 否则创建它
            serverResponseDiv = $('<div>', {
                id: 'server-response-div',
                class: 'server-response'
            });
            $('#server-response-container').append(serverResponseDiv); // 添加到容器
        }

        // 创建并添加报告内容的DOM元素
        let reportNarrativeDiv = $('<div>', {
            id: 'report-narrative',
            class: 'report-section'
        });
        const narrativeParagraph = $('<p>', {
            text: reportNarrative
        });
        reportNarrativeDiv.append(narrativeParagraph);

        // **将报告内容添加到server-response-container内部**
        $('#server-response-container').append(reportNarrativeDiv);

        // 创建并添加刷新按钮
        let refreshButton = $('<button>', {
            id: 'refresh-report-btn',
            class: 'button-refresh', // 添加类名用于引用CSS样式
            text: '重新生成'
        });
        refreshButton.click(function () {
            window.open('http://121.43.138.108/uploadImage-medQa.html');
        });

        // **将刷新按钮添加到报告内容下方**
        reportNarrativeDiv.append(refreshButton);

        // 创建并添加跳转按钮
        let jumpButton = $('<button>', {
            id: 'jump-to-detail-btn',
            class: 'button-jump', // 添加类名用于引用CSS样式
            text: '询问Dr.T'
        });
        jumpButton.click(function () {
            window.open('http://121.43.138.108/index.html?results=' + encodeURIComponent(reportNarrative), '_blank');
        });

        // **将跳转按钮添加到刷新按钮下方**
        reportNarrativeDiv.append(jumpButton);

        // 隐藏无关元素（如果需要）
        $('#answerText').hide();
        $('#image-container').hide();
        $('#modal-container').hide();
        $('#additional-buttons').hide();
    }
}
