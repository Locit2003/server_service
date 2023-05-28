package webapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import webapi.entities.Country;
import webapi.hibernate.util.HibernateUtil;

public class CountryDAOImpl implements CountryDAO {
	
	@Override
	public List<Country> getList() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from Country").list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}
}
