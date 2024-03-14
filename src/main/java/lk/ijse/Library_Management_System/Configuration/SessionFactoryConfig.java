package lk.ijse.Library_Management_System.Configuration;

import lk.ijse.Library_Management_System.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig(){
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("Hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Configuration configuration = new Configuration();
        configuration.mergeProperties(properties);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Admin.class);
        configuration.addAnnotatedClass(Branch.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Transaction.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static SessionFactoryConfig getInstance(){
        return (factoryConfig == null) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
