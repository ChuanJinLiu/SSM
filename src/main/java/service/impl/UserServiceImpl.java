package service.impl;

import dao.UserDao;
import model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
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
        System.out.println("column: " + map.get("column"));
        System.out.println("key: " + map.get("key"));
        return this.userDao.findByColumn(map);
    }

}
