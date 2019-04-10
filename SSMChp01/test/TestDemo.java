import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import cn.smbms.dao.UserDao;
import cn.smbms.dao.impl.UserDaoImpl;
import cn.smbms.entity.User;


public class TestDemo {
	Logger logger=Logger.getLogger(TestDemo.class);
	UserDao userDao=new UserDaoImpl();
	@Test
	public void testMethod1()
	{
		//UserDao userDao=new UserDaoImpl();
		int count=userDao.getUserCount();
		System.out.println("ÓÃ»§Êý£º"+count);
	}
	@Test
	public void testGetAllUser()
	{
		//UserDao userDao=new UserDaoImpl();
		List<User> userList=userDao.getAllUser();
		for(User user : userList)
		{
			//System.out.println(user.getUserName());
			logger.debug(user.getUserName());
		}
		
	}
	

}
