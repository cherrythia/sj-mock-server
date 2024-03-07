package com.sj.job.mock.Mock.Server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private HelperController helperController;

    @PostMapping("shiokjobs/auth/Login")
    public ResponseEntity<Map<String, Object>> login() throws IOException {
        return ResponseEntity.ok(helperController.readJsonFile("login-success.json"));
    }
}
