package com.demo.clothSystem.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.clothSystem.service.IRoleService;
import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import com.demo.clothSystem.mapper.*;
import com.demo.clothSystem.dto.*;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role add(Role role) {
        save(role);
        return getById(role.getId());
    }

    @Override
    public Role update(Role role) {
        updateById(role);
        return getById(role.getId());
    }

    @Override
    public Role detail(int id) {
        return getById(id);
    }

    @Override
    public void delete(int id) {
        getBaseMapper().deleteById(id);
    }

    @Override
    public ListResponse<Role> page(ListRoleRequest request) {
                IPage<Role> page = page(new Page<>(request.getPageNumber(), request.getPageSize()));
                return new ListResponse<>(page.getRecords(), page.getTotal());
    }
        @Override
        public ListResponse<Role> listAll() {
            return new ListResponse<>(list(), 0L);
        }
}
