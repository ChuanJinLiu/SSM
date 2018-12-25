package service.impl;

import dao.UserDao;
import model.PageService;
import model.User;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public User findByColumn(String column, String key) {
        HashMap map = new HashMap();
        map.put("column", column);
        map.put("key", "'" + key + "'");
        return this.userDao.findByColumn(map);
    }

    @Override
    public List<User> findList() {
        return this.userDao.findList();
    }

    @Override
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    public void delUserById(int id) {
        this.userDao.delUserById(id);
    }

    @Override
    public void updateUserById(User user) {
        this.userDao.updateUserById(user);
    }

    @Override
    public void delsUser(List<Integer> list) {
        this.userDao.delsUser(list);
    }

    @Override
    public int getCountByName(String name) {
        return this.userDao.getCountByName(name);
    }

    @Override
    public List<User> findUserPage(PageService pageService) {
        return this.userDao.findUserPage(pageService);
    }
}
