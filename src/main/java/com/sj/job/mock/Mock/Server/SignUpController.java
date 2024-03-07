package com.sj.job.mock.Mock.Server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class SignUpController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private HelperController helperController;

    @Autowired
    public SignUpController(HelperController helperController) {
        this.helperController = helperController;
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to the Home Page";
    }

    @PostMapping("/shiokjobs/auth/ConfirmSignup")
    public ResponseEntity<Map<String, Object>> confirmSignUp() throws IOException {
        return ResponseEntity.ok(helperController.readJsonFile("confirm-signup-success.json"));
    }

    @PostMapping("/shiokjobs/auth/SignUp")
    public ResponseEntity<Map<String, Object>> signUp() throws IOException {
        return ResponseEntity.ok(helperController.readJsonFile("signup-success.json"));
    }



}
