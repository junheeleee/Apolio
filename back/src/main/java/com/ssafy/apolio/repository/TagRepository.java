package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TagRepository {

    private final EntityManager em;

    public void save(Tag tag) {
        if (tag.getId() == null) {
            em.persist(tag);
        } else {
            em.merge(tag);
        }
    }

    public Tag findOne(Long id) {
        return em.find(Tag.class, id);
    }

    public List<Tag> findAll() {
        return em.createQuery("select t from Tag t", Tag.class)
                .getResultList();
    }
}
