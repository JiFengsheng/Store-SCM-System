package com.jfs.dao;

import com.jfs.domain.Staff;
import java.util.List;

public interface StaffMapper {

    int deleteByPrimaryKey(String staffId);

    int insert(Staff record);

    Staff selectByPrimaryKey(String staffId);

    List<Staff> selectAll();

    int updateByPrimaryKey(Staff record);

    Staff selectById(String staffId);

    List<Staff> selectByDepartmentId(Integer departmentId);

    Staff selectByUserId(Integer userId);

    List<Staff> selectByExample(Staff staff);


}