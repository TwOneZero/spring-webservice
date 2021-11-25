package com.twoonezero.webservice.web;


import com.twoonezero.webservice.domain.posts.PostsRepository;
import com.twoonezero.webservice.dto.posts.PostsSaveRequestDto;
import com.twoonezero.webservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

//    private PostsRepository postsRepository;
    private PostService postService;

    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
//        postsRepository.save(dto.toEntity());
        return postService.save(dto); //postService *Service 로직으로 변경
    }
}
