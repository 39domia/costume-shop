package com.controller;

import com.model.Tag;
import com.service.TagService;
import com.service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TagController {

    @Autowired
    private TagService service;

    @GetMapping("/tag")
    public String showAll(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("tags", service.selectAll(pageable));
//        return "back-end/tag/tag-list";
        return "back-end/tag/tag-list";
    }

    @GetMapping("/tag/view/{id}")
    public String view(@PathVariable Long id, Model model){
        model.addAttribute("tag", service.findOne(id).get());
        return "back-end/tag/tag-view";
    }

    @GetMapping("/tag/create")
    public String showTagAddForm(Model model) {
        model.addAttribute("tag", new Tag());
        return "back-end/tag/tag-add";
    }

    @PostMapping("/tag/create")
    public String addTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult bindingResult, Model model) {
//        new Tag().validate(tag, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/tag/tag-add";
        } else {
            service.add(tag);
            return "redirect:/tag";
        }
    }

    @GetMapping("/tag/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("tag", service.findOne(id).get());
        return "back-end/tag/tag-edit";
    }

    @PostMapping("/tag/update")
    public String update(@Valid @ModelAttribute("tag") Tag tag, BindingResult bindingResult, Model model) {
//        new Tag().validate(tag, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/tag/tag-edit";
        } else {
            service.update(tag);
            return "redirect:/tag";
        }
    }



}
