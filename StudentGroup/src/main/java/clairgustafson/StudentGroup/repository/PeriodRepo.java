package clairgustafson.StudentGroup.repository;

import org.springframework.data.repository.CrudRepository;

import clairgustafson.StudentGroup.entity.Period;

public interface PeriodRepo extends CrudRepository <Period, Long> {

}
