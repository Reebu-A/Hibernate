package hiber;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbn_studenthibernat")

public class Stu 
{
	@Id
	private int id;
	private String branch;
	private String Name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Stu(int id, String branch, String name) {
		super();
		this.id = id;
		this.branch = branch;
		Name = name;
	}
	public Stu() {
		
	}
	
}
