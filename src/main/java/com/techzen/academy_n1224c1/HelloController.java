package com.techzen.academy_n1224c1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello") //API, endpoint // https://localhost:8080/hello
    //http://localhost:8080/hello?name=Nguyen%20Van%20A&address=Da%20Nang
    public String greeting(@RequestParam(defaultValue = "Moc") String name,
                           @RequestParam(defaultValue = "Da Nang")String address) {
        return "Hello World " + name + " - " + address;
    }
}


