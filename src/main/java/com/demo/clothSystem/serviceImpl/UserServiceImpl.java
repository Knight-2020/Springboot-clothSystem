package com.demo.clothSystem.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.clothSystem.service.IUserService;
import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import com.demo.clothSystem.mapper.*;
import com.demo.clothSystem.dto.*;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User add(User user) {
        save(user);
        return getById(user.getId());
    }

    @Override
    public User update(User user) {
        updateById(user);
        return getById(user.getId());
    }

    @Override
    public User detail(int id) {
        return getById(id);
    }

    @Override
    public void delete(int id) {
        getBaseMapper().deleteById(id);
    }

    @Override
    public ListResponse<User> page(ListUserRequest request) {
                IPage<User> page = page(new Page<>(request.getPageNumber(), request.getPageSize()));
                return new ListResponse<>(page.getRecords(), page.getTotal());
    }
        @Override
        public ListResponse<User> listAll() {
            return new ListResponse<>(list(), 0L);
        }
}
