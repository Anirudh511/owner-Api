package com.owner.owner.service;

import com.owner.owner.dto.PropertyDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PropertyServce {

    public PropertyDto addProperty(String property, MultipartFile[] propertyImgs);

    public List<PropertyDto> getAllProperty();

    public PropertyDto getPropertyById(Long id);

    public String deleteProperty(Long id);

    public PropertyDto updateProperty(String property, MultipartFile[] propertyImages);
}
