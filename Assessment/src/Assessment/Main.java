package Assessment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
	
	public static Customer createCustomer(String str) throws ParseException
	{
		String str1[]=str.split(",");
		Customer e=new Customer();
		Address a=new Address();
		e.setCusid(Integer.parseInt(str1[0]));
		e.setCusname(str1[1]);
		e.setEmail(str1[2]);
		e.setMobile(str1[3]);
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		e.setDob(dateformat.parse(str1[4]));
		a.setCity(str1[5]);
		a.setState(str1[6]);
		a.setCountry(str1[7]);
		e.setAddress(a);
		return e;
	}
	
	public static List<Customer> getallCustomers() throws ParseException, IOException
	{
		List<Customer> l=new ArrayList<Customer>();
		 FileReader fr=new FileReader("E:\\customer.txt");
			BufferedReader br=new BufferedReader(fr);
			String str=br.readLine();
		
			while(str!=null)
			{
		        Customer customer=	createCustomer(str);
		        l.add(customer);
		        str=br.readLine();
		
		}

		return l;
		
	}
	
	 public static  void displayCustomers() throws ParseException, Exception  
	 {
	
		 List<Customer> list = getallCustomers();
			/*
			 * if(sortkey.equalsIgnoreCase("id")) { //Collections.sort(list) ;
			 * Collections.sort(list); }else
			 */ 
			/*
			 * if(sortkey.equalsIgnoreCase("name")) { Comparator<Customer>
			 * cusComparator=(e1,e2)->{ return e1.getCusname().compareTo(e2.getCusname());
			 * }; Collections.sort(list,cusComparator); } else {
			 * 
			 * }
			 */
		for(Customer c: list)
		{
			System.out.println(c);
		}   

	 }
	 
	 public static int calculateage(Date dob)
	 {
		 int age=2020-(dob.getYear()+1900);
		 return age;
	 }
	 public static void displaybyAge(int age) throws ParseException, IOException
	 {
		 List<Customer> list=getallCustomers();
		 List<Customer> l1=new ArrayList();
		 
		 for(Customer c:list)
		 {
		      int age1=calculateage(c.getDob());
		      if(age1<age)
		      {
		    	  l1.add(c);
		      }
	     }
		 for(Customer c1:l1)
		 {
			 System.out.println(c1);
		 }
		 
		 
	 }
	 public static void displaybyCity(String s) throws ParseException, IOException
	 {
		 List<Customer> list=getallCustomers();
			/*
			 * Comparator<Customer> comparator=(c1,c2)->{ return
			 * c1.getAddress().getCity().compareTo(c2.getAddress().getCity()) ; };
			 * Collections.sort(list,comparator);
			 */
		 for(Customer cus:list)
		 {
			 if(cus.getAddress().getCity().equalsIgnoreCase(s))
			 {
				 System.out.println(cus);
			 }
		 }
	 }

	public static void main(String[] args) throws ParseException, Exception {
		
		
		Scanner sc=new Scanner(System.in);
		while(true)
		{
		   System.out.println("select \n 1.Display All Customers \n 2. Display by Age \n 3. Display by City \n 4.Transfer \n 5.Replace \n 6.exit");
		   int option =sc.nextInt();
		   if(option ==1)
			{
			//System.out.println("enter sortkey");
			//String s=sc.next();
			displayCustomers();
			}
		   if(option ==2)
			{
				System.out.println("enter age");
				int age=Integer.parseInt(sc.next());
				displaybyAge(age);
			}
		   if(option==3)
		   {
			   
		       System.out.println("enter city"); 
		       String s2=sc.next();
		       displaybyCity(s2);
				 	
		   }
		   if(option ==4)
			{
				
			   System.out.println("Enter old and new cities");
	            String oldcity=sc.next();
	            String newcity=sc.next();
	            List<Customer> list=getallCustomers();
	            int i=0;
	            for(Customer c:list) {
	                Address a1=c.getAddress();
	                if(a1.getCity().equalsIgnoreCase(oldcity)) {
	                    a1.setCity(newcity);
	                    list.get(i).setAddress(a1);
	                }
	                i++;
	            }
	            
	            for(Customer c1:list)
	            {
	                System.out.println(c1);
	            }
	            break;   
			}
		   if(option==5) {
			   
			   System.out.println("Enter id");
	            int id=Integer.parseInt(sc.next());
	            List<Customer> list1=getallCustomers();
	            
	            int index=0;
	            Customer cus=new Customer();
	            cus.setCusid(51);
	            cus.setCusname("bhavya");
	            // [10,20,30,10,20]
	            Iterator<Customer> l1=list1.iterator();
	            while(l1.hasNext()) {
	                if(l1.next().getCusid()==id) {
	                    list1.set(index, cus);
	                    //list1.get(index).setEmail("email");
	                    }
	                    index++;
	                }
	                
	            
	            /*for(Customer c1:list1) {
	                if(c1.getId()==id) {
	                list1.set(index, cus);
	                }
	                index++;
	            }*/
	            
	            for(Customer cus1:list1) {
	                System.out.println(cus1);
	            }
	            break;

		   }
		   if(option ==6)
			{
			   System.out.println("close");
				System.exit(0);
				
			}
		}
		
		
	}

}
