package hiber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbn_CRED")
public class CRED
{@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public CRED(int id) {
	super();
	this.id = id;
}
	public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
	private int slno;
	private String name;
	private String phn;
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhn() {
		return phn;
	}
	public void setPhn(String phn) {
		this.phn = phn;
	}
	public CRED(int slno, String name, String phn) {
		super();
		this.slno = slno;
		this.name = name;
		this.phn = phn;
	}
	public CRED() {
		
	}
	 

}
