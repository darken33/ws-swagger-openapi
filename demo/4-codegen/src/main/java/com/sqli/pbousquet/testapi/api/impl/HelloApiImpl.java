package com.sqli.pbousquet.testapi.api.impl;

import com.sqli.pbousquet.testapi.dto.HelloDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Hello", description = "the Hello API", tags = {"hello"})
public class HelloApiImpl implements com.sqli.pbousquet.testapi.api.HelloApi {

    @Override
    public ResponseEntity<HelloDto> helloUsingGET1() {
        HelloDto result = new HelloDto();
        result.setMessage("Hello World");
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<HelloDto> helloUsingGET(String name) {
        HelloDto result = new HelloDto();
        result.setMessage("Hello "+name);
        return ResponseEntity.ok(result);
    }
}
