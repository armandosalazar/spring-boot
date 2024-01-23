package org.armandosalazar.model;

public class Post {
    private String title;
    private String content;
    private String image;
    private String url;

    public Post() {
    }

    public Post(String title, String content, String image, String url) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
