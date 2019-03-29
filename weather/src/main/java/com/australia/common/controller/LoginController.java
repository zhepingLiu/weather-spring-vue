package com.australia.common.controller;


import com.australia.common.entity.SysUser;
import com.australia.common.mapper.SysUserMapper;
import com.australia.common.tool.CommonTool;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;



@Slf4j
@Controller
@RequestMapping("login")
public class LoginController  {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private ThreadPoolTaskExecutor task;

    @Autowired
    private CommonTool commonTool;



    @RequestMapping("in")
    @ResponseBody
    public String login(HttpServletRequest request) {

        final SysUser user = sysUserMapper.findById(1);

        task.submit(new Runnable() {
            @Override
            public void run() {



            }
        });



        return user.toString();
    }


    @PostMapping(value = "testOne")
    @ResponseBody
    public String test(@RequestBody SysUser sysUser) {

        return sysUser.toString();
    }

    @PostMapping(value = "australia/weather")
    @ResponseBody
    public String weatherSydney(@RequestBody String cityNAme) {
        String cityName = JSONObject.fromObject(cityNAme).getString("name");
        JSONObject weatherInformation = commonTool.getWeatherByCityName(cityName);

        Double temp = (Double)weatherInformation.getJSONObject("main").get("temp");


        return weatherInformation.toString();
//        String result = "weather:{'Temperature':88.88, 'Updated time':'2018-10-10', 'Weather:cloud', 'Wind':'32km/h'}";

//        return JSONObject.fromObject(result);
    }




}
