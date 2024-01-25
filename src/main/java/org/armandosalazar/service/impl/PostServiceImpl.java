package org.armandosalazar.service.impl;

import org.armandosalazar.model.Post;
import org.armandosalazar.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public List<Post> validatePosts(List<Post> posts) {
        for (Post post : posts) {
            if (post.getTitle() == null || post.getTitle().isEmpty()) {
                throw new IllegalArgumentException("Post title cannot be null or empty");
            }
            post.setTitle(post.getTitle().toUpperCase());
        }
        return posts;
    }
}
