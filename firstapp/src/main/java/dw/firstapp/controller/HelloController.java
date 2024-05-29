package dw.firstapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/sayhello") // 주소를 맵핑함
    public String hello() {
        return "Hello world!";
    }
}
