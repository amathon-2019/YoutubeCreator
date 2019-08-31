package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Recommander implements Comparable<Recommander>{

	int count;
	String id;
	String name;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Recommander o) {
		if(this.count < o.getCount()) {
			return 1;
		}else if(this.count > o.getCount()){
			return -1;
		}
		return 0;
	}
	

	@Override
	public String toString() {
		return "Recommander [count=" + count + ", id=" + id + ", name=" + name + "]";
	}


	public List<Recommander> compareList(List<Recommander> recommanderList , List<Recommander> subscriberList) {
		
		boolean flag=false;
		Iterator<Recommander> recommanderIterator = recommanderList.iterator();
		
		while(recommanderIterator.hasNext()) {
			
			Recommander recommander = recommanderIterator.next();
			String recommanderId = recommander.getId();

			for(int i=0;i<subscriberList.size();i++) {
				
				String subscriberId = subscriberList.get(i).getId();
				
				if(subscriberId.equals(recommanderId)) {
					flag=true;
					break;
				}	
			}
			
			if(flag==false) {
				recommanderIterator.remove();	
			}else if(flag==true) {
				flag=false;
			}
		}
		return recommanderList;
	}
	
	public void compareListTest() {
		
		Recommander test = new Recommander();
		List<Recommander> recommanderList = new ArrayList<Recommander>();
		List<Recommander> subscribeList = new  ArrayList<Recommander>();
		
		Recommander r1 = new Recommander();
		r1.setId("aa");
		r1.setCount(5);
		Recommander r2 = new Recommander();
		r2.setId("bb");
		r2.setCount(4);
		Recommander r3 = new Recommander();
		r3.setId("cc");
		r3.setCount(3);
		Recommander r4 = new Recommander();
		r4.setId("dd");
		r4.setCount(2);
		Recommander r5 = new Recommander();
		r5.setId("ee");
		r5.setCount(1);
		
		recommanderList.add(r1);
		recommanderList.add(r2);
		recommanderList.add(r3);
		recommanderList.add(r4);
		recommanderList.add(r5);
		
		Recommander s1 = new Recommander();
		s1.setId("aa");
		Recommander s2 = new Recommander();
		s2.setId("bb");
		Recommander s3 = new Recommander();
		s3.setId("cc");
		Recommander s4 = new Recommander();
		s4.setId("dd");
		Recommander s5 = new Recommander();
		s5.setId("ee");
		
//		subscribeList.add(s1);
		subscribeList.add(s2);
		subscribeList.add(s3);
//		subscribeList.add(s4);
		subscribeList.add(s5);
		
		List<Recommander> list=test.compareList(recommanderList, subscribeList);
		System.out.println(list.toString());
	}
	
	public void compareToTest() {
		
		List<Recommander> list = new ArrayList<>();
		
		Recommander r1 = new Recommander();
		r1.setName("aa");
		r1.setCount(5);
		
		Recommander r2 = new Recommander();
		r2.setName("aa");
		r2.setCount(2);
		
		Recommander r3 = new Recommander();
		r3.setName("aa");
		r3.setCount(4);
		
		list.add(r1);
		list.add(r2);
		list.add(r3);
		Collections.sort(list);
		
		System.out.println(list.toString());

	}
	
	public static void main(String[] args) {
		Recommander recommande = new Recommander();
		recommande.compareListTest();
		recommande.compareToTest();		
	}
}
