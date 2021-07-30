package Introducemyself.Introducemyselfspring.controller.Service;

import Introducemyself.Introducemyselfspring.UserInfo;
import Introducemyself.Introducemyselfspring.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserInfoImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;


    @Override
    public List<Map<String, Object>> getUserInfo() {
        return userInfoRepository.getUserInfo();
    }
}
