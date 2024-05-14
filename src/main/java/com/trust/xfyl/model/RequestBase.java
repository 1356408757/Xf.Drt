package com.trust.xfyl.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
@Data
@ToString
public class RequestBase implements Serializable {
    private static final long serialVersionUID = -3372275118743867054L;

    /**
     * request id
     */
    private String requestId;
}
