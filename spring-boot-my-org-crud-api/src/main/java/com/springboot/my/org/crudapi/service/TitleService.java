package com.springboot.my.org.crudapi.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.model.Title;
import com.springboot.my.org.crudapi.repository.TitleRepository;

@Service
public class TitleService {

	@Resource(name = "titleRepo")
	TitleRepository titleRepo;

	public boolean addTitle(Title title) {

		return titleRepo.insertTitle(title);

	}

	public boolean deleteTitleById(int workerRefId) {

		return titleRepo.deleteTitleById(workerRefId);

	}

	public Title findTitleById(int workerRefId) {

		return titleRepo.findTitleById(workerRefId);

	}

	public List<Title> findTitleByDept(String dept) {

		return titleRepo.findTitleByDept(dept);

	}

	public List<Title> findAllTitles() {

		return titleRepo.findAllTitles();

	}

	public boolean createTitle(int id, String title) {

		return titleRepo.createTitleById(id, title);

	}
}
