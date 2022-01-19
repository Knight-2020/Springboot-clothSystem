package com.demo.clothSystem.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.clothSystem.service.ISuitService;
import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import com.demo.clothSystem.mapper.*;
import com.demo.clothSystem.dto.*;

@Service
public class SuitServiceImpl extends ServiceImpl<SuitMapper, Suit> implements ISuitService {
    @Autowired
    private SuitMapper suitMapper;

    @Override
    public Suit add(Suit suit) {
        save(suit);
        return getById(suit.getId());
    }

    @Override
    public Suit update(Suit suit) {
        updateById(suit);
        return getById(suit.getId());
    }

    @Override
    public Suit detail(int id) {
        return getById(id);
    }

    @Override
    public void delete(int id) {
        getBaseMapper().deleteById(id);
    }

    @Override
    public ListResponse<Suit> page(ListSuitRequest request, User user) {
        IPage<Suit> page = page(new Page<>(request.getPageNumber(), request.getPageSize()), new QueryWrapper<Suit>()
            .eq("user_id", user.getId()));
        return new ListResponse<>(page.getRecords(), page.getTotal());
    }

    @Override
    public ListResponse<Suit> listAll() {
        return new ListResponse<>(list(), 0L);
    }
}
