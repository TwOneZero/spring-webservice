package com.twoonezero.webservice.service;

import com.twoonezero.webservice.domain.posts.Posts;
import com.twoonezero.webservice.domain.posts.PostsRepository;
import com.twoonezero.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;
    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void saveDtoToPostTable(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("twoonezero@gmail.com")
                .content("test")
                .title("test title")
                .build();

        //when
        postService.save(dto);
        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
    }



}