package com.maven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory sf=cfg.buildSessionFactory();
    	student st1=new student();
    	st1.setId(105);
    	st1.setName("Nicky");
    	st1.setCity("stm");
    	Certificate certificate=new Certificate();
    	certificate.setCourse("Android");
    	certificate.setDuration("2 month");
    	st1.setCerti(certificate);
    	
    	student st2=new student();
    	st2.setId(108);
    	st2.setName("vicky");
    	st2.setCity("patna");
    	Certificate certificate2=new Certificate();
    	certificate2.setCourse("Hibernate");
    	certificate2.setDuration("1.5 month");
    	st1.setCerti(certificate2);
    	Session session=sf.openSession();
    	Transaction tc=session.beginTransaction();
    	session.save(st1);
    	session.save(st2);
    	tc.commit();
    	session.clear();
    	sf.close();
    }
}
