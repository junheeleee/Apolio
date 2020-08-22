package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor // final인 필드만으로 생성자 만듦, 생성자는 최신 스프링에서 자동 Autowired가 된다.
public class AccountRepository{

    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    public User findByName(String username){
        return em.createQuery("select a from User a where a.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }


    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    public List<User> findByEmail(String email) {
        return em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
    }
}
