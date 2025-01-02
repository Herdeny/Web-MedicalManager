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

    public Result(int result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public static <E> Result<E> success(E data) {
        return new Result<>(0, "success", data);
    }

    public static <E> Result<E> success() {
        return new Result<>(0, "success", null);
    }

    public static <E> Result<E> fail(String msg) {
        return new Result<>(420, msg, null);
    }

    public static <E> Result<E> fail(int code, String msg) {
        return new Result<>(code, msg, null);
    }

    public static <E> Result<E> fail(int code) {
        return new Result<>(code, null, null);
    }
}