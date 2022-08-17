package com.sqli.pbousquet.testapi.api;

import com.sqli.pbousquet.testapi.dto.HelloDto;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v1/hello"})
@Api("/api/v1/hello")
public class HelloAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloAPI.class);

    @GetMapping
    @ApiOperation(value = "Saluer le monde", response = HelloDto.class, position = 2)
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
    })
    public ResponseEntity<HelloDto> hello() {
        LOGGER.info("GET /api/v1/hello");
        return hello(null);
    }

    @GetMapping(path = "/{name}")
    @ApiOperation(value = "Saluer une personne en particulier", response = HelloDto.class, position = 1)
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Mauvaise requête, 123 n'est pas une valeurs valide")
    })
    public ResponseEntity<HelloDto> hello(@ApiParam(required = true, name = "name", value = "Nom de la personne à saluer") @PathVariable String name) {
        if (name != null) LOGGER.info("GET /api/v1/hello/"+name);
        HelloDto result = new HelloDto();
        result.setMessage("Hello World");
        if (name != null) {
            if ("123".equals(name)) {
                return ResponseEntity.badRequest().build();
            }
            result.setMessage("Hello " + name);
        }
        LOGGER.info("Response : "+result.getMessage());
        return ResponseEntity.ok(result);
    }
}
