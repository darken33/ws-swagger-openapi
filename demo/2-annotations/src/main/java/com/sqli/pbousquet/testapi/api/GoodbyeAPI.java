package com.sqli.pbousquet.testapi.api;

import com.sqli.pbousquet.testapi.dto.GoodbyeDto;
import com.sqli.pbousquet.testapi.dto.HelloDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v1/goodbye"})
public class GoodbyeAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodbyeAPI.class);

    @GetMapping
    public ResponseEntity<GoodbyeDto> goodbye() {
        LOGGER.info("GET /api/v1/goodbye");
        return goodbye(null);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<GoodbyeDto> goodbye(@PathVariable String name) {
        if (name != null) LOGGER.info("GET /api/v1/goodbye/"+name);
        GoodbyeDto result = new GoodbyeDto();
        result.setMessage("Goodbye World");
        if (name != null) {
            if ("123".equals(name)) {
                return ResponseEntity.badRequest().build();
            }
            result.setMessage("Goodbye " + name);
        }
        LOGGER.info("Response : "+result.getMessage());
        return ResponseEntity.ok(result);
    }
}
