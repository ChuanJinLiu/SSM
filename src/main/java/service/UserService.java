package service;

import model.PageService;
import model.User;

import java.util.List;

public interface UserService {

    /**
     * 根据字段和值查询一条数据
     *
     * @param column
     * @param key
     * @return
     */
    User findByColumn(String column, String key);

    /**
     * 查询user表的全部数据
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
     * 根据id删除用户信息
     */
    public void delUserById(int id);

    /**
     * 修改用户信息
     */
    public void updateUserById(User user);

    /**
     * 多条删除
     */
    public void delsUser(List<Integer> list);

    /**
     * 获取总记录数
     */
    public int getCountByName(String name);

    /**
     * 条件+分页查询 用户信息
     */
    public List<User> findUserPage(PageService pageService);

}