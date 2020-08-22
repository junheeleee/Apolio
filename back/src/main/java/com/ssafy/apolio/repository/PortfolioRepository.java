package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.Comment;
import com.ssafy.apolio.domain.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PortfolioRepository {

    private final EntityManager em;

    public void save(Portfolio portfolio) {
        em.persist(portfolio);
    }

    public List<Portfolio> findPortfolioAll(){
        return em.createQuery("select p from Portfolio p", Portfolio.class).getResultList();
    }

    public Portfolio findOne(Long id) {
        String jpql = "select p from Portfolio p where p.id = :id";
        TypedQuery<Portfolio> query = em.createQuery(jpql, Portfolio.class);
        query.setParameter("id", id);
        Portfolio portfolio = query.getSingleResult();
        System.out.println("포트폴리오 제목: " + portfolio.getTitle());
        System.out.println("포트폴리오 내용: " + portfolio.getContent());
        return portfolio;
    }
    public int updatePortfolioById(Portfolio portfolio){
        String jpql = "update Portfolio p set p.title = :title, p.content = :content where p.id = :id";
        Query query = em.createQuery(jpql);
        query.setParameter("title", portfolio.getTitle());
        query.setParameter("content", portfolio.getContent());
        query.setParameter("id", portfolio.getId());
        int check = query.executeUpdate();
        return check;
    }

    public int deletePortfolioById(Long id){
        String jpql = "delete from Portfolio p where p.id = :id";
        Query query = em.createQuery(jpql);
        query.setParameter("id", id);
        int check = query.executeUpdate();
        return check;
    }
}
