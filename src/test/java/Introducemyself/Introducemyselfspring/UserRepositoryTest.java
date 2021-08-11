package Introducemyself.Introducemyselfspring;

import Introducemyself.Introducemyselfspring.repository.UserRepository;
import Introducemyself.Introducemyselfspring.controller.Service.UserInfoService;
import Introducemyself.Introducemyselfspring.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

//@WebAppConfiguration
@SpringBootTest
@Slf4j

public class UserRepositoryTest {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;


    //회원가입기능
    //데이터 베이스에 내역을 추가가능
    @Test
    public void Create(){
        UserInfo user= new UserInfo();
        user.setId("1");
        user.setPw("1");
        user.setName("1");
        user.setAge("1");
        //userRepository.save(user);
        authService.signUpUser(user);


        int i=0;
    }


    //로그인기능
    //DB모든내역을 불러옵니다 JPA
    @Test
    public void Read(){
        //이렇게 하면 모든 데이터를 가지고옵니다
       //List<UserInfo> value = userRepository.findAll();

       UserInfo user =authService.loginUser("1","1");
        int i=0;

    }

    //DB내역을 불러옵니다 마이바티스스
   @Test
    public void ReadBaits(){
       Object dfs =  userInfoService.getSelectUserinfo("1");
       int i=0;
    }






}
