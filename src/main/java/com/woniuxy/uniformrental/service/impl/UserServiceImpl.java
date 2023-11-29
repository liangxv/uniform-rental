package com.woniuxy.uniformrental.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.uniformrental.dao.UserDao;
import com.woniuxy.uniformrental.entity.User;
import com.woniuxy.uniformrental.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-11-27 13:10:11
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}

