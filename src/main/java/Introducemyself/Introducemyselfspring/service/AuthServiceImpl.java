package Introducemyself.Introducemyselfspring.service;

import Introducemyself.Introducemyselfspring.Salt;
import Introducemyself.Introducemyselfspring.UserInfo;
import Introducemyself.Introducemyselfspring.controller.Service.UserInfoService;
import Introducemyself.Introducemyselfspring.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class AuthServiceImpl implements  AuthService{


    //JPA
    @Autowired
    private UserRepository userRepository;


    //마이바티스
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SaltUtil saltUtil;

    //회원가입 정보
    @Override
    @Transactional
    public void signUpUser(UserInfo userInfo) {
        String password = userInfo.getPw();
        String salt = saltUtil.getSalt();
       // log.info(salt);
        userInfo.setSalt(new Salt(salt));
        userInfo.setPw(saltUtil.encodePassword(salt,password));
        userRepository.save(userInfo);


    }

    @Override
    public UserInfo loginUser(String id, String password) {


        return null;
    }
}
