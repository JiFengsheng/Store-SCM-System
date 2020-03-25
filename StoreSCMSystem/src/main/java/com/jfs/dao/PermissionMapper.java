package com.jfs.dao;

import com.jfs.domain.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Integer id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    List<Permission> selectByUserId(@Param("userId") Integer userId,
                                    @Param("status") boolean status);

    List<Permission> selectByIdAndType(@Param("userId") Integer userId,
                                       @Param("status") boolean status,
                                       @Param("type") String type);
}