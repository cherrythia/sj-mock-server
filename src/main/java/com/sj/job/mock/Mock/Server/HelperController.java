package com.sj.job.mock.Mock.Server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Component
public class HelperController {

    @Autowired
    private ResourceLoader resourceLoader;
    public Map<String, Object> readJsonFile(String fileName) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:static/" + fileName); // Use classpath notation
        String content = "";
        try (InputStream inputStream = resource.getInputStream()) {
            content = new String(IOUtils.toByteArray(inputStream));
        }
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonData = mapper.readValue(content, Map.class);
        return jsonData;
    }
}
