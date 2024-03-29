package com.yanleweb.sell.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = 7769130632509521731L;
    private Integer code;

    private String msg;

    private T data;
}
