package Introducemyself.Introducemyselfspring.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserInfoRepository {

    List<Map<String,Object>> getUserInfo();

}
