package co.com.mundocostenio.domain;

import java.io.Serializable;
import java.util.List;

public class Tutor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer tutorId;
	private String name;
	private String email;
	private Adress address;
	private List<Course> courses;
	
	public Integer getTutorId() {
		return tutorId;
	}
	public void setTutorId(Integer tutorId) {
		this.tutorId = tutorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Adress getAddress() {
		return address;
	}
	public void setAddress(Adress address) {
		this.address = address;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
