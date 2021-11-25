package com.twoonezero.webservice.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


//@RunWith(SpringRunner.class)  ---> Junit4 에서 사용하는 Test Annotation 으로,
//SpringBootTest 와 달리 Autowired 된 클래스와 Bean 들만 load 하므로 가볍다.
@ExtendWith(SpringExtension.class) // ---> Junit5 에서는 대신 이거 씀
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebControllerTest {

    @Autowired
    private TestRestTemplate restTemplate; //Rest api Test 하게 도와줌

    @Test
    public void mainPage_load(){
        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        assertThat(body).contains("SpringBoot로 시작하는 웹서비스");
    }

}