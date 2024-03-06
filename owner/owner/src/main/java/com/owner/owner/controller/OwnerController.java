package com.owner.owner.controller;

import com.owner.owner.entity.Owner;
import com.owner.owner.service.OwnerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    OwnerServiceImpl ownerServiceImpl;


    @GetMapping("/getOwnerById/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable Long ownerId) {
        Owner owner = ownerService.getOwnerById(ownerId);
        if (owner == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(owner);
    }


    @GetMapping("/getAll")
    public ResponseEntity <List<Owner>> getALlOwner() {
        List<Owner> owner = ownerService.getAllOwner();
        return ResponseEntity.ok(owner);
    }

}
