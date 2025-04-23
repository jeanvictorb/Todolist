package todolist.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todolist.app.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
