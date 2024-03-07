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
import java.io.InputStream;
import java.util.Base64;
import java.util.Map;

import org.apache.commons.io.IOUtils;

@RestController
public class SignUpController {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/home")
    public String home() {
        return "Welcome to the Home Page";
    }

    @PostMapping("/shiokjobs/auth/ConfirmSignup")
    public ResponseEntity<Map<String, Object>> confirmSignUp() throws IOException {
        return ResponseEntity.badRequest().body(readJsonFile("confirm-signup-success.json"));
    }

    @PostMapping("/shiokjobs/auth/SignUp")
    public ResponseEntity<Map<String, Object>> signUp() throws IOException {
        return ResponseEntity.ok(readJsonFile("signup-success.json"));
    }

    private Map<String, Object> readJsonFile(String fileName) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:static/" + fileName); // Use classpath notation
        String content = "";
        try (InputStream inputStream = resource.getInputStream()) {
            content = new String(IOUtils.toByteArray(inputStream));
        }
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonData = mapper.readValue(content, Map.class);
        return jsonData;
    }

    private byte[] readJsonFileEncoded(String fileName) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:static/" + fileName); // Use classpath notation
        try (InputStream inputStream = resource.getInputStream()) {
            byte[] content = IOUtils.toByteArray(inputStream);
            return Base64.getEncoder().encode(content);  // Encode using Base64
        }
    }

}
