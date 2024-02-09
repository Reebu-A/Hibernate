package Named;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="namedquery")
@NamedQueries(
		{
			@NamedQuery(
					name = "findName", 
					query = "from NamedQuery1 nq where nq.name = :name"
					)
			
			
		})
public class NamedQuery1
{
@Id
	private int id;
	private String name;
	private int age;
	private String phn;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhn() {
		return phn;
	}
	public void setPhn(String phn) {
		this.phn = phn;
	}
	public NamedQuery1(int id, String name, int age, String phn) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phn = phn;
	}
	public NamedQuery1() {
		
	}
	@Override
	public String toString() {
		return "NamedQuery1 [id=" + id + ", name=" + name + ", age=" + age + ", phn=" + phn + "]";
	}
	
}
