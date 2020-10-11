package com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent;

public class Document {
    private String title;
    private String subTitle;

    public Document() {
    }

    public Document(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
