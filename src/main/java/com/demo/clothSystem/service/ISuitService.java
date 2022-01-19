package com.demo.clothSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import com.demo.clothSystem.mapper.*;
import com.demo.clothSystem.dto.*;
public interface ISuitService extends IService<Suit> {
    Suit add(Suit suit);
    Suit update(Suit suit);
    Suit detail(int id);
    void delete(int id);
    ListResponse<Suit> page(ListSuitRequest request, User user);
        ListResponse<Suit> listAll();
}
