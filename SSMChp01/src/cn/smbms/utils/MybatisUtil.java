package cn.smbms.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {	
	private static SqlSessionFactory factory=null;
	static{
		try {
			//1.读取核心配置文件
			  InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
				//2.创建工厂类
			  factory=new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			
			e.printStackTrace();
		}		
	}
	//创建session会话
	public static SqlSession createSession()
	{
		return factory.openSession();		
	}
	public static void closeSession(SqlSession session)
	{
		if(session!=null)
		{
			session.close();
		}
	}	

}
