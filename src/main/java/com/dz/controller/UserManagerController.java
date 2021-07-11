package com.dz.controller;


import com.dz.entity.UserManager;
import com.dz.service.UserManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员账号  前端控制器
 * </p>
 *
 * @author 邓洲
 * @since 2021-06-25
 */
@Controller
@RequestMapping("/dz/user-manager")
public class UserManagerController {
    @Resource
    private UserManagerService userManagerService;
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.isEmpty() || password.isEmpty()) return "managerLogin";
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        List<UserManager> userManagers = userManagerService.selectByMap(map);
        if(userManagers.size()==0){
            return "managerLogin";
        }else {
            return "manager";
        }
    }
}

