package com.pakius.photo.dto;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by fjbecerra on 27/12/2014.
 */
@Entity
@Table( name = "PHOTO" )
public class Photo implements Serializable{

    @Id
    @GeneratedValue
    public String id;

    @Column(name = "cloudinaryId")
    public String cloudinaryId;

    public Photo(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (cloudinaryId != null ? !cloudinaryId.equals(photo.cloudinaryId) : photo.cloudinaryId != null) return false;
        if (id != null ? !id.equals(photo.id) : photo.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cloudinaryId != null ? cloudinaryId.hashCode() : 0);
        return result;
    }

}
