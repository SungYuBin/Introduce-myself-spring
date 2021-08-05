package Introducemyself.Introducemyselfspring.controller.Service;


import Introducemyself.Introducemyselfspring.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    //마이바티스
    List<Map<String, Object>> getUserInfo();

    UserInfo getSelectUserinfo(String id);

    String getSalt(String id);
}
