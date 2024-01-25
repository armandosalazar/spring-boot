package org.armandosalazar.service.impl;

import org.armandosalazar.model.Post;
import org.armandosalazar.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public List<Post> validatePosts(List<Post> posts) {
        Logger.getLogger(PostServiceImpl.class.getName()).info("🚀::firstService::validatePosts()");
        for (Post post : posts) {
            if (post.getTitle() == null || post.getTitle().isEmpty()) {
                throw new IllegalArgumentException("Post title cannot be null or empty");
            }
            post.setTitle(post.getTitle().toUpperCase());
        }
        return posts;
    }
}
