package com.haui.realestatebusiness.services;


import com.haui.realestatebusiness.models.bos.SystemResponse;
import org.springframework.http.ResponseEntity;

public interface ILocationService {
    ResponseEntity<SystemResponse<Object>> getAllProvinces();

    ResponseEntity<SystemResponse<Object>> getDistrictsByProvince(int provinceId);

    ResponseEntity<SystemResponse<Object>> getWardsByDistrict(int districtsId);

    String getLocationByWard(int wardId);
}
