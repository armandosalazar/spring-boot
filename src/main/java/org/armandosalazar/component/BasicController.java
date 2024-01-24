package org.armandosalazar.component;

import org.armandosalazar.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BasicController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping(path = {"/home", "/hello", "/gallery"})
    public String home() {
        return "home";
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", this.getPosts());
        return "index";
    }

    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Web Development", "A web developer is a specialist who has the necessary knowledge for the creation and maintenance of websites. In general terms, the web developer is in charge of designing the sites and developing their functions, using programming languages and specialized software.", "/img/post.png", "https://picsum.photos/200/300"));
        posts.add(new Post("Web Development Front-End", "A web developer is a specialist who has the necessary knowledge for the creation and maintenance of websites. In general terms, the web developer is in charge of designing the sites and developing their functions, using programming languages and specialized software.", "/img/post.png", "https://picsum.photos/200/300"));
        posts.add(new Post("Web Development Back-End", "A web developer is a specialist who has the necessary knowledge for the creation and maintenance of websites. In general terms, the web developer is in charge of designing the sites and developing their functions, using programming languages and specialized software.", "/img/post.png", "https://picsum.photos/200/300"));
        posts.add(new Post("Web Development UX/UI", "A web developer is a specialist who has the necessary knowledge for the creation and maintenance of websites. In general terms, the web developer is in charge of designing the sites and developing their functions, using programming languages and specialized software.", "/img/post.png", "https://picsum.photos/200/300"));
        return posts;
    }

}
