package com.pakius.photo.repository;


import com.pakius.photo.dto.Photo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Francisco on 18/12/2014.
 */
public interface PhotoRepository extends JpaRepository<Photo, String> {

}
