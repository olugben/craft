package net.hammed.craft.admin;

import java.util.List;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import net.hammed.craft.user.User;

import net.hammed.craft.user.UserService;

@RestController

@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping("/viewallendpoints")
    public List<User> listAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/manage")
    public String manageUsers() {
        return "Admin can manage users";
    }

    @GetMapping("/settings")
    public String accessSettings() {
        return "Admin can access settings";
    }

}
