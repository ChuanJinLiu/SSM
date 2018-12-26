package dao;

import model.PageService;
import model.Bill;

import java.util.HashMap;
import java.util.List;

public interface BillDao {

    /**
     * Mapper代理 根据字段和值查询一条数据
     *
     * @param map
     * @return
     */
    Bill findByColumn(HashMap map);

    /**
     * Mapper代理 查询全部的Bill数据
     *
     * @return
     */
    List<Bill> findList();

    /**
     * 添加用户信息
     *
     * @param bill
     */
    public void addBill(Bill bill);

    /**
     * 条件+分页查询 用户信息
     */
    public List<Bill> findBillPage(PageService pageService);

    /**
     * 获取总记录数
     */
    public int getCountByName(String name);

    /**
     * 根据id删除用户信息
     */
    public void delBillById(int id);

    /**
     * 根据id查询用户信息
     */
    public Bill findBillById(int id);

    /**
     * 修改用户信息
     */
    public void updateBillById(Bill bill);

    /**
     * 多条删除
     */
    public void delsBill(List<Integer> list);
}