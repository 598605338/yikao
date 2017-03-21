package com.linjia.web.model;

import java.io.File;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * 用户信息
 * @author lixinling
 * 2016年8月2日 下午3:46:25
 */
public class Member {
	
	/**
     * 头像
     */
	private MultipartFile headPic;

    /**
     * 上传头像图片名称
     */
    private String headPicFileName;
    
    /**
     * 昵称
     */
    private String name;
    
    /**
     * 性别
     * female: 女 ; male: 男; privacy: 保密
     */
    private String sex;
    
    /**
     * 出生日期
     */
    private Date birthDay;
    
    /**
     * 已绑定手机号
     */
    private String bindPhone;
    

	public MultipartFile getHeadPic() {
		return headPic;
	}

	public void setHeadPic(MultipartFile headPic) {
		this.headPic = headPic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getBindPhone() {
		return bindPhone;
	}

	public void setBindPhone(String bindPhone) {
		this.bindPhone = bindPhone;
	}

	public String getHeadPicFileName() {
		return headPicFileName;
	}

	public void setHeadPicFileName(String headPicFileName) {
		this.headPicFileName = headPicFileName;
	}
    

}