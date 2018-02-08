package com.ydx.test.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class Resource implements Serializable {
    private String id;
    private String text;
    private String url;
    @JsonProperty("_parentId")
    private int parentId;
    private String texts;

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    //Set是不可重复，但是是无序的，，所以要加上Linked，LinkedHashSet就成了唯一、有序的
    private Set<Resource> children = new LinkedHashSet<Resource>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Resource> getChildren() {
        return children;
    }

    public void setChildren(Set<Resource> children) {
        this.children = children;
    }
}
