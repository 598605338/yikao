package com.linjia.web.model;

import java.util.Date;

public class Feedback {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feedback.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feedback.comment
     *
     * @mbggenerated
     */
    private String comment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feedback.contact_way
     *
     * @mbggenerated
     */
    private String contactWay;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feedback.contact_way
     *
     * @mbggenerated
     */
    private String userId;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feedback.contact_way
     *
     * @mbggenerated
     */
    private String custname;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feedback.contact_way
     *
     * @mbggenerated
     */
    private Date creDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feedback.id
     *
     * @return the value of feedback.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feedback.id
     *
     * @param id the value for feedback.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feedback.comment
     *
     * @return the value of feedback.comment
     *
     * @mbggenerated
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feedback.comment
     *
     * @param comment the value for feedback.comment
     *
     * @mbggenerated
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feedback.contact_way
     *
     * @return the value of feedback.contact_way
     *
     * @mbggenerated
     */
    public String getContactWay() {
        return contactWay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feedback.contact_way
     *
     * @param contactWay the value for feedback.contact_way
     *
     * @mbggenerated
     */
    public void setContactWay(String contactWay) {
        this.contactWay = contactWay == null ? null : contactWay.trim();
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public Date getCreDate() {
		return creDate;
	}

	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}
    
    
}