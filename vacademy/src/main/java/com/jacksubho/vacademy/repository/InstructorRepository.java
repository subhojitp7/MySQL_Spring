package com.jacksubho.vacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacksubho.vacademy.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

	Instructor findByEmail(String email);

}
