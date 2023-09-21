package jjfactory.admin.user.presentation;

import jjfactory.admin.user.application.UserFacade;
import jjfactory.admin.user.presentation.dto.UserDto;
import jjfactory.admin.user.presentation.dto.UserDtoMapper;
import jjfactory.common.global.response.CommonResponse;
import jjfactory.common.user.domain.UserCommand;
import jjfactory.common.user.domain.UserCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserFacade userFacade;
    private final UserDtoMapper userDtoMapper;

    @GetMapping("/{id}")
    public CommonResponse<UserDto.DetailResponse> getDetail(@PathVariable Long id) {
        return new CommonResponse<>(userDtoMapper.of(userFacade.getDetail(id)));
    }

    @GetMapping
    public Page<UserDto.ListResponse> getList(@PageableDefault Pageable pageable, UserCondition condition) {
        return userFacade.getList(pageable, condition).map(userDtoMapper::of);
    }

    @PostMapping
    public CommonResponse enroll(@RequestBody UserCommand.Create command) {
        userFacade.enroll(command);
        return CommonResponse.ok();
    }

    @PutMapping("/{id}")
    public CommonResponse<Long> modify(@PathVariable Long id, @RequestBody UserCommand.Update command) {
        return new CommonResponse<>(userFacade.modify(id, command));
    }
}
