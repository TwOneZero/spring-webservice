package com.twoonezero.webservice.domain.posts;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        //test 메소드가 끝날 때마다 영향을 끼치지 않기 위해
        //repository 전체 비우는 코드
        postsRepository.deleteAll();
    }

    @Test
    public void callText(){
        //given
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("twoonezero@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertEquals(posts.getTitle(), "test title");
        assertEquals(posts.getContent(), "test content");
        assertEquals(posts.getAuthor(), "twoonezero");
    }

    @Test
    public void BaseTimeEntityEnrolment(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("test title")
                .content("test content")
                .author("twoonezero").build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts =postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }



}