package dao.Jdbc;

import model.Supermarket;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * 链接数据库对象
 */
public class Jdbc {
    /**
     * JDBC 驱动名及数据库 URL
     */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ssm";

    /**
     * 数据库的用户名与密码，需要根据自己的设置
     */
    private static final String USER = "root";
    private static final String PASS = "root";

    /**
     * SQL语句
     */
    private String sql;

    /**
     * 创建statement类对象，用来执行SQL语句
     */
    private Statement statement;

    /**
     * 创建PreparedStatement类对象，预编译
     */
    private PreparedStatement preparedStatement;

    /**
     * ResultSet类，用来存放获取的结果集
     */
    private ResultSet rs;
    private Connection con;

    /**
     * 构造方法，连接数据库驱动
     */
    public Jdbc() {
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = con.createStatement();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e1) {
            // 处理 Class.forName 错误
            e1.printStackTrace();
        } finally {
            // 提示语句
            System.out.println("连接数据库成功！\n");
        }
    }

    /**
     * 读表数据
     */
    public ResultSet findAll() {
        try {
            // 将其他字符串接到尾巴
            sql = "select * from supermarket";
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 删除数据
     */
    public boolean delete(int id) {
        try {
            sql = "DELETE FROM supermarket WHERE id = " + id;
            System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据ID查询整条数据
     */
    public ResultSet findById(int id) {
        try {
            sql = "SELECT * FROM supermarket WHERE id = " + id;
            System.out.println(sql);
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 添加数据
     */
    public boolean add(Supermarket model) {
        try {
            sql = "insert into supermarket (name,manager,thing,addr,num) values (?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getManager());
            preparedStatement.setString(3, model.getThing());
            preparedStatement.setInt(4, model.getNum());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 修改数据
     */
    public boolean update(Supermarket model) {
        try {
            sql = "update supermarket set name=?,manager=?,thing=?,addr=?,num=? where id_=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getManager());
            preparedStatement.setString(3, model.getThing());
            preparedStatement.setInt(4, model.getNum());
            preparedStatement.setInt(5, model.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 关闭驱动
     */
    public void close() {
        try {
            con.close();
            if (con.isClosed()) {
                System.out.println("已经关闭数据库......");
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}
