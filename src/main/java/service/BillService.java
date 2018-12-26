package service;

import model.PageService;
import model.Bill;

import java.util.List;

public interface BillService {

    /**
     * 根据字段和值查询一条数据
     *
     * @param column
     * @param key
     * @return
     */
    Bill findByColumn(String column, String key);

    /**
     * 查询Bill表的全部数据
     *
     * @return
     */
    List<Bill> findList();

    /**
     * 添加用户信息
     *
     * @param Bill
     */
    public void addBill(Bill Bill);

    /**
     * 根据id删除用户信息
     */
    public void delBillById(int id);

    /**
     * 修改用户信息
     */
    public void updateBillById(Bill Bill);

    /**
     * 多条删除
     */
    public void delsBill(List<Integer> list);

    /**
     * 获取总记录数
     */
    public int getCountByName(String name);

    /**
     * 条件+分页查询 用户信息
     */
    public List<Bill> findBillPage(PageService pageService);

}