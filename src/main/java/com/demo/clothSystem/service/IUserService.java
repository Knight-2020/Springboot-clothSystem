package com.demo.clothSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import com.demo.clothSystem.mapper.*;
import com.demo.clothSystem.dto.*;
public interface IUserService extends IService<User> {
    User add(User user);
    User update(User user);
    User detail(int id);
    void delete(int id);
    ListResponse<User> page(ListUserRequest request);
        ListResponse<User> listAll();
}
