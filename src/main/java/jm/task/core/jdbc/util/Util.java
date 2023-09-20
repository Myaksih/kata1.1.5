package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.imageio.spi.ServiceRegistry;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root1";

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){

        return new Configuration()
            .setProperty(Environment.DRIVER, DB_DRIVER)
            .setProperty(Environment.URL, DB_URL)
            .setProperty(Environment.USER, DB_USER)
            .setProperty(Environment.PASS,DB_PASSWORD)
            .addAnnotatedClass(User.class).buildSessionFactory();


    }



    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
