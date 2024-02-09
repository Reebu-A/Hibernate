package Named;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class NamedMain 
{
	public static void main(String[] args) 
	{
		NamedQuery1 nq=new NamedQuery1();
		Scanner sc=new Scanner(System.in);
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("Named/hibernate.cfg.xml").build();
		Metadata md=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory ssf=md.getSessionFactoryBuilder().build();
		Session s=ssf.openSession();
		Transaction t=s.beginTransaction();
		
		
		nq.setId(4);
		nq.setName("reebu");
		nq.setAge(24);
		nq.setPhn("5488996");
		int i= (int) s.save(nq);
		t.commit();
		if(i!=0)
		{
			System.out.println("---Values entered successfully and ID is: "+i+" ---");
		}
		
	     
		 TypedQuery query = s.getNamedQuery("findName");    
         query.setParameter("name","reebu");   
                 
         List<NamedQuery1> named=query.getResultList();   
         
 Iterator<NamedQuery1> itr=named.iterator();    
  while(itr.hasNext()){    
 NamedQuery1 e=itr.next();    
 System.out.println(e);    
  }
  
  s.close();
  ssf.close();
	}
	
	
	

}
