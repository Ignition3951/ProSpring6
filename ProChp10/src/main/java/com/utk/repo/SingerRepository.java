package com.utk.repo;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.utk.entity.Singer;

public interface SingerRepository extends CrudRepository<Singer, Long> {

	Stream<Singer> findByFistName(String firstName);

	Stream<Singer> findByFistNameAndLastName(String firstName, String lastName);

	Optional<Singer> findById(Long id);

	@Modifying(clearAutomatically = true)
	@Query("update Singer s set s.fistName = :firstName where s.id = :id")
	int setFirstNameFor(@Param("firstName") String fistName, @Param("id") Long id);
}
