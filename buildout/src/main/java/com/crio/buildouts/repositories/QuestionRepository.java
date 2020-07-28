package com.crio.buildouts.repositories;

import com.crio.buildouts.models.QuestionEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<QuestionEntity, String> {
  List<QuestionEntity> findByModuleId(String moduleId);

}
