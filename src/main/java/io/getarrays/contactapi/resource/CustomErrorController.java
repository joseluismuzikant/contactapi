package io.getarrays.contactapi.resource;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/user/error")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        // You can customize the error message or return a view name here
        return "An error occurred. Please try again later.";
    }
    
    public String getErrorPath() {
        return "/user/error";
    }
}
