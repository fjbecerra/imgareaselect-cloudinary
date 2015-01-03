package com.pakius.photo.model;

import java.io.Serializable;

/**
 * Created by fjbecerra on 28/12/2014.
 */
public class PhotoModel implements Serializable {

    private Integer width;
    private Integer height;
    private Integer x1;
    private Integer y1;
    private Integer x2;
    private Integer y2;
    private String id;
    private String url;

    public PhotoModel() {
    }

    public PhotoModel(Integer width, Integer height, Integer x1, Integer y1, Integer x2, Integer y2, String id, String url) {
        this.width = width;
        this.height = height;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.id = id;
        this.url = url;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }

    public Integer getX1() {
        return x1;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoModel that = (PhotoModel) o;

        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (width != null ? !width.equals(that.width) : that.width != null) return false;
        if (x1 != null ? !x1.equals(that.x1) : that.x1 != null) return false;
        if (x2 != null ? !x2.equals(that.x2) : that.x2 != null) return false;
        if (y1 != null ? !y1.equals(that.y1) : that.y1 != null) return false;
        if (y2 != null ? !y2.equals(that.y2) : that.y2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = width != null ? width.hashCode() : 0;
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (x1 != null ? x1.hashCode() : 0);
        result = 31 * result + (y1 != null ? y1.hashCode() : 0);
        result = 31 * result + (x2 != null ? x2.hashCode() : 0);
        result = 31 * result + (y2 != null ? y2.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
