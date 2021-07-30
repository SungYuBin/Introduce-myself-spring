package Introducemyself.Introducemyselfspring;

import Introducemyself.Introducemyselfspring.repository.UserRepository;
import Introducemyself.Introducemyselfspring.controller.Service.UserInfoService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@WebAppConfiguration
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SqlSessionFactory sqlFactory;



    @Test
    public void Create(){
        UserInfo user=
                UserInfo.builder()
                        .id("Test1")
                        .pw("test2")
                        .name("Test3")
                        .age("Test5")
                        .build();
        userRepository.save(user);

        int i=0;
    }

    @Test
    public void Read(){
        //이렇게 하면 모든 데이터를 가지고옵니다
        List<UserInfo> value = userRepository.findAll();
        int i=0;

    }

    @Test
    public void ReadBaits(){
        Object dfsf=  userInfoService.getUserInfo();
        int i=0;
    }

}
