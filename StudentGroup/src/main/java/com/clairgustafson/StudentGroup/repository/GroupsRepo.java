package com.clairgustafson.StudentGroup.repository;

import org.springframework.data.repository.CrudRepository;

import com.clairgustafson.StudentGroup.entity.Groups;

public interface GroupsRepo extends CrudRepository<Groups, Long> {

}
