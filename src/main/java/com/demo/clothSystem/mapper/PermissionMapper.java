package com.demo.clothSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.clothSystem.entity.Permission;
import com.demo.clothSystem.dto.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
}
