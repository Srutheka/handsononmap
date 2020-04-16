package Assess;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapCollection {
	
	public static void main(String[] args)
	{
		Employee e1=new Employee(1,"anni",23000.00,"aa@gmail.com");
		Employee e2=new Employee(1,"maya",23000.00,"bb@gmail.com");
		Employee e3=new Employee(1,"deric",23000.00,"cc@gmail.com");
		Employee e4=new Employee(1,"bevda",23000.00,"dd@gmail.com");
		Employee e5=new Employee(1,"gayathri",23000.00,"ee@gmail.com");
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Date d1= new Date(11-03-2020);
        Date d= new Date(12-04-2020);
        Project p1=new Project(101,"develop",d1,d);
        Project p2=new Project(201,"support",d1,d);
        Project p3=new Project(301,"test",d1,d);
        Project p4=new Project(401,"finance",d1,d);
        Project p5=new Project(501,"manager",d1,d);
        Project p6=new Project(601,"hr",d1,d);
        Project p7=new Project(701,"asstmanager",d1,d);
        Project p8=new Project(801,"executor",d1,d);
        Project p9=new Project(901,"develop",d1,d);
        Project p10=new Project(102,"support",d1,d);
        
					
		
		
		Map<Project,Employee> map =new HashMap<Project,Employee>();
		map.put(p1, e3);
		map.put(p2,e1);
		map.put(p3,e4);
		map.put(p4,e5);
		map.put(p5,e2);
		map.put(p6,e1);
		map.put(p7,e2);
		map.put(p8,e3);
		map.put(p9,e4);
		map.put(p10,e5);
		displayByProjectID(map);
		displayByProjectDomain(map);
		
	}
	
	public static void displayByProjectID(Map<Project,Employee> map)
	{
		TreeMap<Project,Employee> map1=new TreeMap<Project,Employee>(map);
		map1.entrySet().stream().forEach(t->System.out.println(t));
		System.out.println("by id");
		
	}

	public static void displayByProjectDomain(Map<Project, Employee> map) {
		
		Comparator<Project> projectcomp=new Comparator<Project>() {

			@Override
			public int compare(Project o1, Project o2) {
				
				return o1.getDomain().compareTo(o2.getDomain());
			}
			
		};
		map.entrySet().stream().sorted(Map.Entry.comparingByKey(projectcomp)).forEach(t->System.out.println(t));
	}
}
