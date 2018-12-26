package controller;

import model.PageService;
import model.Bill;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.BillService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Resource
    private BillService billService;


    /**
     * Bill列表
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    Map findBillList(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        pageService.setTotal(billService.getCountByName(pname));
        List<Bill> model = billService.findBillPage(pageService);
        Map map = new HashMap();
        map.put("bills", model);
        map.put("total", pageService.getTotal());
        return map;
    }

    /**
     * 新增Bill
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody
    void addBill(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        //告诉浏览器编码方式
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        Bill bill = new Bill();
        bill.setName(request.getParameter("name"));
        bill.setType(request.getParameter("type"));
        bill.setNumber(request.getParameter("number"));
        bill.setStatus("1");
        billService.addBill(bill);
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
    void deleteBill(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        //告诉浏览器编码方式
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        billService.delBillById(Integer.parseInt(request.getParameter("id")));
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
    void delBills(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        billService.delsBill(list);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public @ResponseBody
    void updateBill(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        //告诉浏览器编码方式
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        Bill bill = billService.findByColumn("id", request.getParameter("id"));
        if (bill != null) {
            bill.setName(request.getParameter("name"));
            bill.setType(request.getParameter("type"));
            bill.setNumber(request.getParameter("number"));
            bill.setStatus(request.getParameter("status"));
            bill.setCreateTime(request.getParameter("createTime"));
        }
        billService.updateBillById(bill);
    }
}