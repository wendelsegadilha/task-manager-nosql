package br.com.wendelsegadilha.taskmanager.repository;

import br.com.wendelsegadilha.taskmanager.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}
