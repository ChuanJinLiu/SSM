package dao;

import model.PageService;
import model.User;

import java.util.List;
import java.util.HashMap;

public interface UserDao {

    /**
     * Mapper代理 根据字段和值查询一条数据
     *
     * @param map
     * @return
     */
    User findByColumn(HashMap map);

    /**
     * Mapper代理 查询全部的User数据
     *
     * @return
     */
    List<User> findList();

    /**
     * 添加用户信息
     *
     * @param user
     */
    public void addUser(User user);

    /**
     * 条件+分页查询 用户信息
     */
    public List<User> findUserPage(PageService pageService);

    /**
     * 获取总记录数
     */
    public int getCountByName(String name);

    /**
     * 根据id删除用户信息
     */
    public void delUserById(int id);

    /**
     * 根据id查询用户信息
     */
    public User findUserById(int id);

    /**
     * 修改用户信息
     */
    public void updateUserById(User user);

    /**
     * 多条删除
     */
    public void delsUser(List<Integer> list);
}