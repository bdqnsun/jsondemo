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
			//1.��ȡ���������ļ�
		    InputStream is=Resources.getResourceAsStream(resouceFile);
			//2.����������
		    SqlSessionFactory sessionFac=new SqlSessionFactoryBuilder()
		                                     .build(is);
			//3.��һ���Ự
		    session=sessionFac.openSession();
			//4.���÷���
		    //sessionʹ�÷���һ��ֱ������sql��䣬�÷�ʽ���׳���
		    //rel= session.selectOne("org.mybatis.userMapper.getUserCount");
		   //sessionʹ�÷����������ڽӿ�
		    //  mapper �����ռ�ӿڵ�ȫ����
		    //  mapper ��������id�����ǽӿ��еķ�����		    
		    rel= session.getMapper(UserDao.class).getUserCount();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			//5.�رջỰ
			session.close();//�رջỰ
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
