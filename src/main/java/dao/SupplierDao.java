package dao;

import model.Supplier;
import model.PageService;

import java.util.HashMap;
import java.util.List;

public interface SupplierDao {

    /**
     * Mapper代理 根据字段和值查询一条数据
     *
     * @param map
     * @return
     */
    Supplier findByColumn(HashMap map);

    /**
     * Mapper代理 查询全部的Supplier数据
     *
     * @return
     */
    List<Supplier> findList();

    /**
     * 添加用户信息
     *
     * @param supplier
     */
    public void addSupplier(Supplier supplier);

    /**
     * 条件+分页查询 用户信息
     */
    public List<Supplier> findSupplierPage(PageService pageService);

    /**
     * 获取总记录数
     */
    public int getCountByName(String name);

    /**
     * 根据id删除用户信息
     */
    public void delSupplierById(int id);

    /**
     * 根据id查询用户信息
     */
    public Supplier findSupplierById(int id);

    /**
     * 修改用户信息
     */
    public void updateSupplierById(Supplier supplier);

    /**
     * 多条删除
     */
    public void delsSupplier(List<Integer> list);
}