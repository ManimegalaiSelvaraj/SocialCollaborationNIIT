package com.facechat.facechatbackend.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facechat.facechatbackend.model.ProfilePicture;


@Repository("profilepictureDAO")
public class ProfilePictureDAOimpl implements ProfilePictureDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public ProfilePictureDAOimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}


	@Transactional
	public boolean save(ProfilePicture profilepicture) {
		try
		{
			sessionFactory.getCurrentSession().save(profilepicture);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}		
	}

	@Transactional
	public ProfilePicture getProfilePicture(String username) {
		Session session=sessionFactory.openSession();
		ProfilePicture profilepicture=(ProfilePicture)session.get(ProfilePicture.class, username);
		session.close();
		return profilepicture;
	}

}
