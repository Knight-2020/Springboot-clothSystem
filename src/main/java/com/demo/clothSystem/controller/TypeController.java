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
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeServiceImpl typeService;

    @Autowired
    private PermissionServiceImpl permissionService;

    @PostMapping("/add")
    @ResponseBody
    public Response<Type> add(@RequestBody Type request) {
        Type type = typeService.add(request);
        return Response.ok(type);
    }

    @PutMapping("/update")
    @ResponseBody
    public Response<Type> update(@RequestBody Type old) {
        Type type = typeService.update(old);
        return Response.ok(type);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Response<String> delete(@PathVariable int id) {
        typeService.delete(id);
        return Response.ok();
    }

    @PostMapping("/page")
    @ResponseBody
    public ListResponse<Type> page(@RequestBody ListTypeRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        return typeService.page(request);
    }

    @GetMapping("/list")
    @ResponseBody
    public ListResponse<Type> list() {
        return typeService.listAll();
    }

    @GetMapping("/tablePage")
    public String tablePage(HttpSession httpSession, Model model) {
        String role = ((User) httpSession.getAttribute("user")).getRole();
        List<Permission> permissions = permissionService.list(new QueryWrapper<Permission>()
            .eq("role", role)
            .eq("model", "type"));
        model.addAttribute("permissions", permissions.stream().map(Permission::getOperation).collect(Collectors.toList()));
        return "page/type/table";
    }

    @GetMapping("/addPage")
    public String addPage () {
        return "page/type/add";
    }

    @GetMapping("/editPage/{id}")
    public String editPage(@PathVariable int id, Model model) {
        Type type = typeService.getById(id);
        model.addAttribute("type", type);
        return "page/type/edit";
    }
    @GetMapping("/detailPage/{id}")
    public String detailPage(@PathVariable int id, Model model) {
        Type type = typeService.getById(id);
        model.addAttribute("type", type);
        return "page/type/detail";
    }
}
