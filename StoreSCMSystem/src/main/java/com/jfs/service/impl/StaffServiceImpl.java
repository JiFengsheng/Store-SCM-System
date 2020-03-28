package com.jfs.service.impl;

import com.jfs.dao.StaffMapper;
import com.jfs.domain.Staff;
import com.jfs.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements IStaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public int updatePic(String id, String fileName) {
        Staff temp = new Staff();
        temp.setStaffId(id);
        temp.setPic(fileName);
        int i = staffMapper.updateByPrimaryKey(temp);
        return i;
    }
}
