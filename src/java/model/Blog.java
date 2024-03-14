/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */


public class Blog implements Serializable{
    private int id;
    private String image;
    private String title;
    private String content;
    private int like;
    private int comment;
    private User user;
    private String status;

    public Blog() {
    }

    public Blog(int id, String image, String title, String content, int like, int comment, User user, String status) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.content = content;
        this.like = like;
        this.comment = comment;
        this.user = user;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", image=" + image + ", title=" + title + ", content=" + content + ", like=" + like + ", comment=" + comment + ", user=" + user + ", status=" + status + '}';
    }

    
    
}
