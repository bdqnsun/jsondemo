package cn.smbms.dao;

import java.util.List;

import cn.smbms.entity.User;

public interface UserDao {
	int getUserCount();
	List<User> getAllUser();
	

}
