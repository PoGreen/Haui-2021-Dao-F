package com.haui.realestatebusiness.services.validators;


import com.haui.realestatebusiness.models.bos.Response;
import com.haui.realestatebusiness.models.bos.SystemResponse;
import com.haui.realestatebusiness.models.requests.ImageRq;
import com.haui.realestatebusiness.utils.Global;
import com.haui.realestatebusiness.utils.StringRp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Component
public class ImageValidator {
    public ResponseEntity<SystemResponse<Object>> validates (List<MultipartFile> files){
        for (MultipartFile file: files) {
            String abc = file.getContentType();
            if(!file.getContentType().startsWith("image/"))
            {
                return Response.badRequest(StringRp.FILE_IS_NOT_IMAGE);
            }
        }
        return Response.ok(StringRp.SUCCESS);
    }

    public ResponseEntity<SystemResponse<Object>> validate (List<ImageRq> imageRqs){
        for (ImageRq imageRq : imageRqs) {
            File file = new File(Global.PATH_FILE_IMAGE + imageRq.getName());
            if(!file.exists() || !file.isFile()){
                return Response.badRequest(StringRp.FILE_IS_NOT_EXISTS);
            }
        }
        return Response.ok(StringRp.SUCCESS);
    }
}
