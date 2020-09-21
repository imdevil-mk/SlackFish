package com.imdevil.slackfish.bean;

import java.util.List;

public class BoringPic {
    /**
     * comment_ID : 4697995
     * comment_post_ID : 26402
     * comment_author : miko
     * comment_date : 2020-09-21 18:03:44
     * comment_date_gmt : 2020-09-21 18:03:44
     * comment_content : 被刷屏了，所以就买了一份亲自体验一下
     <img src="http://ww1.sinaimg.cn/mw600/5e837f45gy1giyfgypqf3j20qa0ixacz.jpg" />
     * user_id : 0
     * vote_positive : 10
     * vote_negative : 46
     * sub_comment_count : 0
     * text_content : 被刷屏了，所以就买了一份亲自体验一下
     * pics : ["http://ww1.sinaimg.cn/mw600/5e837f45gy1giyfgypqf3j20qa0ixacz.jpg"]
     */

    private String comment_ID;
    private String comment_post_ID;
    private String comment_author;
    private String comment_date;
    private String comment_date_gmt;
    private String comment_content;
    private String user_id;
    private String vote_positive;
    private String vote_negative;
    private String sub_comment_count;
    private String text_content;
    private List<String> pics;

    public String getComment_ID() {
        return comment_ID;
    }

    public void setComment_ID(String comment_ID) {
        this.comment_ID = comment_ID;
    }

    public String getComment_post_ID() {
        return comment_post_ID;
    }

    public void setComment_post_ID(String comment_post_ID) {
        this.comment_post_ID = comment_post_ID;
    }

    public String getComment_author() {
        return comment_author;
    }

    public void setComment_author(String comment_author) {
        this.comment_author = comment_author;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public String getComment_date_gmt() {
        return comment_date_gmt;
    }

    public void setComment_date_gmt(String comment_date_gmt) {
        this.comment_date_gmt = comment_date_gmt;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVote_positive() {
        return vote_positive;
    }

    public void setVote_positive(String vote_positive) {
        this.vote_positive = vote_positive;
    }

    public String getVote_negative() {
        return vote_negative;
    }

    public void setVote_negative(String vote_negative) {
        this.vote_negative = vote_negative;
    }

    public String getSub_comment_count() {
        return sub_comment_count;
    }

    public void setSub_comment_count(String sub_comment_count) {
        this.sub_comment_count = sub_comment_count;
    }

    public String getText_content() {
        return text_content;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }
}
