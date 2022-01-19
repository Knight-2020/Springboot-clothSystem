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
@RequestMapping("/cloth")
public class ClothController {
    @Autowired
    private ClothServiceImpl clothService;
    @Autowired
    private PermissionServiceImpl permissionService;

    @PostMapping("/add")
    @ResponseBody
    public Response<Cloth> add(@RequestBody Cloth request) {
        Cloth cloth = clothService.add(request);
        return Response.ok(cloth);
    }

    @PutMapping("/update")
    @ResponseBody
    public Response<Cloth> update(@RequestBody Cloth old) {
        Cloth cloth = clothService.update(old);
        return Response.ok(cloth);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Response<String> delete(@PathVariable int id) {
        clothService.delete(id);
        return Response.ok();
    }

    @PostMapping("/page")
    @ResponseBody
    public ListResponse<ClothDto> page(@RequestBody ListClothRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        return clothService.page(request, user.getId());
    }


    @GetMapping("/tablePage")
    public String tablePage(HttpSession httpSession, Model model) {
        String role = ((User) httpSession.getAttribute("user")).getRole();
        List<Permission> permissions = permissionService.list(new QueryWrapper<Permission>()
            .eq("role", role)
            .eq("model", "cloth"));
        model.addAttribute("permissions", permissions.stream().map(Permission::getOperation).collect(Collectors.toList()));
        return "page/cloth/table";
    }

    @GetMapping("/addPage")
    public String addPage () {
        return "page/cloth/add";
    }

    @GetMapping("/editPage/{id}")
    public String editPage(@PathVariable int id, Model model) {
        Cloth cloth = clothService.getById(id);
        model.addAttribute("cloth", cloth);
        return "page/cloth/edit";
    }
    @GetMapping("/detailPage/{id}")
    public String detailPage(@PathVariable int id, Model model) {
        Cloth cloth = clothService.getById(id);
        model.addAttribute("cloth", cloth);
        return "page/cloth/detail";
    }
}
