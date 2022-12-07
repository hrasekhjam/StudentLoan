package org.example.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DbConfig {
    private static SessionFactory instance = null;

    private DbConfig() {
    }

    public static SessionFactory buildSessionFactory() {
        if (instance == null) {
            synchronized (DbConfig.class) {
                if (instance == null) {
                    Configuration configObj = new Configuration();
                    configObj.configure("hibernate.cfg.xml");

                    ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
                            .applySettings(configObj.getProperties()).build();
                    instance = configObj.buildSessionFactory(serviceRegistryObj);
                }
            }

        }
        return instance;
    }


}
