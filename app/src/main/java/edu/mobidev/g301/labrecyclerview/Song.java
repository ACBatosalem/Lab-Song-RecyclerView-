package edu.mobidev.g301.labrecyclerview;

/**
 * Created by ngoc on 1/27/2016.
 */
public class Song {
    private String title;
    private String lyrics;
    private int resourceId;

    public Song(){

    }

    public Song(String title, String lyrics, int resourceId) {
        this.title = title;
        this.lyrics = lyrics;
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
