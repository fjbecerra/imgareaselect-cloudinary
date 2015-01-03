package com.pakius.photo.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.pakius.photo.model.PhotoModel;
import com.pakius.photo.dto.Photo;
import com.pakius.photo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Francisco on 18/12/2014.
 */
@Component("photoService")
@Transactional
public class PhotoServiceImpl implements PhotoService{

    private final PhotoRepository photoRepository;
    private final Cloudinary cloudinary;

    @Value("${cloudinary.url.base}")
    private String cloudinaryUrlBase;

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository, Cloudinary cloudinary) {
        this.photoRepository = photoRepository;
        this.cloudinary = cloudinary;
    }

    @Override
    public PhotoModel uploadPhoto(byte[] photoBytes) throws IOException {
        Map<String, String> map = cloudinary.uploader().upload(photoBytes, Cloudinary.emptyMap());

        Photo photo = new Photo();
        photo.cloudinaryId = map.get("public_id");
        photoRepository.save(photo);

        PhotoModel photoModel = new PhotoModel();
        photoModel.setId(photo.id);
        photoModel.setUrl(map.get("url"));

        return photoModel;
    }

    @Override
    public PhotoModel cropPhoto(PhotoModel photoModel) {
       Photo photo = photoRepository.findOne(photoModel.getId());

       StringBuffer cropUrl = new StringBuffer(cloudinaryUrlBase);
       cropUrl.append("h_").append(photoModel.getHeight()).append(",")
              .append("w_").append(photoModel.getWidth()).append(",")
              .append("x_").append(photoModel.getX2()).append(",")
              .append("y_").append(photoModel.getY2()).append(",")
              .append("x_").append(photoModel.getX1()).append(",")
              .append("y_").append(photoModel.getY1()).append(",")
              .append("c_crop")
              .append("/").append(photo.cloudinaryId);
        photoModel.setUrl(cropUrl.toString());

        return photoModel;
    }

    @Override
    public void deletePhoto(String photoId) throws Exception {
        Photo photo = photoRepository.findOne(photoId);
        cloudinary.api().deleteResourcesByTag(photo.cloudinaryId, Cloudinary.emptyMap());
        photoRepository.delete(photo);
    }
}
