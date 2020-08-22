package com.ssafy.apolio;

import com.ssafy.apolio.domain.Blog;
import com.ssafy.apolio.domain.Tag;
import com.ssafy.apolio.domain.TagBlog;
import com.ssafy.apolio.domain.user.User;
import com.ssafy.apolio.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDB {
    private final InitService initService;

    @PostConstruct
    public void init() {
//        initService.dbInit1();
//        initService.dbInit2();
//        initService.dbInit3();
//        initService.dbInit4();
//        initService.dbInit5();
        initService.dbInit6();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            User user = createAccount("강동훈", "donghoon@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "후니", Role.ADMIN);
            em.persist(user);
            Tag tag1 = createTag("웹");
            em.persist(tag1);
            Tag tag2 = createTag("앱");
            em.persist(tag2);
            TagBlog tagBlog1 = TagBlog.createTagBlog(tag1);
            TagBlog tagBlog2 = TagBlog.createTagBlog(tag2);
            Blog blog = Blog.createBlog(user,"잘생겨지는 방법", "응 타고나~","description", null, tagBlog1, tagBlog2);
            em.persist(blog);
        }

        public void dbInit2() {
            User user = createAccount("최일송", "ilsong@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "쏭이", Role.MEMBER);
            em.persist(user);
            Tag tag1 = createTag("스프링");
            em.persist(tag1);
            Tag tag2 = createTag("클라우드");
            em.persist(tag2);
            TagBlog tagBlog1 = TagBlog.createTagBlog(tag1);
            TagBlog tagBlog2 = TagBlog.createTagBlog(tag2);
            Blog blog = Blog.createBlog(user,"귀여워지는 방법", "큐티 앙","description", null, tagBlog1, tagBlog2);
            em.persist(blog);
        }

        public void dbInit3() {
            User user = createAccount("박승범", "seungbum@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "뻐미", Role.MEMBER);
            em.persist(user);
            Tag tag1 = createTag("디비");
            em.persist(tag1);
            Tag tag2 = createTag("네트워크");
            em.persist(tag2);
            TagBlog tagBlog1 = TagBlog.createTagBlog(tag1);
            TagBlog tagBlog2 = TagBlog.createTagBlog(tag2);
            Blog blog = Blog.createBlog(user,"섹시해지는 방법", "땀 흘리는 남자 박승범", "description", "sssssss", tagBlog1, tagBlog2);
            em.persist(blog);
        }

        public void dbInit4() {
            User user = createAccount("배용균", "younggyun@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "뀨니", Role.MEMBER);
            em.persist(user);
            Tag tag1 = createTag("자료구조");
            em.persist(tag1);
            Tag tag2 = createTag("알고리즘");
            em.persist(tag2);
            TagBlog tagBlog1 = TagBlog.createTagBlog(tag1);
            TagBlog tagBlog2 = TagBlog.createTagBlog(tag2);
            Blog blog = Blog.createBlog(user,"깜찍해지는 방법", "뀨잉뀨잉", "description", "wwss.fa", tagBlog1, tagBlog2);
            em.persist(blog);
        }

        public void dbInit5() {
            User user = createAccount("이준희", "junhee@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "쭈니", Role.MEMBER);
            em.persist(user);
            Tag tag1 = createTag("운영체제");
            em.persist(tag1);
            Tag tag2 = createTag("소프트웨어공학");
            em.persist(tag2);
            TagBlog tagBlog1 = TagBlog.createTagBlog(tag1);
            TagBlog tagBlog2 = TagBlog.createTagBlog(tag2);
            Blog blog = Blog.createBlog(user,"DFS란 무엇인가", "BFS와의 차이점을 알려드리겠습니다.", "description", "aa", tagBlog1, tagBlog2);
            em.persist(blog);
        }

        public void dbInit6() {
            User user = createAccount("이준희", "junhee@gmail.com", "https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fsjinwon2%2F220022462092%23%3A~%3Atext%3D%5B%25EC%259B%2590%25EB%25B3%25B8%2520%25EB%25B3%25B4%25EA%25B8%25B0%5D&psig=AOvVaw0agqQHDXly_HYWLse5urJ_&ust=1596707835818000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICny63mg-sCFQAAAAAdAAAAABAD", "쭈니", Role.MEMBER);
            em.persist(user);
            Tag tag1 = createTag("운영체제");
            em.persist(tag1);
            Tag tag2 = createTag("소프트웨어공학");
            em.persist(tag2);
            Tag tag3 = createTag("자료구조");
            em.persist(tag3);
            Tag tag4 = createTag("알고리즘");
            em.persist(tag4);
            Tag tag7 = createTag("스프링");
            em.persist(tag7);
            Tag tag8 = createTag("클라우드");
            em.persist(tag8);
            TagBlog tagBlog1 = TagBlog.createTagBlog(tag1);
            TagBlog tagBlog2 = TagBlog.createTagBlog(tag2);

            Blog blog = Blog.createBlog(
                    user,
                    "하드코딩이지만 괜찮아.",
                    "일타싸피 하드코딩으로 광주가 1등한거 실화냐.. ㄹㅇ 가슴이 웅장해진다. 그뿐만 아니라 후공일 상황도 대비하여 탄탄한 알고리즘을 짜내다니 이것이 광주 클라스~",
                    "일타싸피 하드코딩으로 광주가 1등한거 실화냐.. ㄹㅇ 가슴이 웅장해진다. 그뿐만 아니라 후공일 상황도 대비하여 탄탄한 알고리즘을 짜내다니 이것이 광주 클라스~",
                    "http://imgnews.naver.net/image/108/2020/06/12/0002870435_001_20200612061503720.jpg",
                    tagBlog1
            );
            em.persist(blog);
            blog = Blog.createBlog(
                    user,
                    "코딩의 숲",
                    "프론트엔드와 백엔드... 그 끝을 알 수 없는 숨막히는 코딩대결... 과연 코딩의 숲에서 살아남는 자는 누군인가",
                    "프론트엔드와 백엔드... 그 끝을 알 수 없는 숨막히는 코딩대결... 과연 코딩의 숲에서 살아남는 자는 누군인가",
                    "http://imgnews.naver.net/image/5307/2017/07/31/0000182231_001_20170731113428477.jpg",
                    tagBlog1
            );
            em.persist(blog);
            blog = Blog.createBlog(
                    user,
                    "나쁜 코딩",
                    "나쁜 코딩 특징 : 변수이름이 개같다, 구조가 뒤죽박죽이다, 캡슐화가 안되어 있다, 하드코딩 되어있어 재사용률이 낮다.",
                    "나쁜 코딩 특징 : 변수이름이 개같다, 구조가 뒤죽박죽이다, 캡슐화가 안되어 있다, 하드코딩 되어있어 재사용률이 낮다.",
                    "http://imgnews.naver.net/image/018/2010/07/29/1280361902.874769_PP10072900004.JPG",
                    tagBlog1
            );
            em.persist(blog);
            blog = Blog.createBlog(
                    user,
                    "코딩은 지옥이다.",
                    "어느날 당신에게 걸려온 전화 한통.. 광주에서 싸피생 합격을 알리는 전화였다. 취업이 안되는 상황을 이겨내기 위해 광주로 향하기로 한 당신... 장덕동에 거주하게되는데?! 진정한 지옥을 모르고 왔다...",
                    "어느날 당신에게 걸려온 전화 한통.. 광주에서 싸피생 합격을 알리는 전화였다. 취업이 안되는 상황을 이겨내기 위해 광주로 향하기로 한 당신... 장덕동에 거주하게되는데?! 진정한 지옥을 모르고 왔다...",
                    "https://www.greened.kr/news/photo/201908/207865_208340_1656.jpg",
                    tagBlog1
            );
            em.persist(blog);
            blog = Blog.createBlog(
                    user,
                    "주인이랑 겸상한 썰 푼다",
                    "왈왈 왈왈왈 왈왈왈왈 왈왈왈왈왈 왈왈왈왈왈왈 왈왈왈왈왈왈왈 왈왈왈왈왈왈왈왈 왈왈왈왈왈왈왈왈왈 왈왈왈왈왈왈왈왈왈왈 왈왈왈왈왈왈왈왈왈왈왈 왈왈왈왈왈왈왈왈왈왈왈왈",
                    "왈왈 왈왈왈 왈왈왈왈 왈왈왈왈왈 왈왈왈왈왈왈 왈왈왈왈왈왈왈 왈왈왈왈왈왈왈왈 왈왈왈왈왈왈왈왈왈 왈왈왈왈왈왈왈왈왈왈 왈왈왈왈왈왈왈왈왈왈왈 왈왈왈왈왈왈왈왈왈왈왈왈",
                    "https://picsum.photos/id/237/400/200",
                    tagBlog1
            );
            em.persist(blog);
            blog = Blog.createBlog(
                    user,
                    "싸피 밥먹을 준비 완료",
                    "오늘의 메뉴 - UNION 짜장 / 엄마손발 김치찌개 / 철판갈아넣은 볶음밥 / 옥수수무말랭이 치즈비빔밥 / 히비스커스 수육 냉면 / 옥토퍼스의 다리",
                    "오늘의 메뉴 - UNION 짜장 / 엄마손발 김치찌개 / 철판갈아넣은 볶음밥 / 옥수수무말랭이 치즈비빔밥 / 히비스커스 수육 냉면 / 옥토퍼스의 다리",
                    "https://www.topstarnews.net/news/photo/first/201704/img_259721_1.jpg",
                    tagBlog1
            );
            em.persist(blog);
            blog = Blog.createBlog(
                    user,
                    "'미국에선 나루토 달리기가 유행중 ...",
                    "미안하다 이거 보여주려고 어그로끌었다.. 나루토 사스케 싸움수준 ㄹㅇ실화냐? 진짜 세계관최강자들의 싸움이다.. 그찐따같던 나루토가 맞나? 진짜 나루토는 전설이다..진짜옛날에 맨날나루토봘는데 왕같은존재인 호카게 되서 세계최강 전설적인 영웅이된나루토보면 진짜내가다 감격스럽고 나루토 노래부터 명장면까지 가슴울리는장면들이 뇌리에 스치면서 가슴이 웅장해진다..",
                    "미안하다 이거 보여주려고 어그로끌었다.. 나루토 사스케 싸움수준 ㄹㅇ실화냐? 진짜 세계관최강자들의 싸움이다.. 그찐따같던 나루토가 맞나? 진짜 나루토는 전설이다..진짜옛날에 맨날나루토봘는데 왕같은존재인 호카게 되서 세계최강 전설적인 영웅이된나루토보면 진짜내가다 감격스럽고 나루토 노래부터 명장면까지 가슴울리는장면들이 뇌리에 스치면서 가슴이 웅장해진다..",
                    "http://www.goodgag.net/_data/up/1907/c16185d306bf870f0b1845409.jpg",
                    tagBlog1
            );
            em.persist(blog);
            blog = Blog.createBlog(
                    user,
                    "뷰티파이란?",
                    "Vurtify는 아름답게 세공된 머티리얼 컴포넌트들을 담은 Vue UI 라이브러리입니다. 어떠한 디자인 스킬도 필요하지 않습니다 — 놀라운 앱을 만들기 위한 모든 것은 이미 준비되어 있습니다.",
                    "Vurtify는 아름답게 세공된 머티리얼 컴포넌트들을 담은 Vue UI 라이브러리입니다. 어떠한 디자인 스킬도 필요하지 않습니다 — 놀라운 앱을 만들기 위한 모든 것은 이미 준비되어 있습니다.",
                    "http://post.phinf.naver.net/MjAxOTA3MTJfOCAg/MDAxNTYyOTE5NzEyNTc4.-eCjmt9RYld3Nv_epH92ZcDiOWjRKF2bfaR3AAUsNE4g.BxK_dC_OQPodyHby7TyHfMUp_u4_AA_eFvn6aH0zckcg.JPEG/IkbZdCcXOjiIaFM2vOHTTiimFkXQ.jpg",
                    tagBlog1
            );
            em.persist(blog);
            blog = Blog.createBlog(
                    user,
                    "프론드엔드란?",
                    "프론트엔드 개발자는 프론트엔드, 백엔드의 완전한 분리 구조를 지향하는 업무 스타일의 개발 방식으로써 프론트단의 비지니스 로직과 사용자 영역의 개발을 담당하는 사람이다. 이와 다른 방식의 업무 스타일 직군으로는 웹퍼블리셔(ui개발)와 개발자(서버 개발자)의 업무 분리 방식이 있다. 이 경우는 주로 서버사이드가 클라이언트를 감싸는 방식이다. MVC로 치면 View 부분에 해당하는 영역을 맡는다.",
                    "프론트엔드 개발자는 프론트엔드, 백엔드의 완전한 분리 구조를 지향하는 업무 스타일의 개발 방식으로써 프론트단의 비지니스 로직과 사용자 영역의 개발을 담당하는 사람이다. 이와 다른 방식의 업무 스타일 직군으로는 웹퍼블리셔(ui개발)와 개발자(서버 개발자)의 업무 분리 방식이 있다. 이 경우는 주로 서버사이드가 클라이언트를 감싸는 방식이다. MVC로 치면 View 부분에 해당하는 영역을 맡는다.",
                    "https://media.vlpt.us/post-images/kameals/bc9cd740-05bb-11ea-93df-79d77f6fc891/1Vc0m5dS9SlhieEbR6n8wFg.jpeg",
                    tagBlog1
            );
            em.persist(blog);
        }
        private User createAccount(String username, String email, String picture, String nickname, Role role) {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPicture(picture);
            user.setNickname(nickname);
            user.setRole(role);
            return user;
        }

        private Tag createTag(String name) {
            Tag tag = new Tag();
            tag.setName(name);
            return tag;
        }

    }

}
