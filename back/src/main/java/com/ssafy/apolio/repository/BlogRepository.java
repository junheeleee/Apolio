package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.Blog;
import com.ssafy.apolio.domain.BlogSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BlogRepository {

    private final EntityManager em;

    public void save(Blog blog) {
        em.persist(blog);
    }

    public Blog findOne(Long id) {
        return em.find(Blog.class, id);
    }

    public List<Blog> findAll() {
        return em.createQuery("select b from Blog b", Blog.class)
                .getResultList();
    }

    //검색 조건에 동적으로 쿼리를 생성해서 Board 엔티티를 조회한다.
    //JPQL로 처리
    public List<Blog> find(BlogSearch blogSearch) {
        //language=JPQAL
        String jpql = "select b From Blog b join b.tagBlogs tb join tb.tag t";
        boolean isFirstCondition = true;
        //태그 선택
        if (blogSearch.getTagName() != null) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " t.name = :tagName";
        }
        //게시글 제목 검색
        if (StringUtils.hasText(blogSearch.getBlogTitle())) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " b.title like concat('%', :blogTitle, '%')";
        }
        TypedQuery<Blog> query = em.createQuery(jpql, Blog.class)
                .setMaxResults(1000); //최대 1000건
        if (blogSearch.getTagName() != null) {
            query = query.setParameter("tagName", blogSearch.getTagName());
        }
        if (StringUtils.hasText(blogSearch.getBlogTitle())) {
            query = query.setParameter("blogTitle", blogSearch.getBlogTitle());
        }
        return query.getResultList();
    }
}
