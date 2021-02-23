package com.concretepage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class AnimalDAO {
	public void save(Animal animal) {
		SqlSession session = AnimalUtil.getSqlSessionFactory().openSession();
		session.insert("com.concretepage.AnimalMapper.insertAnimal", animal);
		session.commit();
		session.close();
	}

	public void update(Animal animal) {
		SqlSession session = AnimalUtil.getSqlSessionFactory().openSession();
		session.update("com.concretepage.AnimalMapper.updateAnimal", animal);
		session.commit();
		session.close();
	}

	public void updateF(Animal animal) {
		SqlSession session = AnimalUtil.getSqlSessionFactory().openSession();
		session.update("com.concretepage.AnimalMapper.updateAnimalF", animal);
		session.commit();
		session.close();
	}

	public void delete(String id) {
		SqlSession session = AnimalUtil.getSqlSessionFactory().openSession();
		session.delete("com.concretepage.AnimalMapper.deleteAnimal", id);
		session.commit();
		session.close();
	}

	public Animal getData(String id) {
		SqlSession session = AnimalUtil.getSqlSessionFactory().openSession();
		Animal animal = session.selectOne("com.concretepage.AnimalMapper.selectAnimal", id);
		session.close();
		return animal;
	}

	public List<Animal> getAllData() {
		SqlSession session = AnimalUtil.getSqlSessionFactory().openSession();
		List<Animal> animals = session.selectList("com.concretepage.AnimalMapper.findAllAnimals");
		session.close();
		return animals;
	}

}
