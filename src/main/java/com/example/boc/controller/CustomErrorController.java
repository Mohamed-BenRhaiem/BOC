package com.example.boc.controller;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Handle errors here, return a custom error page or response
        return "error"; // Assuming you have an "error.html" template
    }

   public String getErrorPath() {
        return "/error";
    }
}
