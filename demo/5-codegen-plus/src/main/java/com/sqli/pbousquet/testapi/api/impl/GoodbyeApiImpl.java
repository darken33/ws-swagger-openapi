package com.sqli.pbousquet.testapi.api.impl;

import com.sqli.pbousquet.testapi.api.GoodbyeApi;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Goodbye", description = "the Goodbye API", tags = {"goodbye"})
public class GoodbyeApiImpl implements GoodbyeApi {
}
