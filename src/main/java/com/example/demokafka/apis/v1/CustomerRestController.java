package com.example.demokafka.apis.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/v1/customers")
public class CustomerRestController {

    @GetMapping
    public String getCustomers() {
        return "Diego Lirio";
    }

}
