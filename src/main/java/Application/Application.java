package Application;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ASUS on 2018-11-08.
 */
public class Application {

    @Autowired
    private static UserDao dao;

    public static void main(String[] args) {
        // 读取  配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
        long id = 1;

    }
}
