package cc.ryanc.halo.web.controller.portal.api;

import cc.ryanc.halo.model.dto.UserOutputDTO;
import cc.ryanc.halo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Portal user controller.
 *
 * @author johnniang
 * @date 4/3/19
 */
@RestController("PortalUserController")
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("profile")
    @ApiOperation("Gets blogger profile")
    public UserOutputDTO getProfile() {
        return userService.getCurrentUser().map(user -> new UserOutputDTO().<UserOutputDTO>convertFrom(user)).get();
    }
}