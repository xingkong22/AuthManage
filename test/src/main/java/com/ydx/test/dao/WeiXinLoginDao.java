package com.ydx.test.dao;

import com.ydx.test.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface WeiXinLoginDao {
    public Users login2(Users user);
}
