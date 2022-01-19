package com.demo.clothSystem.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.clothSystem.service.IMenuService;
import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import com.demo.clothSystem.mapper.*;
import com.demo.clothSystem.dto.*;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu add(Menu menu) {
        save(menu);
        return getById(menu.getId());
    }

    @Override
    public Menu update(Menu menu) {
        updateById(menu);
        return getById(menu.getId());
    }

    @Override
    public Menu detail(int id) {
        return getById(id);
    }

    @Override
    public void delete(int id) {
        getBaseMapper().deleteById(id);
    }

    @Override
    public ListResponse<MenuDto> list(String role) {
        List<Menu> menus = list(new QueryWrapper<Menu>()
            .eq("role", role)
            .eq("parent_id", 0));
        List<MenuDto> menuDtos = menus.stream().map(it -> {
            MenuDto menuDto = new MenuDto();
            menuDto.setId(it.getId());
            menuDto.setName(it.getName());
            menuDto.setHref(it.getHref());
            menuDto.setIcon(it.getIcon());
            menuDto.setRole(it.getRole());
            setChildMenu(menuDto);
            return menuDto;
        }).collect(Collectors.toList());
        return new ListResponse<>(menuDtos, menuDtos.size());
    }
    private void setChildMenu(MenuDto menu) {
        List<MenuDto> child = list(new QueryWrapper<Menu>()
            .eq("parent_id", menu.getId()))
            .stream()
            .map(it -> {
        MenuDto menuDto = new MenuDto();
        menuDto.setId(it.getId());
        menuDto.setName(it.getName());
        menuDto.setHref(it.getHref());
        menuDto.setIcon(it.getIcon());
        menuDto.setRole(it.getRole());
        return menuDto;
        }).collect(Collectors.toList());
        menu.setChild(child);

        menu.getChild().forEach(this::setChildMenu);
    }
}
