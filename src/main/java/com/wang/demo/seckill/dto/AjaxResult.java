package com.wang.demo.seckill.dto;

import lombok.Data;

@Data
public class AjaxResult<T> {
    private int code;
    private String msg;
    private T data;

    /**
     * 成功时候调用
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> AjaxResult<T> success(T data) {
        return new AjaxResult<>(data);
    }

    /**
     * 失败调用
     *
     * @param codeMsg
     * @param <T>
     * @return
     */
    public static <T> AjaxResult<T> error(CodeMsg codeMsg) {
        return new AjaxResult<T>(codeMsg);
    }

    private AjaxResult(CodeMsg codeMsg) {
        if (null == codeMsg) {
            return;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }

    private AjaxResult(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }
}
