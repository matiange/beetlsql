package com.example.demo.test.entity;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2020-11-29
*/
@Table(name="beetlsql.user")
public class User   {
	
	// alias
		public static final String ALIAS_id = "id";
		public static final String ALIAS_age = "age";
		public static final String ALIAS_name = "name";
		public static final String ALIAS_create_date = "create_date";
		
		private Integer id ;
		private Integer age ;
		private String name ;
		private Date createDate ;
		
	public User() {
	}
	
		public Integer getId(){
		return  id;
	}
		public void setId(Integer id ){
		this.id = id;
	}
	
		public Integer getAge(){
		return  age;
	}
		public void setAge(Integer age ){
		this.age = age;
	}
	
		public String getName(){
		return  name;
	}
		public void setName(String name ){
		this.name = name;
	}
	
		public Date getCreateDate(){
		return  createDate;
	}
		public void setCreateDate(Date createDate ){
		this.createDate = createDate;
	}
	
	
}
