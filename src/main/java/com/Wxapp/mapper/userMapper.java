package com.Wxapp.mapper;

import com.Wxapp.dao.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface userMapper {

    /**
     * 查询用户
     * @param OpenId
     * @return
     */
    UserAccount queryUserByOpenId(String OpenId);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(UserAccount user);

    /**
     * 更新用户登陆时间
     * @param user
     * @return
     */
    int updatetime(UserAccount user);

    /**
     * 更新用户性质（普通用户，商家）
     * @param userAccount
     * @return
     */
    int updateStatus(UserAccount userAccount);
}
