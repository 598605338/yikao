package com.linjia.web.query;

import com.linjia.base.query.Query;

import java.math.BigDecimal;

public class StudentScoreQuery extends Query{
    private Integer id;
    private Long candidateNum;
    private String candidateName;
    private Integer sex;
    private String collegeName;
    private String specialtyName;
    private BigDecimal score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public Long getCandidateNum() {
        return candidateNum;
    }

    public void setCandidateNum(Long candidateNum) {
        this.candidateNum = candidateNum;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }
}