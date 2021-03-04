package com.haui.realestatebusiness.services;


import com.haui.realestatebusiness.models.bos.SystemResponse;
import com.haui.realestatebusiness.models.requests.BuildingCInsertRq;
import com.haui.realestatebusiness.models.requests.BuildingCUpdateRq;
import com.haui.realestatebusiness.models.requests.DeleteRq;
import org.springframework.http.ResponseEntity;

public interface IBuildingCategoryService {
    ResponseEntity<SystemResponse<Object>> getBuildingCategoryByStatus(String status);
    ResponseEntity<SystemResponse<Object>> addOne(BuildingCInsertRq buildingCInsertRq);

    ResponseEntity<SystemResponse<Object>> updateOne(BuildingCUpdateRq buildingCUpdateRq);
    ResponseEntity<SystemResponse<Object>> delOne(DeleteRq deleteRq);
}
