package com.example.reditproject2.Controllers;

import com.example.reditproject2.Services.PostService;
import com.example.reditproject2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    final PostService postService;
    final UserService userService;
    @Autowired
    public MainController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/all/{id}")
    public String renderAllPostPage( Model model, @PathVariable Long id){
        model.addAttribute("posts", postService.getAllPosts());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("id", id);
        return "AllPost";
    }

    @GetMapping("/addNew/{id}")
    public String renderAddNewPost(Model model, @PathVariable Long id){
        model.addAttribute("id",id);
        return "addPost";
    }

    @PostMapping("/addPost/{id}")
    public String addNewPost(@RequestParam String title, @RequestParam String url,@PathVariable Long id){
        postService.addNewPost(title,url,id);
        return "redirect:/all/" + id;
    }
    @GetMapping("/addlike/{id}")
    public String addlike (@PathVariable Long id){
        postService.addLike(id);
        return "redirect:/all/" + id;
    }

    @GetMapping("/addDislike/{id}")
    public String addDislike (@PathVariable Long id){
        postService.addDislike(id);
        return "redirect:/all/" + id;
    }

    @GetMapping("/register")
    public String renderRegisterPage(Model model){
        return "register";
    }
    @GetMapping("/login")
    public String renderLoginPage(Model model){
        return "login";
    }

    @PostMapping("/login")
    public String loginToPage(@RequestParam String name, @RequestParam String password){
        if (userService.loginUser(name,password)){
            return "redirect:/all/" + userService.getId(name);
        } else {
            return "register";
        }
    }
    @PostMapping("/register")
    public String registerNewUser(@RequestParam String name, @RequestParam String password){
        userService.addUser(name,password);
        return "redirect:/all/" + userService.getId(name);
    }

}
