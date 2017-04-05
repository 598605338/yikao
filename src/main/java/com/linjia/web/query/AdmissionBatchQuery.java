package com.linjia.web.query;

import com.linjia.base.query.Query;

public class AdmissionBatchQuery extends Query {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admission_batch.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admission_batch.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admission_batch.id
     *
     * @return the value of t_admission_batch.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admission_batch.id
     *
     * @param id the value for t_admission_batch.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admission_batch.name
     *
     * @return the value of t_admission_batch.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admission_batch.name
     *
     * @param name the value for t_admission_batch.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    private String nameQuery;

    public String getNameQuery() {
        return nameQuery;
    }

    public void setNameQuery(String nameQuery) {
        this.nameQuery = nameQuery;
    }
}