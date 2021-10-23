package example.boot.dev.shop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  // Entidad
@Table	// Tabla
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public String name;
	private String surname;
	private int age;
	private String email;
	private String adress;
	private String password;
	
	
	// Constroctors
	
	public User() {
		
	}
	
	public User(String name, String surname, int age, String email, String adress, String password) {
		super();
		
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.adress = adress;
		this.password = password;
	}
	
	
	
	
	//Getters and Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", email=" + email
				+ ", adress=" + adress + ", password=" + password + "]";
	}
	
	
	
	
	

}
