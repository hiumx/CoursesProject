/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */


//-- Create the Blog table
//CREATE TABLE Blog (
//    Id INT IDENTITY PRIMARY KEY,
//    Image VARCHAR(MAX),
//    Title NVARCHAR(100) NOT NULL,
//    Content NVARCHAR(MAX),
//    UserId INT FOREIGN KEY REFERENCES [User](Id)
//);

public class Blog {
    private int id;
    private String image;
    private String title;
    private String content;
    private int userId;

    public Blog() {
    }

    public Blog(int id, String image, String title, String content, int userId) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.content = content;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", image=" + image + ", title=" + title + ", content=" + content + ", userId=" + userId + '}';
    }
    
    
}
