package com.owner.owner.service;

import com.owner.owner.entity.Owner;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerService {


    Owner getOwnerById(Long id);


     List<Owner> getAllOwner();
}
