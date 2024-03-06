package com.owner.owner.repository;

import com.owner.owner.entity.Owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepo extends JpaRepository<Owner,Long> {

}
