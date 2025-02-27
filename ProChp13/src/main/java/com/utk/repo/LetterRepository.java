package com.utk.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.utk.entity.Letter;
import com.utk.util.Category;

@RepositoryRestResource(collectionResourceRel = "mailbox", path = "letters")
public interface LetterRepository extends CrudRepository<Letter, Long> {

	@RestResource(path = "byCategory", rel = "customFindMethod")
	List<Letter> findByCategory(@Param("category") Category category);

	List<Letter> findBySentOn(@Param("date") LocalDate sentOn);

	@RestResource(exported = false)
	void deleteById(Long id);

}
