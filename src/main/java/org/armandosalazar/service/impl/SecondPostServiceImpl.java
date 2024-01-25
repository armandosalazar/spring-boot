package org.armandosalazar.service.impl;

import org.armandosalazar.model.Post;
import org.armandosalazar.service.PostService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("secondPostServiceImpl")
public class SecondPostServiceImpl implements PostService {

    @Override
    public List<Post> validatePosts(List<Post> posts) {
        for (Post post : posts) {
            if (post.getId() == 0) {
                throw new IllegalArgumentException("Post id cannot be null");
            }
        }
        return posts;
    }
}
