package Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
	static SessionFactory factory=null;
	public static SessionFactory getFactory(){
		try{
			if(factory==null){
				factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			}
		}
		catch(Exception e){
			System.out.println("Test:"+e);
			e.printStackTrace();
        }
		return factory;
    }
}
