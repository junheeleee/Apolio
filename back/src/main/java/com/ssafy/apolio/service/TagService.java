package com.ssafy.apolio.service;

import com.ssafy.apolio.domain.Tag;
import com.ssafy.apolio.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    @Transactional //readOnly면 저장이 안되기 때문에 따로 달아서 오버라이딩
    public void saveTag(Tag tag) {
        tagRepository.save(tag);
    }

    public List<Tag> findTags() {
        return tagRepository.findAll();
    }

    public Tag findOne(Long tagId){
        return tagRepository.findOne(tagId);
    }

}
