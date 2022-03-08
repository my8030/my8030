import .AbstractController;
        import .NewUser;
        import .UserInfo;
        import .User;
        import .UserService;
       /** import org.slf4j.Logger;
       import org.slf4j.LoggerFactory;*/
        import .springframework.beans.factory.annotation.Autowired;
        import .springframework.http.HttpStatus;
        import .springframework.http.ResponseEntity;
        import .springframework.stereotype.Controller;
        import .springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * REST service for users.
 *
 * Created by Mohamed Mekkawy.
 */

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /**
     * Get user information
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public UserInfo getUserInfo(Principal principal) {

        User user = userService.findUserByUsername(principal.getName());

        return user != null ? new UserInfo(user.getUserName()) : null;
    }

    /**
     * Create new user
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@RequestBody NewUser user) {
        userService.createUser(user.getUsername(), user.getEmail(), user.getPlainTextPassword());
    }

}