package com.example.tododemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tododemo.model.entity.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

	public List<ToDo> findByUsername(String username);
}
