package jjfactory.api.user.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateRequest{
        private Long teamId;
        private String name;
        private String username;
        private String email;
        private String employeeNumber;
    }
}
