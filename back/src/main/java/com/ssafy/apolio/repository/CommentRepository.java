package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public void save(Comment comment) {
        em.persist(comment);
    }

    public List<Comment> findAllByBlogId(Long id){
        String jpql = "select c from Comment c where c.blog.id = :id order by c.comment_group";
        //String jpql = "select c from Comment c group by c.comment_group having c.board.id = :id order by c.comment_group asc";
        TypedQuery<Comment> query = em.createQuery(jpql, Comment.class);
        query.setParameter("id", id);
        List<Comment> commentList = query.getResultList();
        for(Comment comment : commentList){
            System.out.println("댓글 달린 커뮤니티 게시물 번호: " + comment.getBlog().getId());
            System.out.println("댓글 작성자: " + comment.getUser().getUsername());
            System.out.println("댓글 내용: " + comment.getContent());
        }
        return commentList;
    }

    public Comment findOneByBlogId(Long id, Long parent){ //대댓글 작성을 위해 부모 댓글 조회
        String jpql = "select c from Comment c where c.blog.id = :id and c.id = :parent";
        TypedQuery<Comment> query = em.createQuery(jpql, Comment.class);
        query.setParameter("id", id);
        query.setParameter("parent", parent);
        Comment comment = query.getSingleResult();
        return comment;
    }


    public List<Comment> findAllByCommunityId(Long id){
        String jpql = "select c from Comment c where c.community.id = :id order by c.comment_group";
        //String jpql = "select c from Comment c group by c.comment_group having c.blog.id = :id order by c.comment_group asc";
        TypedQuery<Comment> query = em.createQuery(jpql, Comment.class);
        query.setParameter("id", id);
        List<Comment> commentList = query.getResultList();
        for(Comment comment : commentList){
            System.out.println("댓글 달린 커뮤니티 게시물 번호: " + comment.getCommunity().getId());
            System.out.println("댓글 작성자: " + comment.getUser().getUsername());
            System.out.println("댓글 내용: " + comment.getContent());
        }
        return commentList;
    }

    public Comment findOneByCommunityId(Long id, Long parent){ //대댓글 작성을 위해 부모 댓글 조회
        String jpql = "select c from Comment c where c.community.id = :id and c.id = :parent";
        TypedQuery<Comment> query = em.createQuery(jpql, Comment.class);
        query.setParameter("id", id);
        query.setParameter("parent", parent);
        Comment comment = query.getSingleResult();
        return comment;
    }


    public List<Comment> findAll(){
        return em.createQuery("select c from Comment c", Comment.class).getResultList();
    }

    public int updateParentComment(Long parent){
        String jpql = "update Comment c set c.comment_group = :parent where c.id = :parent";
        Query query = em.createQuery(jpql);
        query.setParameter("parent", parent);
        int check = query.executeUpdate();
        return check;
    }

    public int updateCommentById(Comment comment){
        String jpql = "update Comment c set c.content = :content where c.id = :id";
        Query query = em.createQuery(jpql);
        query.setParameter("content", comment.getContent());
        query.setParameter("id", comment.getId());
        int check = query.executeUpdate();
        return check;
    }

    public int deleteCommentById(Long id){
        String jpql = "delete from Comment c where c.id = :id";
        Query query = em.createQuery(jpql);
        query.setParameter("id", id);
        int check = query.executeUpdate();
        return check;
    }


}
