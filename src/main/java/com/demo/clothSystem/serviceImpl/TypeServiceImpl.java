package com.demo.clothSystem.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.clothSystem.service.ITypeService;
import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import com.demo.clothSystem.mapper.*;
import com.demo.clothSystem.dto.*;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Type add(Type type) {
        save(type);
        return getById(type.getId());
    }

    @Override
    public Type update(Type type) {
        updateById(type);
        return getById(type.getId());
    }

    @Override
    public Type detail(int id) {
        return getById(id);
    }

    @Override
    public void delete(int id) {
        getBaseMapper().deleteById(id);
    }

    @Override
    public ListResponse<Type> page(ListTypeRequest request) {
                IPage<Type> page = page(new Page<>(request.getPageNumber(), request.getPageSize()));
                return new ListResponse<>(page.getRecords(), page.getTotal());
    }
        @Override
        public ListResponse<Type> listAll() {
            return new ListResponse<>(list(), 0L);
        }
}
