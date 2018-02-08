package com.ydx.test.dao;

import com.ydx.test.pojo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
@Mapper
public interface MemberDao {
    List<Map> selectId();
}
