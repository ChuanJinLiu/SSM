package controller;

import javax.servlet.http.HttpServletRequest;

import model.User;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody
    User login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        //告诉浏览器编码方式
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        System.out.println("name: " + request.getParameter("username"));
        System.out.println("pwd: " + request.getParameter("password"));
        User model = userService.findByColumn("name", request.getParameter("username"));
        if (model != null) {
            if (!model.getPassword().equals(request.getParameter("password"))) {
                model = new User();
            }
        } else {
            model = new User();
        }
        System.out.println(model.toString());
        return model;
    }

    @RequestMapping("/home")
    public String homeHandler() {
        return "home";
    }

    @RequestMapping("/test")
    public String testHandler() {
        return "test";
    }

    /**
     * 使用JSON作为响应内容
     */

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getperson/{userID}", method = RequestMethod.GET)
    public @ResponseBody
    User getPerson(@PathVariable long userID) {
        User p = new User();
        p.setName("Eric");
        p.setId(userID);
        return p;
    }

}