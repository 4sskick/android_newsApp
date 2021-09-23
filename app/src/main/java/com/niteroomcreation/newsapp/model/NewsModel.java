package com.niteroomcreation.newsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.joda.time.DateTime;

/**
 * Created by Septian Adi Wijaya on 26/03/2021.
 * please be sure to add credential if you use people's code
 */
public class NewsModel implements Parcelable {

    private int id;
    private String title;
    private String content;
    private String userName;
    private String newsImage;
    private String userImage;
    private String bgNewsColor;
    private DateTime dateCreation;
    private boolean fav;

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

    public NewsModel(int id
            , String title
            , String content
            , String userName
            , String newsImage
            , String userImage
            , String bgNewsColor
            , int viewType
            , boolean fav) {

        this.id = id;
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.newsImage = newsImage;
        this.userImage = userImage;
        this.bgNewsColor = bgNewsColor;
        this.viewType = viewType;
        this.fav = fav;
    }

    protected NewsModel(Parcel in) {
        id = in.readInt();
        title = in.readString();
        content = in.readString();
        userName = in.readString();
        newsImage = in.readString();
        userImage = in.readString();
        bgNewsColor = in.readString();
        fav = in.readByte() != 0;
        viewType = in.readInt();
    }

    public static final Creator<NewsModel> CREATOR = new Creator<NewsModel>() {
        @Override
        public NewsModel createFromParcel(Parcel in) {
            return new NewsModel(in);
        }

        @Override
        public NewsModel[] newArray(int size) {
            return new NewsModel[size];
        }
    };

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

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
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
                ", fav=" + fav +
                ", viewType=" + viewType +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(userName);
        dest.writeString(newsImage);
        dest.writeString(userImage);
        dest.writeString(bgNewsColor);
        dest.writeByte((byte) (fav ? 1 : 0));
        dest.writeInt(viewType);
    }
}
