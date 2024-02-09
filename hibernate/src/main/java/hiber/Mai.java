package hiber;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Mai 
{
	public static void main(String[] args)
	{
		StandardServiceRegistry ssr= new StandardServiceRegistryBuilder().configure("hiber/hibernate.cfg.xml").build();
		Metadata md=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf= md.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Stu stu=new Stu();
		stu.setId(6);
		stu.setName("Arun");
		stu.setBranch("CSE");
		s.save(stu);
		t.commit();
		s.close();
		sf.close();
		
		
		
	}

}
