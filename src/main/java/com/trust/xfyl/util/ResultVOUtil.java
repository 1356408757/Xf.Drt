package com.trust.xfyl.util;


import com.trust.xfyl.entity.ResultVO;
import com.trust.xfyl.enums.ResultEnum;

/**
 * json返回通用格式
 *
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/
public class ResultVOUtil {

    /**
     * 成功返回json
     *
     * @param object
     * @return ResultVO
     */
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setStatus(ResultEnum.SUCCESS.getStatus());
        resultVO.setMsg(ResultEnum.SUCCESS.getMessage());
        return resultVO;
    }

    /**
     * 成功返回json
     *
     * @return ResultVO
     */
    public static ResultVO success() {
        return success(null);
    }


    /**
     * 失败返回json
     *
     * @param status
     * @param msg
     * @return ResultVO
     */
    public static ResultVO error(int status, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setStatus(status);
        resultVO.setMsg(msg);
        return resultVO;
    }

    /**
     * 失败返回json
     *
     * @param msg
     * @return ResultVO
     */
    public static ResultVO error(String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setStatus(ResultEnum.FAIL.getStatus());
        resultVO.setMsg(msg);
        return resultVO;
    }


}

