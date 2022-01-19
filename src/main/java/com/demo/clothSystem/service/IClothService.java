package com.demo.clothSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import com.demo.clothSystem.mapper.*;
import com.demo.clothSystem.dto.*;
public interface IClothService extends IService<Cloth> {
    Cloth add(Cloth cloth);
    Cloth update(Cloth cloth);
    Cloth detail(int id);
    void delete(int id);
    ListResponse<ClothDto> page(ListClothRequest request, int userId);
}
