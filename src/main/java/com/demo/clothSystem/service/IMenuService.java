package com.demo.clothSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import com.demo.clothSystem.mapper.*;
import com.demo.clothSystem.dto.*;
public interface IMenuService extends IService<Menu> {
    Menu add(Menu menu);
    Menu update(Menu menu);
    Menu detail(int id);
    void delete(int id);
    ListResponse<MenuDto> list(String role);
}
