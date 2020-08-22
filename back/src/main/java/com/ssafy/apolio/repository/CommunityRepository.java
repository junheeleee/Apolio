package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.Community;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommunityRepository {
    private final EntityManager em;

    public void save(Community community) {
        em.persist(community);
    }

    public Community findOne(Long id) {
        return em.find(Community.class, id);
    }

    public List<Community> findAll() {
        return em.createQuery("select c from Community c", Community.class)
                .getResultList();
    }
    public int updateCommunityById(Community community){
        String jpql = "update Community c set c.title = :title, c.content = :content where c.id = :id";
        Query query = em.createQuery(jpql);
        query.setParameter("title", community.getTitle());
        query.setParameter("content", community.getContent());
        query.setParameter("id", community.getId());
        int check = query.executeUpdate();
        return check;
    }

    public int deleteCommunityById(Long id){
        String jpql = "delete from Community c where c.id = :id";
        Query query = em.createQuery(jpql);
        query.setParameter("id", id);
        int check = query.executeUpdate();
        return check;
    }
}
