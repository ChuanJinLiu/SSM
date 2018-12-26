package controller;

import model.Supplier;
import model.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SupplierService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Resource
    private SupplierService supplierService;


    /**
     * Supplier列表
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    Map findSupplierList(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        pageService.setTotal(supplierService.getCountByName(pname));
        List<Supplier> model = supplierService.findSupplierPage(pageService);
        for (Supplier u : model) {
            System.out.println(u.toString());
        }
        Map map = new HashMap();
        map.put("suppliers", model);
        map.put("total", pageService.getTotal());
        return map;
    }

    /**
     * 新增Supplier
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody
    void addSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        //告诉浏览器编码方式
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        Supplier supplier = new Supplier();
        supplier.setName(request.getParameter("name"));
        supplier.setType(request.getParameter("type"));
        supplier.setAddr(request.getParameter("addr"));
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        supplier.setCreateTime(format.format(date));
        supplier.setStatus("1");
        supplierService.addSupplier(supplier);
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
    void deleteSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        //告诉浏览器编码方式
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        supplierService.delSupplierById(Integer.parseInt(request.getParameter("id")));
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
    void delSuppliers(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        supplierService.delsSupplier(list);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public @ResponseBody
    void updateSupplier(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        //告诉浏览器编码方式
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        Supplier supplier = supplierService.findByColumn("id", request.getParameter("id"));
        if (supplier != null) {
            supplier.setName(request.getParameter("name"));
            supplier.setType(request.getParameter("type"));
            supplier.setAddr(request.getParameter("addr"));
            supplier.setStatus(request.getParameter("status"));
        }
        supplierService.updateSupplierById(supplier);
    }
}