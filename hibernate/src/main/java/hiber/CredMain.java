package hiber;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class CredMain 
{
	public static void main(String[] args)
	{
		
		CRED obj=new CRED();
		Scanner sc=new Scanner(System.in);
		int d=0;
		do
		{
			StandardServiceRegistry ssr= new StandardServiceRegistryBuilder().configure("hiber/hibernate.cfg1.xml").build();
			Metadata md=new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory sf= md.getSessionFactoryBuilder().build();
			Session s=sf.openSession();
			Transaction t=s.beginTransaction();
			
			System.out.println("Enter your Choice");
			System.out.println("1.Enter values");
			System.out.println("2.Update values");
			System.out.println("3.Get values");
			System.out.println("4.Delete");
			System.out.println("5.Total Count of data's");
			System.out.println("6.Sum od slno");
			System.out.println("7.Min of slno");
			System.out.println("8.Max of slno");
			System.out.println("9.Avg of slno");
			System.out.println("10.Update using HQL");
			System.out.println("11.Exit");
			d=sc.nextInt();
			switch(d)
			{
			case 1:
				System.out.println("Enter the Slno: ");
				int sl=sc.nextInt();
				System.out.println("Enter the Name: ");
				String name=sc.next(); 
				System.out.println("Enter the Phn No: ");
				String phn=sc.next();
				obj.setSlno(sl);
				obj.setName(name);
				obj.setPhn(phn);
				int i= (int) s.save(obj);
				t.commit();
				if(i!=0)
				{
					System.out.println("---Values entered successfully and ID is: "+i+" ---");
				}
				break;
			
			case 2:
				System.out.println("Enter the Id: ");
				int idd=sc.nextInt();
				System.out.println("Enter the Slno: ");
				int usl=sc.nextInt();
				System.out.println("Enter the Name: ");
				String uname=sc.next();
				System.out.println("Enter the Phn No: ");
				String uphn=sc.next();
				obj.setId(idd);
				obj.setSlno(usl);
				obj.setName(uname);
				obj.setPhn(uphn);
//				s.update(obj);
				s.saveOrUpdate(obj);
				t.commit();
				
				break;
			case 3:
				Query q=s.createQuery("from CRED");
				List<CRED> list=q.list();
				for (CRED cred : list) 
				{
					System.out.println(cred.getName()+"----"+cred.getPhn());
				}
				t.commit();
				
				break; 
			case 4:
				System.out.println("Enter the Id: ");
				int id2=sc.nextInt();
				obj.setId(id2);
				s.delete(obj);
//				s.remove(obj);
				t.commit();
				break;
			case 5:
				long tot=(long) s.createQuery("select count(*) from CRED").getSingleResult();
				System.out.println("Total count of data is: "+tot);
				break;
			case 6:
				long sum=(long) s.createQuery("select sum(slno) from CRED").getSingleResult();
				System.out.println("Sum of slno is "+sum);
				break;
			case 7:
				int min=(int) s.createQuery("select min(slno) from CRED").getSingleResult();
				System.out.println("Min of slno is "+min);
				break;
			case 8:
				int max=(int) s.createQuery("select max(slno) from CRED").getSingleResult();
				System.out.println("Max of slno is "+max);
				break;
			case 9:
				double avg= (double) s.createQuery("select avg(slno) from CRED").getSingleResult();
				System.out.println("Avg of slno is "+avg);
				break;
			case 10:
				Query k=s.createQuery("update CRED set name=:n where id=:id1");
				k.setParameter("id1",9);
				k.setParameter("n", "rosh");
//				k.setParameter("p", "23545688");
				
				int l=k.executeUpdate();
				t.commit();
				System.out.println(l); 
				break;
			case 11:
				
				s.close();
				sf.close();
				System.out.println("--------Exit--------");
				break;
			}
			
		}while(d<11);

	}

}
