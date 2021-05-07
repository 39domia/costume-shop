package com.controller;

import com.model.Tag;
import com.model.User;
import com.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @GetMapping("/tag/create")
    public String showTagAddForm(Model model) {
        model.addAttribute("tag", new Tag());
        return "back-end/tag/tag-add";
    }

    @PostMapping("/tag/create")
    public String addTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
//        new Tag().validate(tag, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/tag/tag-add";
        } else {
            service.add(tag);
            attributes.addFlashAttribute("mess", "Add success");
            return "redirect:/tag";
        }
    }

    @GetMapping("/tag/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("tag", service.findOne(id).get());
        return "back-end/tag/tag-edit";
    }

    @PostMapping("/tag/update")
    public String update(@Valid @ModelAttribute("tag") Tag tag, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
//        new Tag().validate(tag, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "back-end/tag/tag-edit";
        } else {
            service.update(tag);
            attributes.addFlashAttribute("mess", "Update success");
            return "redirect:/tag";
        }
    }

    @GetMapping("/tag/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/tag";
    }

    @GetMapping("/tag/search")
    public String search(@RequestParam(defaultValue = "") String keyword, Model
            model, @PageableDefault(size = 10) Pageable pageable) {
        Page<Tag> tags = service.findByNameContaining(keyword, pageable);
        model.addAttribute("tags", tags);
        if (!tags.hasContent())
            model.addAttribute("searchMess", "Not found");
        return "back-end/tag/tag-list";
    }



}
