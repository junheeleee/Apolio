package com.ssafy.apolio.service;

import com.ssafy.apolio.domain.Blog;
import com.ssafy.apolio.domain.BlogSearch;
import com.ssafy.apolio.domain.Tag;
import com.ssafy.apolio.domain.TagBlog;
import com.ssafy.apolio.domain.user.User;
import com.ssafy.apolio.repository.*;
import com.ssafy.apolio.web.BlogForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BlogService { //서비스에서는 단순히 엔티티에 필요한 요청을 위임하는 역할만 하고
    // 비즈니스 로직을 엔티티에서 하는 방식이 DDD(Domain Driven Design - 도메인 모델 패턴) 그 반대가 트랜잭션 스크립트 패턴

    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;

    @Autowired
    UserRepository userRepository;
    /**
     * 게시글 작성
     */
    @Transactional
    public Long blog(BlogForm blogForm) {

        //엔티티 조회
        Tag tag = tagRepository.findOne(blogForm.getTagId());

        //태그 생성
        TagBlog tagBlog = TagBlog.createTagBlog(tag);

        Optional<User> user = userRepository.findById(blogForm.getUser_id());
        //게시물 생성
        Blog blog = Blog.createBlog(user.get(), blogForm.getTitle(), blogForm.getContent(), blogForm.getDescription(), blogForm.getImg(), tagBlog);

        //게시물 저장
        blogRepository.save(blog);

        return blog.getId();
    }

    //게시물 전체 조회
    public List<Blog> findBlogsAll() {
        return blogRepository.findAll();
    }
    public Blog findBlog(Long blog_id) {
        return blogRepository.findOne(blog_id);
    }

    //게시물 검색
    public List<Blog> findBlogs(BlogSearch blogSearch) {
        return blogRepository.find(blogSearch);
    }
}
