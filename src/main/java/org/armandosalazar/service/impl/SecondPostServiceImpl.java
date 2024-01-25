package org.armandosalazar.service.impl;

import org.armandosalazar.model.Post;
import org.armandosalazar.service.PostService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service // @Service("secondPostServiceImpl") is also valid
@Qualifier("secondPostServiceImpl") // is not necessary if @Service("secondPostServiceImpl") is used
public class SecondPostServiceImpl implements PostService {

    @Override
    public List<Post> validatePosts(List<Post> posts) {
        Logger.getLogger(SecondPostServiceImpl.class.getName()).info("🚀::secondService::validatePosts()");
        for (Post post : posts) {
            if (post.getId() == 0) {
                throw new IllegalArgumentException("Post id cannot be null");
            }
        }
        return posts;
    }
}
