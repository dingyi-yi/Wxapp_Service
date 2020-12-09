package com.Wxapp.mapper;

import com.Wxapp.dao.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface userMapper {

    UserAccount queryUserByOpenId(String OpenId);

    int addUser(UserAccount user);

    int updatetime(UserAccount user);
}
