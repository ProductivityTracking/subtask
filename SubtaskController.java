package com.nkxgen.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.orm.model.SubtaskInput;
import com.nkxgen.spring.orm.service.SubtaskService;
import com.nkxgen.spring.orm.service.TaskService;

@Controller
public class SubtaskController {

	@Autowired
	public SubtaskService subtaskService;
	private TaskService taskService;

	@RequestMapping(value = "/saveSubtask", method = RequestMethod.GET)
	public String saveSubtask(@Validated SubtaskInput subtaskInput, Model model) {
		try {
			subtaskService.setNewSubTask(subtaskInput);
			return "Taskslist";
		} catch (DataIntegrityViolationException ex) {
			// Handle the constraint violation exception
			ex.printStackTrace(); // or log the error
			model.addAttribute("error", "Constraint violation occurred. Please try again.");
			return "Taskslist"; // Show an error page to the user
		}
	}

	@RequestMapping(value = "/createSubtask", method = RequestMethod.GET)
	public String getSubtaskForm(@RequestParam("taskId") int taskId, Model model) {
		SubtaskInput subtaskInput = new SubtaskInput();
		subtaskInput.setTaskId(taskId); // Set the task_id in the SubtaskInput object
		model.addAttribute("subtaskInput", subtaskInput);
		return "createsubtask";
	}

	/*
	 * @RequestMapping(value = "/createSubtask", method = RequestMethod.GET) public String
	 * getSubtaskForm(@RequestParam("task_id") int taskId, Model model) { // Retrieve the existing task from the
	 * database using the task ID Task task = taskService.getTaskById(taskId);
	 * 
	 * // Set the taskId in the Subtask model Task task2 = new Task(); task2.setTaskId(taskId);
	 * 
	 * // Add the task and subtask mo dels to the model for accessing in the view model.addAttribute("task", task);
	 * model.addAttribute("subtask", task2);
	 * 
	 * return "createsubtask"; }
	 */

}
