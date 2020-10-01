package com.clairgustafson.StudentGroup.repository;

import org.springframework.data.repository.CrudRepository;

import com.clairgustafson.StudentGroup.entity.Period;

public interface PeriodRepo extends CrudRepository <Period, Long> {

}
