package com.infotech.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {

    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        Map<String, String> dbSettings = new HashMap<>();
        dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
        dbSettings.put(Environment.USER,"root");
        dbSettings.put(Environment.PASS,"root");
        dbSettings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        dbSettings.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");

        registryBuilder.applySettings(dbSettings);
        standardServiceRegistry = registryBuilder.build();
        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
        Metadata metadata = metadataSources.getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
