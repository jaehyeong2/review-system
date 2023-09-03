package jjfactory.common.global.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@Data
public class CommonResponse<T> {
    private int code;
    private T data;

    public CommonResponse(T data) {
        this.data = data;
        this.code = HttpStatus.OK.value();
    }

    public static CommonResponse ok() {
        return CommonResponse
                .builder()
                .code(HttpStatus.OK.value())
                .build();
    }
}
