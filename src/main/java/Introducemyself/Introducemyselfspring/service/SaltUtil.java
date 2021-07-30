package Introducemyself.Introducemyselfspring.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;


//Dao 가 DB에서 받아온 데이터를 전달받아 가공하는것
@Service
public class SaltUtil {

    //솔트 함수를 관리하는 모듈
    public String encodePassword(String salt, String password) {
        return BCrypt.hashpw(salt, password);
    }

    public String getSalt() {
        return BCrypt.gensalt();
    }
}
