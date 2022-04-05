package com.springboot.my.org.crudapi.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.model.Bonus;
import com.springboot.my.org.crudapi.repository.BonusRepository;

@Service
public class BonusService {
	@Resource(name = "bonusRepo")
	BonusRepository bonusRepo;

	public Bonus getBonusById(Integer id) {

		return bonusRepo.findBonusById(id);

	}

	public List<Bonus> getBonusByDept(String dept) {

		return bonusRepo.findBonusByDept(dept);

	}

	public List<Bonus> getAllBonus() {

		return bonusRepo.findAllBonus();

	}

	public boolean createBonus(Bonus bonus) {

		return bonusRepo.addBonus(bonus);

	}

	public boolean deleteBonusById(Integer id) {

		return bonusRepo.deleteBonusById(id);

	}
}
