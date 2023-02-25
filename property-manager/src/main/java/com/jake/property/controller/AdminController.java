package com.jake.property.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jake.property.common.MessageConstant;
import com.jake.property.common.PageResult;
import com.jake.property.common.Result;
import com.jake.property.common.StatusCode;
import com.jake.property.entity.Admin;
import com.jake.property.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 查询所有表单信息
     *
     * @return
     */
    @RequestMapping("/adminFindAll")
    public Result adminFindAll() {
        List<Admin> admins = adminService.adminFindAll();
        return new Result(true, StatusCode.OK, MessageConstant.MANAGER_SEARCH_SUCCESS, admins);
    }

    /**
     * 分页查询
     *
     * @param searchMap
     * @return
     */
    @RequestMapping("/adminSearch")
    public PageResult adminSearch(@RequestBody Map searchMap) {
        IPage<Admin> adminIPage = adminService.adminSearch(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.MANAGER_SEARCH_SUCCESS, adminIPage.getRecords(), adminIPage.getTotal());
    }

    /**
     * 用户登录返回字符串
     *
     * @param adminMap
     * @param session
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(HttpSession session, @RequestParam Map adminMap) {
        String username = (String) adminMap.get("username");
        String password = (String) adminMap.get("password");
        Admin login = adminService.login(username, password);
        String result ;
        if (login != null) {
            session.setAttribute("username", username);
            // System.out.println(session.getAttribute("username"));
            result = "redirect:index.html";
        } else {
            result = "redirect:login.html";
        }
        return result;
    }

    /**
     * 注销方法
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login.html";
    }

    /**
     * 添加用户信息
     *
     * @param admin
     * @return
     */
    @PostMapping("/adminAdd")
    public Result adminAdd(@RequestBody Admin admin) {
        Boolean aBoolean = adminService.adminAdd(admin);
        return new Result(true, StatusCode.OK, MessageConstant.MANAGER_ADD_SUCCESS, aBoolean);
    }

    /**
     * 根据id更新用户数据
     *
     * @param admin
     * @return
     */
    @RequestMapping("/updateAdminById")
    public Result updateAdminById(@RequestBody Admin admin) {
        Boolean aBoolean = adminService.updateAdminById(admin);
        return new Result(true, StatusCode.OK, MessageConstant.MANAGER_UPDATE_SUCCESS, aBoolean);
    }

    /**
     * 根据id查询用户数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/getAdminById")
    public Result getAdminById(Integer id) {
        Admin adminById = adminService.getAdminById(id);
        return new Result(true, StatusCode.OK, MessageConstant.MANAGER_FIND_BY_ID_SUCCESS, adminById);
    }

    /**
     * 根据id删除用户数据
     *
     * @param ids
     * @return
     */
    @RequestMapping("/deleteAdminById")
    public Result deleteAdminById(@RequestBody List<Integer> ids) {
        Boolean aBoolean = adminService.deleteAdminById(ids);
        return new Result(true, StatusCode.OK, MessageConstant.MANAGER_DELETE_SUCCESS, aBoolean);
    }

}

