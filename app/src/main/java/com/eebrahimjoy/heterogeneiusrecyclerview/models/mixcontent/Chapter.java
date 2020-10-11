package com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent;

import java.util.List;

public class Chapter {
    private String name;
    private List<SubChapter> subChapters;

    public Chapter() {
    }

    public Chapter(String name, List<SubChapter> subChapters) {
        this.name = name;
        this.subChapters = subChapters;
    }

    public String getName() {
        return name;
    }

    public List<SubChapter> getSubChapters() {
        return subChapters;
    }
}
