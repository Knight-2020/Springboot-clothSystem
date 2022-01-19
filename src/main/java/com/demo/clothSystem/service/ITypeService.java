package com.demo.clothSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import com.demo.clothSystem.mapper.*;
import com.demo.clothSystem.dto.*;
public interface ITypeService extends IService<Type> {
    Type add(Type type);
    Type update(Type type);
    Type detail(int id);
    void delete(int id);
    ListResponse<Type> page(ListTypeRequest request);
        ListResponse<Type> listAll();
}
