package com.risingcamp.grittest.controller.auth;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Home", description = "OAuth2 카카오 로그인 후 리다이렉션 페이지")
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "OAuth2 Login 성공!!!!";
    }
}
