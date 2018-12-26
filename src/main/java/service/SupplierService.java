package service;

import model.Supplier;
import model.PageService;

import java.util.List;

public interface SupplierService {

    /**
     * 根据字段和值查询一条数据
     *
     * @param column
     * @param key
     * @return
     */
    Supplier findByColumn(String column, String key);

    /**
     * 查询Supplier表的全部数据
     *
     * @return
     */
    List<Supplier> findList();

    /**
     * 添加用户信息
     *
     * @param Supplier
     */
    public void addSupplier(Supplier Supplier);

    /**
     * 根据id删除用户信息
     */
    public void delSupplierById(int id);

    /**
     * 修改用户信息
     */
    public void updateSupplierById(Supplier Supplier);

    /**
     * 多条删除
     */
    public void delsSupplier(List<Integer> list);

    /**
     * 获取总记录数
     */
    public int getCountByName(String name);

    /**
     * 条件+分页查询 用户信息
     */
    public List<Supplier> findSupplierPage(PageService pageService);

}