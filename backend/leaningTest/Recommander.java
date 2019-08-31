package com.owen.www.data;

import java.util.ArrayList;
import java.util.Collections;
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
		}else if(this.count < o.getCount()){
			return -1;
		}
		return 0;
	}
	

	@Override
	public String toString() {
		return "Recommander [count=" + count + ", id=" + id + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		List<Recommander> list = new ArrayList<>();
		
		Recommander r1 = new Recommander();
		r1.setName("aa");
		r1.setCount(5);
		
		Recommander r2 = new Recommander();
		r2.setName("aa");
		r2.setCount(2);
		
		Recommander r3 = new Recommander();
		r2.setName("aa");
		r2.setCount(4);
		
		list.add(r1);
		list.add(r2);
		list.add(r3);
		Collections.sort(list);
		
		System.out.println(list.toString());
		
	}
}
