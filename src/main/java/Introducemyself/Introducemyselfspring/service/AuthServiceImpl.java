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
        String id = userInfo.getId();

        //DB 에 저장되어있는 정보가있는지 확인합니다
        UserInfo userData=userInfoService.getSelectUserinfo(id);

        if(userData!=null) //기존에 아이디가있다면
        {
            //메세지가 출력되면 좋겠습니다
            return;
        }

        String salt = saltUtil.getSalt();
       // log.info(salt);
        userInfo.setSalt(new Salt(salt));
        userInfo.setPw(saltUtil.encodePassword(salt,password));
        userRepository.save(userInfo);
    }

    @Override
    public UserInfo loginUser(String id, String password)
    {
        UserInfo userData=userInfoService.getSelectUserinfo(id);
        if(userData==null)
        {
            //이런아이디는 없는걸요 선생님
            return null;
        }

     //   String userPw = userData.getPw();

        String salt = userData.getSalt().getSalt();
        password=  saltUtil.encodePassword(salt,password);

        if(!userData.getPw().equals(password))
        {
            //비밀번호가없습니다 선생님
            return  null;
        }
        return userData;
    }
}
