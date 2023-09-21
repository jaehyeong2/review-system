package jjfactory.admin.user.application;

import jjfactory.common.user.domain.UserCommand;
import jjfactory.common.user.domain.UserCondition;
import jjfactory.common.user.domain.UserInfo;
import jjfactory.common.user.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserFacade {
    private final UserService userService;

    public UserInfo.DetailResponse getDetail(Long id){
        return userService.get(id);
    }

    public Page<UserInfo.ListResponse> getList(Pageable pageable, UserCondition condition){
        return userService.getAllUsers(pageable, condition);
    }

    public void enroll(UserCommand.Create command){
        userService.create(command);
    }

    public Long modify(Long id, UserCommand.Update command){
        return userService.update(command, id);
    }
}
