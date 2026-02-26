package com.sesionclase04.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sesionclase04.crud.model.DidacticResource;
import com.sesionclase04.crud.repository.DidacticResourceRepository;

@Controller
@RequestMapping("/recursos")
public class DidacticResourceController {

    private final DidacticResourceRepository repo;

    public DidacticResourceController(DidacticResourceRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("resource", new DidacticResource());
        return "recursos/form";
    }

    @PostMapping
    public String create(@ModelAttribute DidacticResource resource) {
        if (resource.getAvailable() == null) resource.setAvailable(false);
        repo.save(resource);
        return "redirect:/admin/panel";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable(value = "id") Long id, Model model) {
        if (id == null) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }
        DidacticResource resource = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));

        model.addAttribute("resource", resource);
        return "recursos/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable(value = "id") Long id, @ModelAttribute DidacticResource resource) {
        resource.setId(id);
        if (resource.getAvailable() == null) {
            resource.setAvailable(false);
        }
        repo.save(resource);
        return "redirect:/admin/panel";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }
        repo.deleteById(id);
        return "redirect:/admin/panel";
    }
}
