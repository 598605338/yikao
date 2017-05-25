package com.linjia.web.model;

import java.math.BigDecimal;

public class StudentScore {
    private Integer id;
    private Long candidateNum;
    private String candidateName;
    private Integer sex;
    private String collegeName;
    private String specialtyName;
    private BigDecimal score;

    /**
     * 名次
     */
    private Integer rank;

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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}