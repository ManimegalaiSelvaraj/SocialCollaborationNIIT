package com.facechat.facechatbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JobDetail")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
 int jobId;
String jobprofile;
public int getJobId() {
	return jobId;
}
public void setJobId(int jobId) {
	this.jobId = jobId;
}
public String getJobprofile() {
	return jobprofile;
}
public void setJobprofile(String jobprofile) {
	this.jobprofile = jobprofile;
}
public String getJobdate() {
	return jobdate;
}
public void setJobdate(String jobdate) {
	this.jobdate = jobdate;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getPostdate() {
	return postdate;
}
public void setPostdate(Date postdate) {
	this.postdate = postdate;
}
String jobdate;
String qualification;
String status;
Date postdate;
/*
* getter setter method
*/

}