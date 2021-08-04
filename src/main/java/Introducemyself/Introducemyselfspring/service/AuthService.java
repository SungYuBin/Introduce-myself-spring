package Introducemyself.Introducemyselfspring.service;

import Introducemyself.Introducemyselfspring.UserInfo;

public interface AuthService {

     void signUpUser(UserInfo userInfo);
     UserInfo loginUser(String id, String password);
}
