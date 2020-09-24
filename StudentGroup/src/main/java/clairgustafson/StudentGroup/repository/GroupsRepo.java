package clairgustafson.StudentGroup.repository;

import org.springframework.data.repository.CrudRepository;

import clairgustafson.StudentGroup.entity.Groups;

public interface GroupsRepo extends CrudRepository<Groups, Long> {

}
