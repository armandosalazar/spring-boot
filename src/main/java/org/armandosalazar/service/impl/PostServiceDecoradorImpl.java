package org.armandosalazar.service.impl;

import org.armandosalazar.model.Post;
import org.armandosalazar.service.PostService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Service
public class PostServiceDecoradorImpl implements PostService {
    private final PostService postService;
    private final PostService secondPostService;

    // @Autowired is not necessary if there is only one constructor
    public PostServiceDecoradorImpl(
            @Qualifier("postServiceImpl") PostService postService,
            @Qualifier("secondPostServiceImpl") PostService secondPostService
    ) {
        this.postService = postService;
        this.secondPostService = secondPostService;
    }


    @Override
    public List<Post> validatePosts(List<Post> posts) {
        posts = postService.validatePosts(posts);
        posts = secondPostService.validatePosts(posts);
        for (Post post : posts) {
            post.setTitle(post.getTitle().concat(" - Decorator"));
        }
        return posts;
    }

    @Override
    public void addClass(Class<?> clazz) {
        Logger.getLogger(PostServiceDecoradorImpl.class.getName())
                .info(String.format(Locale.ROOT, "🚀::addClass(%s)", clazz.getName()));
    }
}
