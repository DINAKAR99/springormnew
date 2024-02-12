package cgg.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cgg.core.config.hibernateConfig;
import cgg.core.dao.Userdao;
import cgg.core.entites.User;

public class App {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(hibernateConfig.class);

        Userdao bean = container.getBean(Userdao.class);

        User u1 = new User(1, "kim", "n k");

        bean.createUser(u1);

    }
}
