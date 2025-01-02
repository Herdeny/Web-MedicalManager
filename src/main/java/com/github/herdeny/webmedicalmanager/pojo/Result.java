package com.github.herdeny.webmedicalmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer result;
    private String message;
    private T data;

    public static <E> Result<E> success(E data) {
        return new Result<>(0, "success", data);
    }

    public static <E> Result<E> success() {
        return new Result<>(1, "success", null);
    }

    public static <E> Result<E> fail(int code){
        return new Result<>(code, "fail", null);
    }

    public static <E> Result<E> fail(int code, String message){
        return new Result<>(code, message, null);
    }

}
