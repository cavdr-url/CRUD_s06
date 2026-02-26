package com.sesionclase04.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sesionclase04.crud.repository.DidacticResourceRepository;

@Controller
public class LoginController {

    private final DidacticResourceRepository repo;

    public LoginController(DidacticResourceRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/admin/panel")
    public String adminPanel(Model model) {
        model.addAttribute("resources", repo.findAll());
        model.addAttribute("total", repo.count());
        return "admin/panel";
    }

    @RequestMapping("/usuario/inicio")
    public String usuarioInicio(Model model) {
        model.addAttribute("resources", repo.findAll());
        return "usuario/inicio";
    }
}
