package com.owner.owner.service;

import com.owner.owner.dto.PropertyDto;
import com.owner.owner.entity.Property;
import com.owner.owner.repository.PropertyRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

public class PropertyServiceImpl implements PropertyServce{
    @Autowired
    PropertyRepo propertyRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    StringToObjectConvert stringToObjectConvert;

    @Override
    public PropertyDto addProperty(String property, MultipartFile[] propertyImages) {
        List<PropertyImages> images = addImages(propertyImages);
        Property prop = mapper.map(stringToObjectConvert.convertJsonToObject(property, PropertyDto.class), Property.class);
        prop.setImg(images);
        return mapper.map(propertyRepository.save(prop), PropertyDto.class);
    }

    @Override
    public List<PropertyDto> getAllProperty() {
        return mapper.map(propertyRepository.findAll(), new TypeToken<List<PropertyDto>>() {
        }.getType());
    }


    @Override
    public PropertyDto getPropertyById(Long id) {
        try {
            return mapper.map(propertyRepository.findById(id).orElseThrow(), PropertyDto.class);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Property Not Found " + id);
        }
    }

    @Override
    public String deleteProperty(Long id) {
        propertyRepository.deleteById(id);
        Boolean off = propertyRepository.findById(id).isEmpty();
        if (Boolean.TRUE.equals(off))
            return "Property Deleted Successfully!";
        return "Not Deleted!";
    }

    @Override
    public PropertyDto updateProperty(String property, MultipartFile[] propertyImages) {

        PropertyDto propertyDTO = stringToObjectConvert.convertJsonToObject(property, PropertyDto.class);
        Optional<Property> sale = propertyRepository.findById(propertyDTO.getId());
        List<PropertyImages> img = addImages(propertyImages);

        if(!property.isEmpty()) {
            Property prop = mapper.map(propertyDTO, Property.class);
            prop.setImg(img);
            return mapper.map(propertyRepository.save(prop), PropertyDto.class);
        }
        return mapper.map(sale, PropertyDto.class);
    }
    private List<PropertyImages> addImages(MultipartFile[] files) {

        List<PropertyImagesDto> propertyImagesDtos = new ArrayList<>();
        Arrays.asList(files).stream().forEach(file -> {
            try {
                byte[] img = file.getBytes();
                PropertyImagesDto propertyImagesDto = new PropertyImagesDto();
                propertyImagesDto.setImages(img);
                propertyImagesDtos.add(propertyImagesDto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return mapper.map(propertyImagesDtos, new TypeToken<List<PropertyImages>>() {
        }.getType());
    }
}
