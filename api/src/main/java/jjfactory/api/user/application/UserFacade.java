package jjfactory.api.user.application;

import jjfactory.common.user.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserFacade {
    private final UserService userService;


}
