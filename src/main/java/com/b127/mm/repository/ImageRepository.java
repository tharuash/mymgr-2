package com.b127.mm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b127.mm.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{

}
