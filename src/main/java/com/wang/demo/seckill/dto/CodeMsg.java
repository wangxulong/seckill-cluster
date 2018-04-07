package com.wang.demo.seckill.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CodeMsg {
    private int code;
    private String msg;

    /**
     * 通用异常
     */
    public static CodeMsg SUCCESS = new CodeMsg(0,"success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100,"服务器端异常");

    /**
     * 登录模块异常 500200
     */
    /**
     * 订单模块异常 500300
     */
}
