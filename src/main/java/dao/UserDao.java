package dao;

import model.User;

import java.util.HashMap;

public interface UserDao {

    User findByColumn(HashMap map);
}