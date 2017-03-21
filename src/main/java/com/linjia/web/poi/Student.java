package com.linjia.web.poi;

import java.util.Date;

/**
 * Student
 * @author xiangsy
 * @created 2016-09-28
 */
public class Student {

    /**
     * 学号
     */
    private String no;
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 学院
     */
    private Integer age;
    
    private Integer sex;
    
    /**
     * 成绩
     */
    private float score;
    
    //
    private boolean ifExit;

    private Date birthday;
    
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	

	public boolean getIfExit() {
		return ifExit;
	}

	public void setIfExit(boolean ifExit) {
		this.ifExit = ifExit;
	}

	public Student(){
		
	}
	
	/**
	 * @param no
	 * @param name
	 * @param age
	 * @param score
	 */
	public Student(String no, String name, Integer age,int sex, float score,boolean ifExit,Date birthday) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.score = score;
		this.birthday=birthday;
		this.sex=sex;
		this.ifExit=ifExit;
	}

    
}
