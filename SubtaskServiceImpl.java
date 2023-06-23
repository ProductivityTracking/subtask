package com.nkxgen.spring.orm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.orm.dao.SubtaskDao;
import com.nkxgen.spring.orm.model.Subtask;
import com.nkxgen.spring.orm.model.SubtaskInput;

@Service
@Transactional
public class SubtaskServiceImpl implements SubtaskService {

	@Autowired
	private SubtaskDao subtaskDao;

	@Override
	@Transactional
	public void saveSubtask(Subtask subtask) {
		subtaskDao.saveSubtask(subtask);
	}

	@Override
	public void setNewSubTask(SubtaskInput subtaskInput) {
		try {
			Subtask subtask = subtaskInput.toEntity();
			subtaskDao.saveSubtask(subtask);
		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();
			// Throw or handle the exception as needed
		}
	}
}
