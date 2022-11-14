package org.example.repository;

import org.example.HibernateUtil;
import org.example.service.UserService;

import org.hibernate.Session;
import javax.servlet.http.Cookie;


public class UserRepository {

    public UserService getUserByLogin(String login) {
        UserService user = null;
        try (Session session = HibernateUtil.getSession()){
            user = session.byNaturalId(UserService.class).using("login", login).load();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return user;
    }

    public boolean addUser(UserService user) {
        try (Session session = HibernateUtil.getSession()){
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

    public UserService getUserFromCookie(Cookie[] cookies){
        if (cookies != null){
            for (Cookie cookie: cookies) {
                if ("login".equals(cookie.getName())) return this.getUserByLogin(cookie.getValue());
            }
        }
        return null;
    }
}
