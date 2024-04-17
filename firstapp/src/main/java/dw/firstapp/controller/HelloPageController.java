package dw.firstapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 정해진 주소에 따라서 내용을 불러옴
public class HelloPageController {
    @GetMapping("/hello")
    public String hello() {return "redirect:/hello.html";}  // redirect폴더에 있는 /hello.html 불러옴
}
