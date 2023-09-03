package jjfactory.common.global.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@Data
public class ErrorResponse<T> {
    private int code;
    private String message;
}
