package com.jake.property.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jake.property.entity.Admin;
import com.jake.property.mapper.AdminMapper;
import com.jake.property.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService, UserDetailsService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> adminFindAll() {
        List<Admin> admins = adminMapper.selectList(null);
        return admins;
    }

    @Override
    public Admin login(String username, String password) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username).eq("password",password);
        Admin admin = adminMapper.selectOne(wrapper);
        return admin;
    }

    @Override
    public IPage<Admin> adminSearch(Map searchMap) {
        int pageNum = 1;
        int pageSize = 2;
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        //模糊查询
        if (!StringUtils.isEmpty(searchMap.get("name"))) {
            wrapper.like("username", searchMap.get("name"));
        }
        //分页查询
        if (searchMap.get("pageNum") != null) {
            pageNum = (int) searchMap.get("pageNum");
        }
        if (searchMap.get("pageSize") != null) {
            pageSize = (int) searchMap.get("pageSize");
        }
        Page<Admin> page = new Page<>(pageNum, pageSize);
        Page<Admin> adminPage = adminMapper.selectPage(page, wrapper);
        return adminPage;
    }

    @Override
    public Boolean adminAdd(Admin admin) {
        int result = adminMapper.insert(admin);
        return result > 0;
    }

    @Override
    public Admin getAdminById(Integer id) {
        Admin admin = adminMapper.selectById(id);
        return admin;
    }

    @Override
    public Boolean updateAdminById(Admin admin) {
        int result = adminMapper.updateById(admin);
        return result > 0;
    }

    @Override
    public Boolean deleteAdminById(List<Integer> ids) {
        int result = adminMapper.deleteBatchIds(ids);
        return result > 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Admin admin = adminMapper.selectOne(wrapper);
        if (admin == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");;

        return new User(admin.getUsername(),new BCryptPasswordEncoder().encode(admin.getPassword()),auths);
    }
}
