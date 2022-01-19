package com.demo.clothSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import com.demo.clothSystem.mapper.*;
import com.demo.clothSystem.dto.*;
public interface IPermissionService extends IService<Permission> {
    Permission add(Permission permission);
    Permission update(Permission permission);
    Permission detail(int id);
    void delete(int id);
    ListResponse<Permission> page(ListPermissionRequest request);
        ListResponse<Permission> listAll();
}
