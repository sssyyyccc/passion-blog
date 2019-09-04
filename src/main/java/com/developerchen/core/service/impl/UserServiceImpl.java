package com.developerchen.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.developerchen.core.domain.entity.User;
import com.developerchen.core.repository.UserMapper;
import com.developerchen.core.service.IUserService;
import com.developerchen.core.util.SecurityUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author syc
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {

    public UserServiceImpl() {
    }


    /**
     * 新增或更新用户信息
     *
     * @param user 用户信息
     */
    @Override
    public void saveOrUpdateUser(User user) {
        String password = user.getPassword();
        if (password != null) {
            // 加密
            user.setPassword(SecurityUtils.encodeUserPassword(password));
        }
        super.saveOrUpdate(user);
    }

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return User
     */
    @Override
    public User getUserByUsername(String username) {
        return baseMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }

    /**
     * 根据用户ID查询用户
     *
     * @param id 用户ID
     * @return User
     */
    @Override
    public User getUserById(Serializable id) {
        return baseMapper.selectById(id);
    }

    /**
     * 通过用户ID删除用户
     *
     * @param id 用户ID
     */
    @Override
    public void deleteUserById(Serializable id) {
        Validate.notNull(id, "用户ID不能为空, 删除失败!");
        baseMapper.deleteById(id);
    }

    /**
     * 删除默认用户以外的所有用户
     */
    @Override
    public void deleteAllUser() {
        baseMapper.deleteBySql("DELETE FROM `sys_user` WHERE `id` <> 1");
    }
}
