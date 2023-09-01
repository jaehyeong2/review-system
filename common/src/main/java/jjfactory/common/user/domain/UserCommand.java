package jjfactory.common.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserCommand {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        private Long teamId;
        private String name;
        private String username;
        private String email;
        private String employeeNumber;

        public User toEntity(){
            return User.builder()
                    .name(name)
                    .email(email)
                    .employeeNumber(employeeNumber)
                    .teamId(teamId)
                    .username(username)
                    .build();
        }
    }
}
