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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private PermissionServiceImpl permissionService;

    @PostMapping("/add")
    @ResponseBody
    public Response<Role> add(@RequestBody Role request) {
        Role role = roleService.add(request);
        return Response.ok(role);
    }

    @PutMapping("/update")
    @ResponseBody
    public Response<Role> update(@RequestBody Role old) {
        Role role = roleService.update(old);
        return Response.ok(role);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Response<String> delete(@PathVariable int id) {
        roleService.delete(id);
        return Response.ok();
    }

    @PostMapping("/page")
    @ResponseBody
    public ListResponse<Role> page(@RequestBody ListRoleRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        return roleService.page(request);
    }

    @GetMapping("/list")
    @ResponseBody
    public ListResponse<Role> list() {
        return roleService.listAll();
    }

    @GetMapping("/tablePage")
    public String tablePage(HttpSession httpSession, Model model) {
        String role = ((User) httpSession.getAttribute("user")).getRole();
        List<Permission> permissions = permissionService.list(new QueryWrapper<Permission>()
            .eq("role", role)
            .eq("model", "role"));
        model.addAttribute("permissions", permissions.stream().map(Permission::getOperation).collect(Collectors.toList()));
        return "page/role/table";
    }

    @GetMapping("/addPage")
    public String addPage () {
        return "page/role/add";
    }

    @GetMapping("/editPage/{id}")
    public String editPage(@PathVariable int id, Model model) {
        Role role = roleService.getById(id);
        model.addAttribute("role", role);
        return "page/role/edit";
    }
    @GetMapping("/detailPage/{id}")
    public String detailPage(@PathVariable int id, Model model) {
        Role role = roleService.getById(id);
        model.addAttribute("role", role);
        return "page/role/detail";
    }
}
