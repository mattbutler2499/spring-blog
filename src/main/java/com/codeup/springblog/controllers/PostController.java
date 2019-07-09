package com.codeup.springblog.controllers;

import com.codeup.springblog.Model.Post;
import com.codeup.springblog.Model.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }


    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        return "posts/createPost";
    }

    @PostMapping("/posts/create")
    public String insert(@RequestParam String title, @RequestParam String body) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post postToInsert = new Post(title, body);
        postToInsert.setAuthor(user);
        postDao.save(postToInsert);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
        System.out.println(post);
        model.addAttribute("post", postDao.findOne(id));
        return "/posts/editPost";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(
            @PathVariable long id,
            @RequestParam String title,
            @RequestParam String body,
            @RequestParam User author) {

        Post postToEdit = new Post(id, title, body, author);
        postDao.save(postToEdit);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.delete(id);
        return "redirect:/posts";
    }


}
