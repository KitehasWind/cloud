package com.cloud.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/info")
public class SomeController {

    private static final Logger log = LoggerFactory.getLogger(SomeController.class);

    @RequestMapping("/header")
    public String getHeader(HttpServletRequest request){
        StringBuilder builder = new StringBuilder();
        builder.append("just start : ");
        String header = request.getHeader("X-Request-Color");
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.entrySet().stream().forEach(stringEntry -> {
            String[] value = stringEntry.getValue();
            if (value != null && value.length>0){
                builder.append(stringEntry.getKey()).append(":").append(0);
            }
        });
        if (!StringUtils.isEmpty(header)){
            builder.append("Header : ").append(header);
        }

        return builder.toString();

    }

}


