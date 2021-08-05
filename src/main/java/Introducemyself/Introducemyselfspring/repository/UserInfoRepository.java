package Introducemyself.Introducemyselfspring.repository;

import Introducemyself.Introducemyselfspring.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserInfoRepository {

    List<Map<String,Object>> getUserInfo();
    //UserInfo getSelectUserinfo(String id);
    //List<Map<String,Object>>  getSelectUserinfo(String id);
    Map<String,Object>  getSelectUserinfo(String id);
    String getSalt(String id);

}
