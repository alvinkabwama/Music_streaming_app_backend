package edu.miu.cs.alvin.music_streaming_app_backend.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/public")
    public String publicApi() {
        return "This is a public API";
    }

    @GetMapping("/admin")
    public String adminApi() {
        return "This is an admin API";
    }

    @GetMapping("/user")
    public String userApi() {
        return "This is a user API";
    }
}