package mobile.unisinos.br.jsonvimeo.pojo;

/**
 * Created by alan on 26/07/2016.
 *
 * JSON Exemplo
 * {"id":165066737,
 "title":"Wizard Mode",
 "description":"",
 "url":"https:\/\/vimeo.com\/165066737",
 "upload_date":"2016-05-02 18:06:27",
 "thumbnail_small":"https:\/\/i.vimeocdn.com\/video\/568830694_100x75.webp",
 "thumbnail_medium":"https:\/\/i.vimeocdn.com\/video\/568830694_200x150.webp",
 "thumbnail_large":"https:\/\/i.vimeocdn.com\/video\/568830694_640.webp",
 "user_id":625139,
 "user_name":"Salazar",
 "user_url":"https:\/\/vimeo.com\/salazarfilm",
 "user_portrait_small":"https:\/\/i.vimeocdn.com\/portrait\/7486203_30x30.webp",
 "user_portrait_medium":"https:\/\/i.vimeocdn.com\/portrait\/7486203_75x75.webp",
 "user_portrait_large":"https:\/\/i.vimeocdn.com\/portrait\/7486203_100x100.webp",
 "user_portrait_huge":"https:\/\/i.vimeocdn.com\/portrait\/7486203_300x300.webp",
 "stats_number_of_likes":58,
 "stats_number_of_plays":2764,
 "stats_number_of_comments":0,
 "duration":5872,
 "width":1920,
 "height":1080,
 "tags":"",
 "embed_privacy":"nowhere"}
 */

public class UserVideo {
    long _id;
    String title;
    String description;
    String url;
    String uploadDate;
    long userId;
    String userName;
    String userUrl;
    long statsNumberOfLikes;
    long statsNumberOfPlays;
    long statsNumberOfComments;
    long duration;
    long width;
    long height;
    String tags;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public long getStatsNumberOfLikes() {
        return statsNumberOfLikes;
    }

    public void setStatsNumberOfLikes(long statsNumberOfLikes) {
        this.statsNumberOfLikes = statsNumberOfLikes;
    }

    public long getStatsNumberOfPlays() {
        return statsNumberOfPlays;
    }

    public void setStatsNumberOfPlays(long statsNumberOfPlays) {
        this.statsNumberOfPlays = statsNumberOfPlays;
    }

    public long getStatsNumberOfComments() {
        return statsNumberOfComments;
    }

    public void setStatsNumberOfComments(long statsNumberOfComments) {
        this.statsNumberOfComments = statsNumberOfComments;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
