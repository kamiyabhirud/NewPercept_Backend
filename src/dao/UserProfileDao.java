package dao;

import model.UserProfile;

public interface UserProfileDao {

	public UserProfile getuserprofile(String username);
	
	public Boolean updatepreferredcontact(UserProfile userprofile);
}
