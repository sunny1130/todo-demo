package com.example.tododemo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.tododemo.model.entity.ToDo;
import com.example.tododemo.repo.ToDoRepository;
import com.example.tododemo.service.ToDoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("user")
public class ToDoController {

	@Autowired private ToDoService toDoService;
	
	
	
	@RequestMapping(path = "/list-todos")
	public String listAllToDosforUser(ModelMap model) {
		
		model.addAttribute("todos",toDoService.findByuser(getLoggedInUsername(model)));
		return "listToDos";
	}

	
	
	@RequestMapping(path = "/add-todo", method=RequestMethod.GET)
	public String addToDosforUser(ModelMap model) {
		ToDo todo = new ToDo(0,getLoggedInUsername(model),"",LocalDate.now(),false);
		model.put("todovar", todo);
		return "addToDos";
	}
	
	@RequestMapping(path = "/add-todo", method=RequestMethod.POST)
	public String addToDostolistToDos(ModelMap model,@Valid @ModelAttribute("todovar") ToDo todovar, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addToDos";
		}
		todovar.setUsername(getLoggedInUsername(model));
		toDoService.addToDO(todovar);
		return "redirect:list-todos";
	}
	
	@RequestMapping(path = "/delete-todo", method=RequestMethod.GET)
	public String removeToDosfromlistToDos(ModelMap model, @RequestParam int id) {
		toDoService.deleteToDObyID(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(path = "/update-todo", method=RequestMethod.GET)
	public String showupdateToDos(ModelMap model, @RequestParam int id) {
		model.addAttribute("todovar",toDoService.findByID(id));
		return "addToDos";
	}
	
	@RequestMapping(path = "/update-todo", method=RequestMethod.POST)
	public String updateToDosfromlistToDos(ModelMap model,@Valid @ModelAttribute("todovar") ToDo todovar, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addToDos";
		}
		
		todovar.setUsername(getLoggedInUsername(model));
		toDoService.updateToDO(todovar);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
