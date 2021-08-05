package Introducemyself.Introducemyselfspring.controller.Service;

import Introducemyself.Introducemyselfspring.Salt;
import Introducemyself.Introducemyselfspring.UserInfo;
import Introducemyself.Introducemyselfspring.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Override
    public UserInfo getSelectUserinfo(String id) {

        UserInfo userInfo = new UserInfo();
        Map<String,Object> userData=  userInfoRepository.getSelectUserinfo(id);

        String saltkey = userData.get("salt_id").toString();

        String salt= getSalt(saltkey).toString();

        userInfo.setIdx(Integer.parseInt(userData.get("idx").toString()));
        userInfo.setId(userData.get("id").toString());
        userInfo.setPw(userData.get("pw").toString());
        userInfo.setName(userData.get("name").toString());
        userInfo.setAge(userData.get("age").toString());
        userInfo.setSalt(new Salt(Integer.parseInt(saltkey),salt));

        return userInfo;
    }

    @Override
    public String getSalt(String id) {
        return  userInfoRepository.getSalt(id);
    }
}
