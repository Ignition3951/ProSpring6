package com.utk.repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utk.entity.Singer;

public interface SingerRepo extends JpaRepository<Singer, Long> {

	@Query("select s from Singer s where s.fistName=:fn")
	Iterable<Singer> findByFirstName(@Param("fn") String firstName);

	@Query("select s from Singer s where s.fistName %?1%")
	Iterable<Singer> findByFirstNameLike(String fistName);

	@Query("select s from Singer s where s.lastName=:lastName")
	Iterable<Singer> findByLastName(@Param("lastName") String lastName);

	@Query("select s from Singer s where s.lastName %?1%")
	Iterable<Singer> findByLastNameLike(String lastName);

	@Query("select s from Singer s where s.birthDate=:date")
	Iterable<Singer> findByBirthDate(@Param("date") LocalDate date);
}
