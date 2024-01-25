package org.armandosalazar.component;

import org.armandosalazar.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class BasicController {

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
        model.addAttribute("posts", this.getPosts());
        return "index";
    }

    @GetMapping(path = {"/post"})
    public ModelAndView post(@RequestParam(defaultValue = "1", name = "id", required = false) int id) {
        ModelAndView modelAndView = new ModelAndView("post");
        this.getPosts().stream().filter(post -> post.getId() == id).forEach(post -> modelAndView.addObject("post", post));
        return modelAndView;
    }

    @GetMapping(path = {"/post/{id}"})
    public ModelAndView postByPathVariable(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("post");
        this.getPosts().stream().filter(post -> post.getId() == id).forEach(post -> modelAndView.addObject("post", post));
        return modelAndView;
    }

    @GetMapping(path = "/public")
    public ModelAndView publicPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("posts", this.getPosts());
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
        List<Post> posts = this.getPosts();
        posts.add(post);
        model.addAttribute("posts", posts);
        return "index";
    }

    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "Web Development", "A web developer is a specialist who has the necessary knowledge for the creation and maintenance of websites. In general terms, the web developer is in charge of designing the sites and developing their functions, using programming languages and specialized software.", "/img/post.png"));
        posts.add(new Post(2, "Web Development Front-End", "A web developer is a specialist who has the necessary knowledge for the creation and maintenance of websites. In general terms, the web developer is in charge of designing the sites and developing their functions, using programming languages and specialized software.", "/img/post.png"));
        posts.add(new Post(3, "Web Development Back-End", "A web developer is a specialist who has the necessary knowledge for the creation and maintenance of websites. In general terms, the web developer is in charge of designing the sites and developing their functions, using programming languages and specialized software.", "/img/post.png"));
        posts.add(new Post(4, "Web Development UX/UI", "A web developer is a specialist who has the necessary knowledge for the creation and maintenance of websites. In general terms, the web developer is in charge of designing the sites and developing their functions, using programming languages and specialized software.", "/img/post.png"));
        return posts;
    }

}
