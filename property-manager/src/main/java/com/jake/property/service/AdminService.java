package com.jake.property.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jake.property.entity.Admin;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
public interface AdminService extends IService<Admin> {

    /**
     * 查询所有管理员信息
     * @return
     */
    public List<Admin> adminFindAll();

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public Admin login(String username, String password);

    /**
     * 用户注销
     * @param username
     * @param password
     * @return
     */
    // public Admin logout(String username, String password);

    /**
     * 分页查询
     * @param searchMap
     * @return
     */
    public IPage<Admin> adminSearch(Map searchMap);

    /**
     * 添加用户信息
     * @param admin
     * @return
     */
    public Boolean adminAdd(Admin admin);

    /**
     * 根据id获取对象信息
     * @param id
     * @return
     */
    public Admin getAdminById(Integer id);

    /**
     * 根据id获取对象信息 修改
     * @param admin
     * @return
     */
    public Boolean updateAdminById(Admin admin);

    /**
     * 根据id删除用户信息
     * @param ids
     * @return
     */
    public Boolean deleteAdminById(List<Integer> ids);

}
