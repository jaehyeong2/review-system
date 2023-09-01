package jjfactory.common.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class UserInfo {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailResponse{
        private Long teamId;
        private String name;
        private String username;
        private String email;
        private String employeeNumber;
        private boolean isValid = true;
        private LocalDateTime invalidDt;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListResponse{
        private Long teamId;
        private String name;
        private String username;
        private String email;
        private String employeeNumber;
    }

}
