package com.example.swastha;

public class InfoItem {
    private String title;
    private String description;
    private boolean expanded;

    public InfoItem(String title, String description) {
        this.title = title;
        this.description = description;
        this.expanded = false;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isExpanded() { return expanded; }
    public void setExpanded(boolean expanded) { this.expanded = expanded; }
}

