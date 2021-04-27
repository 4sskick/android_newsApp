package com.niteroomcreation.newsapp.model;

import org.joda.time.DateTime;

/**
 * Created by Septian Adi Wijaya on 26/03/2021.
 * please be sure to add credential if you use people's code
 */
public class NewsModel {

    private int id;
    private String title;
    private String content;
    private String userName;
    private String newsImage;
    private String userImage;
    private String bgNewsColor;
    private DateTime dateCreation;

    //0 : for text view type
    //1: for image view type
    private int viewType;

    public NewsModel() {

    }

    //fake date used
    public NewsModel(int id
            , String title
            , String content
            , String userName
            , String newsImage
            , String userImage
            , String bgNewsColor
            , int viewType) {

        this.id = id;
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.newsImage = newsImage;
        this.userImage = userImage;
        this.bgNewsColor = bgNewsColor;
        this.viewType = viewType;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getBgNewsColor() {
        return bgNewsColor;
    }

    public void setBgNewsColor(String bgNewsColor) {
        this.bgNewsColor = bgNewsColor;
    }

    public DateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(DateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", newsImage='" + newsImage + '\'' +
                ", userImage='" + userImage + '\'' +
                ", bgNewsColor='" + bgNewsColor + '\'' +
                ", dateCreation=" + dateCreation +
                ", viewType=" + viewType +
                '}';
    }
}
