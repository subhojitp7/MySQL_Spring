package com.jacksubho.vacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacksubho.vacademy.entity.Assignments;

public interface AssignmentsRepository extends JpaRepository<Assignments, Long> {
	
	List<Assignments> findAllByInstructorId(long id);

}
