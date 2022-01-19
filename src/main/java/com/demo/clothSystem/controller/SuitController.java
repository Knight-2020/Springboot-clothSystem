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
@RequestMapping("/suit")
public class SuitController {
    @Autowired
    private SuitServiceImpl suitService;

    @Autowired
    private PermissionServiceImpl permissionService;

    @PostMapping("/add")
    @ResponseBody
    public Response<Suit> add(@RequestBody Suit request) {
        Suit suit = suitService.add(request);
        return Response.ok(suit);
    }

    @PutMapping("/update")
    @ResponseBody
    public Response<Suit> update(@RequestBody Suit old) {
        Suit suit = suitService.update(old);
        return Response.ok(suit);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Response<String> delete(@PathVariable int id) {
        suitService.delete(id);
        return Response.ok();
    }

    @PostMapping("/page")
    @ResponseBody
    public ListResponse<Suit> page(@RequestBody ListSuitRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        return suitService.page(request, user);
    }

    @GetMapping("/list")
    @ResponseBody
    public ListResponse<Suit> list() {
        return suitService.listAll();
    }

    @GetMapping("/tablePage")
    public String tablePage(HttpSession httpSession, Model model) {
        String role = ((User) httpSession.getAttribute("user")).getRole();
        List<Permission> permissions = permissionService.list(new QueryWrapper<Permission>()
            .eq("role", role)
            .eq("model", "suit"));
        model.addAttribute("permissions", permissions.stream().map(Permission::getOperation).collect(Collectors.toList()));
        return "page/suit/table";
    }

    @GetMapping("/addPage")
    public String addPage () {
        return "page/suit/add";
    }

    @GetMapping("/editPage/{id}")
    public String editPage(@PathVariable int id, Model model) {
        Suit suit = suitService.getById(id);
        model.addAttribute("suit", suit);
        return "page/suit/edit";
    }
    @GetMapping("/detailPage/{id}")
    public String detailPage(@PathVariable int id, Model model) {
        Suit suit = suitService.getById(id);
        model.addAttribute("suit", suit);
        return "page/suit/detail";
    }
}
