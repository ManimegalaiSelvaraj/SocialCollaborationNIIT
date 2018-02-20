package com.facechat.facechatbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facechat.facechatbackend.model.Blog;
import com.facechat.facechatbackend.model.Job;

@Repository("jobDAO")
@Transactional    //all methods are run under transaction
public class JobDAOImpl implements JobDAO{

@Autowired
private SessionFactory sessionFactory;

public JobDAOImpl(SessionFactory sessionFactory2) {
	this.sessionFactory=sessionFactory;
}

@Transactional
public boolean addJob(Job job) {
	try {
		sessionFactory.getCurrentSession().save(job);
		return true;
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
}

@Transactional
public boolean updateJob(Job job) {
	try{
		sessionFactory.getCurrentSession().saveOrUpdate(job);
		return true;
		}
		catch(Exception e)
		{
		e.printStackTrace();
		return false;
		}
}
@Transactional
public boolean deleteJob(Job job) {
	try
	{
		sessionFactory.getCurrentSession().delete(job);
		return true;
		
	}
	catch( Exception e)
	{
		System.out.println("Exception occured"+e);
		return false;
	}
}


@Transactional
public Job getJob(int jobId) {
	Session session=sessionFactory.openSession();
    Job job=session.get(Job.class,jobId);
    session.close();
    
		return job;

}

public List<Job> getAllJob() {
	Session session = sessionFactory.openSession();
	List<Job> jobList=(List<Job>)session.createQuery("from Job").list();
	session.close();
	return jobList;
}


}
