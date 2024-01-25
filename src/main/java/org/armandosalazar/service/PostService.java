package org.armandosalazar.service;

import org.armandosalazar.model.Post;

import java.util.List;

public interface PostService {
    List<Post> validatePosts(List<Post> posts);
}
