package com.demo.clothSystem.controller;

import com.demo.clothSystem.entity.*;
import com.demo.clothSystem.dto.*;
import com.demo.clothSystem.serviceImpl.*;
import com.demo.clothSystem.common.*;
import com.demo.clothSystem.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PermissionServiceImpl permissionService;
    @PostMapping("/add")
    @ResponseBody
    public Response<User> add(@RequestBody User request) {
        User user = userService.add(request);
        return Response.ok(user);
    }
    @PutMapping("/update")
    @ResponseBody
    public Response<User> update(@RequestBody User old) {
        User user = userService.update(old);
        return Response.ok(user);
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public Response<String> delete(@PathVariable int id) {
        userService.delete(id);
        return Response.ok();
    }
    @PostMapping("/page")
    @ResponseBody
    public ListResponse<User> page(@RequestBody ListUserRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        return userService.page(request);
    }
    @GetMapping("/list")
    @ResponseBody
    public ListResponse<User> list() {
        return userService.listAll();
    }
    @GetMapping("/tablePage")
    public String tablePage(HttpSession httpSession, Model model) {
        String role = ((User) httpSession.getAttribute("user")).getRole();
        List<Permission> permissions = permissionService.list(new QueryWrapper<Permission>()
            .eq("role", role)
            .eq("model", "user"));
        model.addAttribute("permissions", permissions.stream().map(Permission::getOperation).collect(Collectors.toList()));
        return "page/user/table";
    }
    @GetMapping("/addPage")
    public String addPage () {
        return "page/user/add";
    }

    @GetMapping("/editPage/{id}")
    public String editPage(@PathVariable int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "page/user/edit";
    }
    @GetMapping("/detailPage/{id}")
    public String detailPage(@PathVariable int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "page/user/detail";
    }
}
