package com.springboot.my.org.crudapi.dao;

import java.util.List;

import com.springboot.my.org.crudapi.model.Bonus;

public interface BonusDao {
	public boolean addBonus(Bonus bonus);

	public boolean deleteBonusById(int workerRefId);

	public Bonus findBonusById(int workerRefId);

	public List<Bonus> findBonusByDept(String dept);

	public List<Bonus> findAllBonus();

	public boolean replaceBonus(Bonus bonus);
}
