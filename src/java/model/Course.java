/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Course {
    private int id;
    private String title;
    private String image;
    private String description;
    private String content;
    private String target;
    private String level;
    private String joinedNumber;

    public Course() {
    }

    public Course(int id, String title, String image, String description, String content, String target, String level, String joinedNumber) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.content = content;
        this.target = target;
        this.level = level;
        this.joinedNumber = joinedNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getJoinedNumber() {
        return joinedNumber;
    }

    public void setJoinedNumber(String joinedNumber) {
        this.joinedNumber = joinedNumber;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", title=" + title + ", image=" + image + ", description=" + description + ", content=" + content + ", target=" + target + ", level=" + level + ", joinedNumber=" + joinedNumber + '}';
    }
}
