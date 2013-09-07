/**
 * 
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in,
 * first out" basis.  People must adopt either the "oldest" (based on arrival time) of
 * all animals at the shelter, or they can select whether they would prefer a dog or
 * a cat (and will receive the oldest animal of that type).  They cannot select which
 * specific animal they would like.  Create the data structures to maintain this system
 * and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.
 * You may use the build-in LinkedList data structure.
 *  
 */

import java.util.*;
enum PetType {
	Cat, Dog
}
class Pet {
	public PetType type;
	public int id;
	
	public Pet(int id, PetType t) {
		this.id = id;
		this.type = t;
	}
	
	public String toString() {
		return this.type + "_" + this.id;
	}
}

class Shelter {
	LinkedList<Pet> dogs = new LinkedList<Pet>();
	LinkedList<Pet> cats = new LinkedList<Pet>();
	
	public void enqueue(Pet animal) {
		if(animal.type == PetType.Cat) {
			cats.add(animal);
		} else {
			dogs.add(animal);
		}
	}
	
	public static PetType getRand() {
		return (Math.random() > 0.5) ? PetType.Cat : PetType.Dog;
	}
	
	public Pet dequeueCat() {
		if(cats.isEmpty()) return null;
		return cats.poll();
	}
	
	public Pet dequeueDog() {
		if(dogs.isEmpty()) return null;
		return dogs.poll();
	}
	
	public Pet dequeueAny() {
		PetType t = Shelter.getRand();
		
		if(dogs.isEmpty() && cats.isEmpty()) return null;
		
		if(dogs.isEmpty()) return cats.poll();
		if(cats.isEmpty()) return dogs.poll();
		
		Pet cat = cats.peek();
		Pet dog = dogs.peek();
		
		if(cat.id < dog.id) {
			return cats.poll();
		} else {
			return dogs.poll();
		}
		
	}
	
	public String toString() {
		return "Dogs: " + dogs.toString() + "\nCats: " + cats.toString();
	}
}
public class Solution {
	public static void main(String[] args) {
		int id = 0;
		
		Shelter sltr = new Shelter();
		for(int i = 0; i < 20; i++) {
			PetType t = Shelter.getRand();
			id++;
			Pet a = new Pet(id, t);
			sltr.enqueue(a);
		}
		
		System.out.println(sltr.toString());
		
		for(int i = 0; i < 20; i++) {
			double r = Math.random();
			Pet p = null;
			
			System.out.println(i + ") ");
			if(r < 0.333) {
				p = sltr.dequeueAny();
				System.out.println("DequeueAny: ");
			} else if(r < 0.666) {
				p = sltr.dequeueDog();
				System.out.println("DequeueDog: ");
			} else {
				p = sltr.dequeueCat();
				System.out.println("DequeueCat: ");
			}
			
			if(p != null) {
				System.out.println(p.toString());
			}
			System.out.println(sltr.toString() + "\n");
		}
	}

}
