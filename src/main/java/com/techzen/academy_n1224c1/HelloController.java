package com.techzen.academy_n1224c1;

import com.techzen.academy_n1224c1.dto.ApiReponse;
import com.techzen.academy_n1224c1.exception.ApiException;
import com.techzen.academy_n1224c1.exception.ErrorCode;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {
    @RequestMapping("/hello") //API, endpoint // https://localhost:8080/hello
    //http://localhost:8080/hello?name=Nguyen%20Van%20A&address=Da%20Nang
    public String greeting(@RequestParam(defaultValue = "Moc") String name,
                           @RequestParam(defaultValue = "Da Nang")String address) {
        return "Hello World " + name + " - " + address;
    }
}


