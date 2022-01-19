package com.demo.clothSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import com.demo.clothSystem.mapper.*;
import com.demo.clothSystem.dto.*;
public interface IRoleService extends IService<Role> {
    Role add(Role role);
    Role update(Role role);
    Role detail(int id);
    void delete(int id);
    ListResponse<Role> page(ListRoleRequest request);
        ListResponse<Role> listAll();
}
