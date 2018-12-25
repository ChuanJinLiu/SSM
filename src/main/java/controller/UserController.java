package controller;

import javax.servlet.http.HttpServletRequest;

import model.PageService;
import model.User;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 登录
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
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
        User model = userService.findByColumn("name", request.getParameter("username"));
        if (model != null) {
            if (!model.getPassword().equals(request.getParameter("password")) || model.getStatus().equals("0")) {
                model = new User();
            }
        } else {
            model = new User();
        }
        return model;
    }

    /**
     * User列表
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    Map findUserList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        //告诉浏览器编码方式
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        String pname = request.getParameter("name");
        String nowPage = request.getParameter("page");
        if (pname == null || pname == "".trim()) {
            pname = "%%";
        } else {
            pname = "%" + pname + "%";
        }
        int np = 1;
        if (nowPage != null && !nowPage.equals("".trim())) {
            np = Integer.parseInt(nowPage);
        }
        PageService pageService = new PageService();
        pageService.setPname(pname);
        pageService.setNowPage(np);
        pageService.setTotal(userService.getCountByName(pname));
        List<User> model = userService.findUserPage(pageService);
        for (User u : model) {
            System.out.println(u.toString());
        }
        Map map = new HashMap();
        map.put("users", model);
        map.put("total", pageService.getTotal());
        return map;
    }

    /**
     * 新增User
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody
    void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        //告诉浏览器编码方式
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setAddr(request.getParameter("addr"));
        user.setBirth(request.getParameter("birth"));
        user.setPhone(request.getParameter("phone"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        user.setCreateTime(format.format(date));
        user.setStatus("1");
        userService.addUser(user);
    }

    /**
     * 根据id删除1条数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public @ResponseBody
    void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        //告诉浏览器编码方式
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        userService.delUserById(Integer.parseInt(request.getParameter("id")));
    }

    /**
     * 删除多条数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/batchremove", method = RequestMethod.GET)
    public @ResponseBody
    void delUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        //告诉浏览器编码方式
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        String ids = request.getParameter("ids");
        String[] split = ids.split(",");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < split.length; i++) {
            list.add(new Integer(split[i]));
        }
        userService.delsUser(list);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public @ResponseBody
    void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        //告诉浏览器编码方式
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        User user = userService.findByColumn("id", request.getParameter("id"));
        if (user != null) {
            user.setName(request.getParameter("name"));
            user.setPassword(request.getParameter("password"));
            user.setAddr(request.getParameter("addr"));
            user.setBirth(request.getParameter("birth"));
            user.setPhone(request.getParameter("phone"));
            user.setAge(Integer.parseInt(request.getParameter("age")));
            user.setStatus(request.getParameter("status"));
        }
        userService.updateUserById(user);
    }
}