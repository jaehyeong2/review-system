package jjfactory.common.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCondition {
    private String employeeNumber;
    private String name;
    private String teamName;
    private String organizationName;
}
