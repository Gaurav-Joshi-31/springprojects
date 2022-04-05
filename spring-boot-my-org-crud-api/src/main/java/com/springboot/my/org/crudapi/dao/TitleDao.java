package com.springboot.my.org.crudapi.dao;

import java.util.List;

import com.springboot.my.org.crudapi.model.Title;

public interface TitleDao {
	public boolean insertTitle(Title title);

	public boolean deleteTitleById(int workerRefId);

	public Title findTitleById(int workerRefId);

	public List<Title> findTitleByDept(String dept);

	public List<Title> findAllTitles();

	public boolean replaceTitle(Title title);

	public boolean createTitleById(int id, String title);
}
