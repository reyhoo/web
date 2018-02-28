package yaolei.pojo;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {

	
	private static SqlSessionFactory sSqlSessionFactory;
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sSqlSessionFactory == null){
			synchronized (SqlSessionFactoryUtil.class) {
				if(sSqlSessionFactory == null){
					String resource = "/mybatis-config.xml";
					InputStream in = null;
					try {
						in = SqlSessionFactoryUtil.class.getResourceAsStream(resource);
						sSqlSessionFactory = new SqlSessionFactoryBuilder().build(new InputStreamReader(in, "utf-8"));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return sSqlSessionFactory;
	}
	public static void main(String[] args) {
		System.out.println(getSqlSessionFactory());
		System.out.println(getSqlSessionFactory());
		System.out.println(getSqlSessionFactory());
	}
}
