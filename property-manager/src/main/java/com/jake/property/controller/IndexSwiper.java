package com.jake.property.controller;

import com.jake.property.common.MessageConstant;
import com.jake.property.common.Result;
import com.jake.property.common.StatusCode;
import com.jake.property.entity.House;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 轮播图 前端控制器
 * 微信端
 * </p>
 *
 * @author jake-jin
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/index")
public class IndexSwiper {
    //测试方法
    @RequestMapping("/swiperdata")
    public Result swiperData(){
        Map<String,String> data1 = new HashMap<>();
        data1.put("image_src","http://39.97.245.238:8080/nav1.jpg");
        data1.put("img_id","1");
        Map<String,String> data2 = new HashMap<>();
        data2.put("image_src","http://39.97.245.238:8080/nav2.jpg");
        data2.put("img_id","2");
        Map<String,String> data3 = new HashMap<>();
        data3.put("image_src","http://39.97.245.238:8080/nav3.jpg");
        data3.put("img_id","3");
        List<Object> data = new ArrayList<>();
        data.add(data1);
        data.add(data2);
        data.add(data3);
        return new Result(true, StatusCode.OK, MessageConstant.HOUSE_SEARCH_SUCCESS,data);
    }
}
