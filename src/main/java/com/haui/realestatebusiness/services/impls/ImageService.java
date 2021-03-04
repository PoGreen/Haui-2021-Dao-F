package com.haui.realestatebusiness.services.impls;


import com.haui.realestatebusiness.models.bos.Response;
import com.haui.realestatebusiness.models.bos.SystemResponse;
import com.haui.realestatebusiness.models.entities.Image;
import com.haui.realestatebusiness.models.requests.ImageRq;
import com.haui.realestatebusiness.models.responses.ImageRp;
import com.haui.realestatebusiness.models.responses.ImageUploadRp;
import com.haui.realestatebusiness.repositories.ImageRepository;
import com.haui.realestatebusiness.services.IImageService;
import com.haui.realestatebusiness.services.mappers.ImageMapper;
import com.haui.realestatebusiness.services.validators.ImageValidator;
import com.haui.realestatebusiness.utils.Global;
import com.haui.realestatebusiness.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService implements IImageService {

    @Autowired
    private ImageValidator imageValidator;
    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private ImageRepository imageRepository;


    @Override
    public ResponseEntity<SystemResponse<Object>> loadImage(List<MultipartFile> images) throws IOException {
        ResponseEntity<SystemResponse<Object>> validate = imageValidator.validates(images);
        if (!validate.getStatusCode().is2xxSuccessful()) {
            return validate;
        }
        List<ImageUploadRp> imageUploadRps = new ArrayList<>();
        for (MultipartFile file : images) {
            String idImage = Util.generateUUID();
            String path = Global.PATH_FILE_IMAGE + idImage;
            try {
                file.transferTo(new File(path));
            } catch (IOException e) {
                throw new IOException(e.getMessage());
            }
            ImageUploadRp imageUploadRp = new ImageUploadRp();
            imageUploadRp.setName(idImage);
            imageUploadRp.setType(file.getContentType());
            imageUploadRps.add(imageUploadRp);
        }

        return Response.ok(imageUploadRps);
    }


    @Override
    public ResponseEntity<SystemResponse<Object>> saveImage(String idBelongs, String category, List<ImageRq> imageRqs) {
        ResponseEntity<SystemResponse<Object>> validate = imageValidator.validate(imageRqs);
        if (!validate.getStatusCode().is2xxSuccessful()) {
            return validate;
        }
        List<Image> images = imageMapper.mapToImage(imageRqs,idBelongs,category);
        images = imageRepository.saveAll(images);
        List<ImageRp> imageRps = imageMapper.mapToImageRp(images);
        return Response.ok(imageRps);
    }
}
