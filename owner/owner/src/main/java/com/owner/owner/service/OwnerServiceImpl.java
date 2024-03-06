package com.owner.owner.service;

import com.owner.owner.entity.Owner;
import com.owner.owner.repository.OwnerRepo;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerRepo ownerRepo;



    @Override
    public Owner getOwnerById(Long id) {
        return null;
    }





    @Override
    public List<Owner> getAllOwner() {

        return null;
    }


}
