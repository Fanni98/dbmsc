package com.concretepage;

import java.util.List;

public class RunMybatis {

	public static void main(String[] args) {
		AnimalDAO animalDAO = new AnimalDAO();
		Animal animal = new Animal();
		
		animal.setId("1uc");
		animal.setName("Baba");
		animal.setAge(7);
		animalDAO.save(animal);
		System.out.println("data saved");
		
		
		animal.setId("11g");
		animal.setName("Cirmi");
		animal.setAge(13);
		animalDAO.update(animal);
		System.out.println("data updated");
		
		animal= animalDAO.getData("14r");
		System.out.println("id:"+animal.getId()+", Name:"+animal.getName()+", Age:"+animal.getAge());
		System.out.println("one row retrieved");
		
		List<Animal> animals= animalDAO.getAllData();
		for (Animal an : animals) {
			System.out.println("id:"+an.getId()+", Name:"+an.getName()+", Age:"+an.getAge());
		}
		
		animalDAO.delete("10f");
		System.out.println("data deleted");
		

	}

}
