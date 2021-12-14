package com.juezlti.repository.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.juezlti.repository.models.Usage;
import com.juezlti.repository.models.Test;



public interface UsageRepository extends MongoRepository<Usage, String> {
	
	
	 @Query( value = "{idExercise: {$in : ?0}, user:{userId :{$in : ?1 } } } ")
	  List<Usage> findByIds ( List<String> list,  List<String> list2);
	  
	 List<Usage> findByIdExerciseInAndIdInAndCtId(List<String> idExercises, List<String> id, String ctId);
	 
	 int countByCtId(String ctId);
	
	  List<Usage> findByIdExerciseIgnoreCase(String idExercise); 
	  List<Usage> findByDate(Date date); 
	}
