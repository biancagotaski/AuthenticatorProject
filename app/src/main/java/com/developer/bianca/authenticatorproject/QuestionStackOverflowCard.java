package com.developer.bianca.authenticatorproject;

import java.io.Serializable;

public class QuestionStackOverflowCard implements Serializable {
    private String title;
    private String link;
    private String tag;

    public QuestionStackOverflowCard(String title, String link, String tag) {
        this.title = title;
        this.link = link;
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

