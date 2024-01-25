package org.armandosalazar.controller;

import org.armandosalazar.component.PostComponent;
import org.armandosalazar.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class BasicController {
    @Autowired
    private PostComponent _postComponent;

    @GetMapping(path = {"/index"})
    public String index() {
        return "home";
    }

    @GetMapping(path = {"/home", "/hello", "/gallery"})
    public String home() {
        return "home";
    }

    @GetMapping(path = {"/posts", "/"})
    public String posts(Model model) {
        model.addAttribute("posts", _postComponent.getPosts());
        return "index";
    }

    @GetMapping(path = {"/post"})
    public ModelAndView post(@RequestParam(defaultValue = "1", name = "id", required = false) int id) {
        ModelAndView modelAndView = new ModelAndView("post");
        _postComponent.getPosts().stream().filter(post -> post.getId() == id).forEach(post -> modelAndView.addObject("post", post));
        return modelAndView;
    }

    @GetMapping(path = {"/post/{id}"})
    public ModelAndView postByPathVariable(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("post");
        _postComponent.getPosts().stream().filter(post -> post.getId() == id).forEach(post -> modelAndView.addObject("post", post));
        return modelAndView;
    }

    @GetMapping(path = "/public")
    public ModelAndView publicPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("posts", _postComponent.getPosts());
        return modelAndView;
    }

    @GetMapping(path = {"/form"})
    public ModelAndView form() {
        Post post = new Post();
        post.setId(1);
        post.setImage("/img/post.png");
        return new ModelAndView("form", "post", post);
    }

    @PostMapping(path = {"/form"})
    public String form(Post post, Model model) {
        Logger.getLogger(BasicController.class.getName()).info(post.toString());
        List<Post> posts = _postComponent.getPosts();
        posts.add(post);
        model.addAttribute("posts", posts);
        return "index";
    }


}
