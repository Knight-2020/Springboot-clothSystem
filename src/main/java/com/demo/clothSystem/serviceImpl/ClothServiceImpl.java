package com.demo.clothSystem.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.clothSystem.service.IClothService;
import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import com.demo.clothSystem.mapper.*;
import com.demo.clothSystem.dto.*;

@Service
public class ClothServiceImpl extends ServiceImpl<ClothMapper, Cloth> implements IClothService {
    @Autowired
    private ClothMapper clothMapper;

    @Override
    public Cloth add(Cloth cloth) {
        save(cloth);
        return getById(cloth.getId());
    }

    @Override
    public Cloth update(Cloth cloth) {
        updateById(cloth);
        return getById(cloth.getId());
    }

    @Override
    public Cloth detail(int id) {
        return getById(id);
    }

    @Override
    public void delete(int id) {
        getBaseMapper().deleteById(id);
    }

    @Override
    public ListResponse<ClothDto> page(ListClothRequest request, int userId) {
        IPage<ClothDto> page = clothMapper.findDtos(new Page<>(request.getPageNumber(), request.getPageSize()), userId);
        return new ListResponse<>(page.getRecords(), page.getTotal());
    }
}
