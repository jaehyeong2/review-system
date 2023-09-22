package jjfactory.common.global.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@NoArgsConstructor
@Data
public class CommonPagingResponse<T> {
    private Page<T> data;

    public CommonPagingResponse(Page<T> data) {
        this.data = data;
    }
}
