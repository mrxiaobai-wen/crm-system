package com.crm.goods.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 控制层通用结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    /**
     * 业务正常且无返回数据
     */
    public static Result ok() {
        return new Result(0,null,null);
    }

    /**
     * 业务正常且有返回数据
     */
    public static <T> Result<T> ok(T data) {
        return new Result<T>(0,null,data);
    }
}
