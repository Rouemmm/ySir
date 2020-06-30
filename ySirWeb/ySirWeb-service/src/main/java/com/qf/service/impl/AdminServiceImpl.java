package com.qf.service.impl;

import com.qf.dao.AdminMapper;
import com.qf.pojo.Admin;
import com.qf.pojo.AdminExample;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ySirWeb
 * @description: AdminService实现类
 * @encoder: Roue
 * @create: 2020-06-25 17:41
 **/
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin selectAdminByNameAndPwd(String username, String password) {
        AdminExample adminExample = new AdminExample();
        //创建内部制定规则类
        AdminExample.Criteria criteria = adminExample.createCriteria();
        //规定规则
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<Admin> admins = adminMapper.selectByExample(adminExample);

        return admins.get(0);
    }
}
