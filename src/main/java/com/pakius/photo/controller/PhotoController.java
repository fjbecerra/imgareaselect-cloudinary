package com.pakius.photo.controller;

import com.pakius.photo.model.PhotoModel;
import com.pakius.photo.service.PhotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * Created by Francisco on 17/12/2014.
 */
@Controller
public class PhotoController {

    private static final Logger log = LoggerFactory.getLogger(PhotoController.class);

    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestPart("files") MultipartFile file, ModelMap model)
    {
        try
        {
           model.addAttribute("photoModel",  photoService.uploadPhoto(file.getBytes()));
        }
        catch (IOException e)
        {
           log.error(e.getMessage());
        }
        return "content";
    }

    @RequestMapping(value = "/crop", method = RequestMethod.POST)
    public String cropImage(@ModelAttribute("photo") PhotoModel photoModel, ModelMap model) {
        model.addAttribute("photoModel", photoService.cropPhoto(photoModel));
        return "content";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String photoId)
    {
        try
        {
            photoService.deletePhoto(photoId);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
        }
        return "index";
    }



}
