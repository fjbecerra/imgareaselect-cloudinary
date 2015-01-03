package com.pakius.photo.service;

import com.pakius.photo.model.PhotoModel;


import java.io.IOException;


/**
 * Created by Francisco on 18/12/2014.
 */
public interface PhotoService {

    public PhotoModel uploadPhoto(byte[] photoBytes) throws IOException;

    public PhotoModel cropPhoto(PhotoModel photo);

    public void deletePhoto(String photoId) throws Exception;
}
