package com.jake.property.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("adminServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    //注入数据源
    @Autowired
    private DataSource dataSource;

    /**
     * 配置对象
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //自动创建表
        // jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        //退出
        httpSecurity.logout().logoutUrl("/admin/logout")
                .logoutSuccessUrl("/login.html").permitAll();
        //自定义错误页面
        httpSecurity.exceptionHandling().accessDeniedPage("/error.html");
        httpSecurity.formLogin()
                .loginPage("/login.html")   //登录页面
        .loginProcessingUrl("/admin/login")   //登录页面访问路径
        .defaultSuccessUrl("/index.html")   //登录成功后访问路径必须是POST
                .failureUrl("/error.html")  //登录失败返回路径
        .permitAll()
                .and().authorizeRequests()
                .antMatchers(
                        "/swagger-ui.html",
                        "/v2/api-docs", // swagger api json
                        "/swagger-resources/configuration/ui", // 用来获取支持的动作
                        "/swagger-resources", // 用来获取api-docs的URI
                        "/swagger-resources/configuration/security", // 安全选项
                        "/swagger-resources/**",
                        "/**",
                        "/css/**",
                        "/fileupload/**",
                        "/js/**",
                        "/lib/**",
                        "/ueditor/**",
                        "/images/**"
                )  //配置可以直接访问的路径
        .permitAll()


                .anyRequest().authenticated()
                //记住我
                .and().rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(600)
                .userDetailsService(userDetailsService)
                .and()
                //csrf跨站请求攻击
                .csrf().disable()
                //将X-Frame-Options设置为SAMEORIGIN
                .headers().frameOptions().sameOrigin();

    }

}
