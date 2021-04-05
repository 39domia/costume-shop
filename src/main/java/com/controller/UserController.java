package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.*;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/user")
    public String showAll(Model model, @PageableDefault(size = 10) Pageable pageable) {
        model.addAttribute("users", service.selectAll(pageable));
        return "back-end/user/user-list";
    }

    @GetMapping("/user/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.findOne(id).get());
        return "back-end/user/user-view";
    }

    @GetMapping("/user/create")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "back-end/user/user-add";
    }

    @PostMapping("/user/create")
    public String add(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, HttpServletRequest request, RedirectAttributes attributes) throws IOException {
//        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors())
            return "back-end/user/user-add";
        String uploadRootPath = request.getServletContext().getRealPath("upload");
        File uploadRootDir = new File(uploadRootPath);
        String uploadLocalPath = "C:\\mainCode\\costume-shop-cs-4\\src\\main\\webapp\\upload";
        File uploadLocalDir = new File(uploadLocalPath);
        // Tạo thư mục gốc upload nếu nó không tồn tại.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdir();
        }
        CommonsMultipartFile[] files = user.getImage();
//        Map<File, String> uploadFile = new HashMap<>();
        for (CommonsMultipartFile commonsMultipartFile : files) {
            // Tên file gốc tại Clien
            String name = commonsMultipartFile.getOriginalFilename();
            if (name != null && name.length() > 0) {
                // Tạo file tại Server
                File severFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
                // Luồng ghi dữ liệu vào file trên Server
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(severFile));
                stream.write(commonsMultipartFile.getBytes());
                stream.close();
                File localFile = new File(uploadLocalDir.getAbsolutePath() + File.separator + name);
                // Luồng ghi dữ liệu vào file trên Server
                BufferedOutputStream streamLocal = new BufferedOutputStream(new FileOutputStream(localFile));
                streamLocal.write(commonsMultipartFile.getBytes());
                streamLocal.close();
                user.setImageUrl(name);
            }
        }
        if (user != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            attributes.addFlashAttribute("mess", "Add success");
            service.add(user);

            model.addAttribute("message", "Add success");
            return "redirect:/user";

        }
        return "back-end/user/user-add";

//        if (bindingResult.hasFieldErrors()) {
//            return "back-end/user/user-add";
//        } else {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            service.add(user);
//            return "redirect:/user";
//        }

    }

    @GetMapping("/user/update/{id}")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.findOne(id).get());
        return "back-end/user/user-edit";
    }

    @PostMapping("/user/update")
    public String update(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, HttpServletRequest request, RedirectAttributes attributes) throws IOException {
//        new User().validate(user, bindingResult);
//        System.out.println(user.toString());
        if (bindingResult.hasFieldErrors())
            return "back-end/user/user-edit";
        String uploadRootPath = request.getServletContext().getRealPath("upload");
        File uploadRootDir = new File(uploadRootPath);
        String uploadLocalPath = "C:\\mainCode\\costume-shop-cs-4\\src\\main\\webapp\\upload";
        File uploadLocalDir = new File(uploadLocalPath);
        // Tạo thư mục gốc upload nếu nó không tồn tại.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdir();
        }
        CommonsMultipartFile[] files = user.getImage();
//        Map<File, String> uploadFile = new HashMap<>();
        for (CommonsMultipartFile commonsMultipartFile : files) {
            // Tên file gốc tại Clien
            String name = commonsMultipartFile.getOriginalFilename();
            if (name != null && name.length() > 0) {
                // Tạo file tại Server
                File severFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
                // Luồng ghi dữ liệu vào file trên Server
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(severFile));
                stream.write(commonsMultipartFile.getBytes());
                stream.close();
                File localFile = new File(uploadLocalDir.getAbsolutePath() + File.separator + name);
                // Luồng ghi dữ liệu vào file trên Server
                BufferedOutputStream streamLocal = new BufferedOutputStream(new FileOutputStream(localFile));
                streamLocal.write(commonsMultipartFile.getBytes());
                streamLocal.close();
                user.setImageUrl(name);
            }
        }
        if (user != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            attributes.addFlashAttribute("mess", "Update success");
            service.update(user);

            model.addAttribute("message", "Edit success");
            return "redirect:/user";
        }
        return "back-end/user/user-edit";


//        if (bindingResult.hasFieldErrors()) {
//            return "back-end/user/user-edit";
//        } else {
//            service.update(user);
//            return "redirect:/user";
//        }
    }

    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/user";
    }

    @GetMapping("/user/search")
    public String search(@RequestParam(defaultValue = "") String keyword, Model
            model, @PageableDefault(size = 10) Pageable pageable) {
        Page<User> users = service.findByFullNameContaining(keyword, pageable);
        model.addAttribute("users", users);
        if (!users.hasContent())
            model.addAttribute("searchMess", "Not found");
        return "back-end/user/user-list";
    }


}
