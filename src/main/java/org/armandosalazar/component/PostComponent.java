package org.armandosalazar.component;

import org.armandosalazar.model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("postComponent")
public class PostComponent {
    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "Web Development", "A web developer is a specialist who has the necessary knowledge for the creation and maintenance of websites. In general terms, the web developer is in charge of designing the sites and developing their functions, using programming languages and specialized software.", "/img/post.png"));
        posts.add(new Post(2, "Web Development Front-End", "A web developer is a specialist who has the necessary knowledge for the creation and maintenance of websites. In general terms, the web developer is in charge of designing the sites and developing their functions, using programming languages and specialized software.", "/img/post.png"));
        posts.add(new Post(3, "Web Development Back-End", "A web developer is a specialist who has the necessary knowledge for the creation and maintenance of websites. In general terms, the web developer is in charge of designing the sites and developing their functions, using programming languages and specialized software.", "/img/post.png"));
        posts.add(new Post(4, "Web Development UX/UI", "A web developer is a specialist who has the necessary knowledge for the creation and maintenance of websites. In general terms, the web developer is in charge of designing the sites and developing their functions, using programming languages and specialized software.", "/img/post.png"));
        return posts;
    }
}
