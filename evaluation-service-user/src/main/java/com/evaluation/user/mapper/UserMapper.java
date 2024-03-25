package com.evaluation.user.mapper;

import com.evaluation.my.mapper.MyMapper;
import com.evaluation.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends MyMapper<User> {
}