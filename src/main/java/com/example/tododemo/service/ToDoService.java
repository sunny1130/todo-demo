package com.example.tododemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tododemo.model.entity.ToDo;
import com.example.tododemo.repo.ToDoRepository;

@Service
public class ToDoService {

	@Autowired private ToDoRepository toDoRepository;
	
	//private static int todosCount = 0;
	//private static List<ToDo> todos = new ArrayList<ToDo>();
	//static {
	//	todos.add(new ToDo(++todosCount,"user1","Learn AWS", LocalDate.now().plusDays(10),false));
	//	todos.add(new ToDo(++todosCount,"user1","Learn Spring", LocalDate.now().plusDays(10),false));
	//	todos.add(new ToDo(++todosCount,"user1","Learn SpringBoot", LocalDate.now().plusDays(10),false));
	//	todos.add(new ToDo(++todosCount,"user1","Learn Ansible", LocalDate.now().plusDays(10),false));
	//	todos.add(new ToDo(++todosCount,"user1","Learn DevOps", LocalDate.now().plusDays(10),false));
	//	todos.add(new ToDo(++todosCount,"user1","Learn Jenkins", LocalDate.now().plusDays(10),false));
	//	todos.add(new ToDo(++todosCount,"sunmeet","Learn Git Action", LocalDate.now().plusDays(10),false));
	//}
	public List<ToDo> findByuser(String u){
		//Predicate<? super ToDo> predicate = todo -> todo.getUsername().equalsIgnoreCase(u);
		//return todos.stream().filter(predicate).toList();
		return toDoRepository.findByUsername(u);
	}
	
	public void addToDO(ToDo todovar) {
		
		//todos.add(new ToDo( ++todosCount, u, d, td, b));
		toDoRepository.save(todovar);
	}
	
	public void deleteToDObyID(int id) {
		//Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		//todos.removeIf(predicate);
		toDoRepository.deleteById(id);
		
	}

	public ToDo findByID(int id) {
		//Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		//return todos.stream().filter(predicate).findFirst().get();
		return toDoRepository.findById(id).get();
	}

	public void updateToDO(ToDo todo) {
		//deleteToDObyID(todo.getId());
		//todos.add(todo);
		toDoRepository.save(todo);
		
	}
}
