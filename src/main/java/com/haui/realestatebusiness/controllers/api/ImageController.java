package com.haui.realestatebusiness.controllers.api;



import com.haui.realestatebusiness.models.bos.SystemResponse;
import com.haui.realestatebusiness.models.requests.ImageRq;
import com.haui.realestatebusiness.services.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class ImageController {

    @Autowired
    private IImageService iImageService;

    @PostMapping(value = "/images/upload")
    public ResponseEntity<SystemResponse<Object>> loadImage(@RequestParam(value = "images") List<MultipartFile> image) throws IOException {
        return iImageService.loadImage(image);
    }
}
