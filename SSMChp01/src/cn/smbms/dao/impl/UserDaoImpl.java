package cn.smbms.dao.impl;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.smbms.dao.UserDao;
import cn.smbms.entity.User;
import cn.smbms.utils.MybatisUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public int getUserCount() {
		int rel=-1;
		SqlSession session=null;		
		String resouceFile="mybatis-config.xml";		
		try {
			//1.读取核心配置文件
		    InputStream is=Resources.getResourceAsStream(resouceFile);
			//2.创建工厂类
		    SqlSessionFactory sessionFac=new SqlSessionFactoryBuilder()
		                                     .build(is);
			//3.打开一个会话
		    session=sessionFac.openSession();
			//4.调用方法
		    //session使用方法一：直接运行sql语句，该方式容易出错
		    //rel= session.selectOne("org.mybatis.userMapper.getUserCount");
		   //session使用方法二：基于接口
		    //  mapper 命名空间接口的全名称
		    //  mapper 操作语句的id必须是接口中的方法名		    
		    rel= session.getMapper(UserDao.class).getUserCount();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			//5.关闭会话
			session.close();//关闭会话
		}		
		return rel;
	}

	@Override
	public List<User> getAllUser() {
		SqlSession session=null;
		List<User> userList=null;
		try {
			session=MybatisUtil.createSession();		
			userList=session.getMapper(UserDao.class).getAllUser();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		finally{			
			session.close();
		}
		
		return userList;
	}

}
