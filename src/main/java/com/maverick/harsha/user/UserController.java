package com.maverick.harsha.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;

/**
 * Created by Harsha on 2/22/2017.
 */

public class UserController {

    private UserService userService;
    private final EntityLinks entityLinks;

    public UserController(UserService userService, EntityLinks entityLinks) {
        this.userService = userService;
        this.entityLinks = entityLinks;
    }
}
