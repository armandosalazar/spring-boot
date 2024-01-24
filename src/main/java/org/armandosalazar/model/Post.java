package org.armandosalazar.model;

public class Post {
    private String title;
    private String content;
    private String imgSrc;
    private String url;

    public Post() {
    }

    public Post(String title, String content, String imgSrc, String url) {
        this.title = title;
        this.content = content;
        this.imgSrc = imgSrc;
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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
