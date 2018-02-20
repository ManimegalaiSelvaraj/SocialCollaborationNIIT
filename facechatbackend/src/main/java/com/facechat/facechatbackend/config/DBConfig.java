package com.facechat.facechatbackend.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.facechat.facechatbackend.dao.BlogDAO;
import com.facechat.facechatbackend.dao.BlogDAOImpl;
import com.facechat.facechatbackend.dao.ForumCommentsDAO;
import com.facechat.facechatbackend.dao.ForumCommentsDAOImpl;
import com.facechat.facechatbackend.dao.ForumDAO;
import com.facechat.facechatbackend.dao.ForumDAOImpl;
import com.facechat.facechatbackend.dao.FriendDAO;
import com.facechat.facechatbackend.dao.FriendDAOimpl;
import com.facechat.facechatbackend.dao.JobDAO;
import com.facechat.facechatbackend.dao.JobDAOImpl;
import com.facechat.facechatbackend.dao.ProfilePictureDAO;
import com.facechat.facechatbackend.dao.ProfilePictureDAOimpl;
import com.facechat.facechatbackend.dao.UserDAO;
import com.facechat.facechatbackend.dao.UserDAOImpl;
import com.facechat.facechatbackend.model.Blog;
import com.facechat.facechatbackend.model.Forum;
import com.facechat.facechatbackend.model.ForumComments;
import com.facechat.facechatbackend.model.Friend;
import com.facechat.facechatbackend.model.Job;
import com.facechat.facechatbackend.model.ProfilePicture;
import com.facechat.facechatbackend.model.UserDetail;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.facechat.facechatbackend.*")
public class DBConfig 
{
	   //1.Creating a DataSource 7878Object which is used for LocalSessionFactory
		public DataSource getOracleDataSource()
		{
			DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
			driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			driverManagerDataSource.setUsername("System");
			driverManagerDataSource.setPassword("Mani123#");
			return driverManagerDataSource;
		}
		
		//2.Creating Hibernate Properties which is used by LocalSessionFactory
		public Properties getHibernateProperties()
		{
			Properties properties=new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
			return properties;
		}
		
		@Bean
		public SessionFactory getSessionFactory()
		{
			LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
			localSessionFactoryBuilder.addProperties(getHibernateProperties());
			localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
			localSessionFactoryBuilder.addAnnotatedClass(UserDetail.class);
			localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
			localSessionFactoryBuilder.addAnnotatedClass(Job.class);
			localSessionFactoryBuilder.addAnnotatedClass(ForumComments.class);
			localSessionFactoryBuilder.addAnnotatedClass(Friend.class);
			localSessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);			
			System.out.println("SessionFactory Bean Created");
			return localSessionFactoryBuilder.buildSessionFactory();
		}
		
		@Bean
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
		{
			return new HibernateTransactionManager(sessionFactory);
		} 
		
		@Bean("blogDAO")
		public BlogDAO getBlogDAO(SessionFactory sessionFactory)
		{
			System.out.println("Blog DAO object Created");
			return new BlogDAOImpl(sessionFactory);
		}
		@Bean("userDAO")
		public UserDAO getUserDAO(SessionFactory sessionFactory)
		{
			System.out.println("User DAO object Created");
			return new UserDAOImpl(sessionFactory);
		}
		@Bean("forumDAO")
		public ForumDAO getForumDAO(SessionFactory sessionFactory)
		{
			System.out.println("Forum DAO object Created");
			return new ForumDAOImpl(sessionFactory);
		}
		@Bean("jobDAO")
		public JobDAO getJobDAO(SessionFactory sessionFactory)
		{
			return new JobDAOImpl(sessionFactory);
		}
		@Bean("forumCommentsDAO")
		public ForumCommentsDAO getForumCommentsDAO(SessionFactory sessionFactory)
		{
			System.out.println("ForumComments DAO object Created");
			return new ForumCommentsDAOImpl(sessionFactory);
		}
		

		@Bean("friendDAO")
	   	public FriendDAO getFriendDAO(SessionFactory sessionFactory)
	   	{
	   		System.out.println("Friend DAO object created");
	   		return new FriendDAOimpl(sessionFactory);
	   	}
	    
	    
	    
	    @Bean("profilepictureDAO")
	   	public ProfilePictureDAO getProfilePicture(SessionFactory sessionFactory)
	   	{
	   		System.out.println("ProfilePicture DAO object created");
	   		return new ProfilePictureDAOimpl(sessionFactory);
	   	}
	    	
		}
