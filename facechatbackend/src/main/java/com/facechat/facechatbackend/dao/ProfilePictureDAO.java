package com.facechat.facechatbackend.dao;

import com.facechat.facechatbackend.model.ProfilePicture;

public interface ProfilePictureDAO
{
public boolean save(ProfilePicture profilepicture);
public ProfilePicture getProfilePicture(String username);
}
