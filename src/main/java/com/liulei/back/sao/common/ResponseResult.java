package com.liulei.back.sao.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.util.annotation.Nullable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult {
    private int code;
    private String message;
    private Object data;

    public static ResponseResult success(@Nullable Object data) {
        return ResponseResult.builder()
                .code(0)
                .message("ok")
                .data(data)
                .build();
    }

    public static ResponseResult success() {
        return ResponseResult.builder()
                .code(0)
                .message("ok")
                .build();
    }

    public static ResponseResult error(int code,String message,@Nullable Object data) {
        return ResponseResult.builder()
                .code(code)
                .message(message)
                .data(data)
                .build();
    }
}
