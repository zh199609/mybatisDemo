package com.zl.mapper;

import com.zl.entity.SysRole;

public interface RoleMapper {
    SysRole selectById(long id);

    int insert(SysRole sysRole);
}
