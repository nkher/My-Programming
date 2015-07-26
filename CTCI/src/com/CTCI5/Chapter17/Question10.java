package com.CTCI5.Chapter17;

import java.util.ArrayList;

public class Question10 {
	
	
	public static void encode(Element root, StringBuffer sb) {
		encode(root.getNameCode(), sb);
		for (Attribute a : root.attributes) {
			encode(a, sb);
		}
		encode("0", sb);
		if (root.value != null && root.value != "")
			encode(root.value, sb);
		else {
			for (Element e : root.children) {
				encode(e, sb);
			}
		}
		encode("0", sb);
	}
	
	public static void encode(Attribute attr, StringBuffer sb) {
		encode(attr.getTagCode(), sb);
		encode(attr.value, sb);
	}
	
	public static void encode(String s, StringBuffer sb) {
		sb.append(s);
		sb.append(" ");
	}
	
	public static String encodeToString(Element root) {
		StringBuffer sb = new StringBuffer();
		encode(root, sb);
		return sb.toString();
	}
		
	
	public static void main(String[] args) {
		Element root = new Element("family");
		Attribute a1 = new Attribute("lastname", "McDowell");
		Attribute a2 = new Attribute("state", "CA");
		root.insertA(a1);
		root.insertA(a2);
		
		Element child = new Element("person", "Some Message");
		Attribute a3 = new Attribute("firstName", "Gayle");
		child.insertA(a3);
		
		root.insertE(child);
		
		String s = encodeToString(root);
		System.out.println(s);
	}
}

class Attribute {
	String tag;
	String value;
	
	public Attribute(String t, String v) {
		this.tag = t;
		this.value = v;
	}
	
	public String getTagCode() {
		if (tag == "family")
			return "1";
		else if (tag == "person")
			return "2";
		else if (tag == "firstName")
			return "3";
		else if (tag == "lastname")
			return "4";
		else if (tag == "state")
			return "5";
		else
			return "--";
	}
}

class Element {
	public ArrayList<Attribute> attributes;
	public ArrayList<Element> children;
	String name;
	String value;
	
	public Element(String s) {
		name = s;
		attributes = new ArrayList<Attribute>();
		children = new ArrayList<Element>();
	}
	
	public Element(String n, String v) {
		name = n;
		value = v;
		attributes = new ArrayList<Attribute>();
		children = new ArrayList<Element>();
	}
	
	public String getNameCode() {
		if (name == "family")
			return "1";
		else if (name == "person")
			return "2";
		else if (name == "firstname")
			return "3";
		else if (name == "lastname")
			return "4";
		else if (name == "state")
			return "5";
		else
			return "--";
	}
	
	public void insertA(Attribute attribute) {
		this.attributes.add(attribute);
	}
	
	public void insertE(Element child) {
		this.children.add(child);
	}
}
