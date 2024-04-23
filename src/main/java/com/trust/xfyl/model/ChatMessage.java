package com.trust.xfyl.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 会话记录
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
@Data
@ToString
public class ChatMessage implements Serializable {
    private static final long serialVersionUID = -3470843417163463759L;

    private String user;

    private String assistant;
}
