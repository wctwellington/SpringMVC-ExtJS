package br.com.projeto.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projeto.util.HibernateUtil;

@SuppressWarnings("hiding")
public class GenericDAO<Entity, PK> implements IGenericDAO<Entity, PK> {
	
	private Class<Entity> classe;
	private Session session;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void create(Entity entity) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.merge(entity);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
	}

	@Override
	public Entity read(PK pk) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			CriteriaQuery<Entity> query = session.getCriteriaBuilder().createQuery(classe);
			Root<Entity> root = query.from(classe);
			query.select(root);
			query.where(session.getCriteriaBuilder().equal(root.get("id"), pk));
			return session.createQuery(query).getSingleResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(Entity entity) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Entity> readAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			CriteriaQuery<Entity> query = session.getCriteriaBuilder().createQuery(classe);
			@SuppressWarnings("unused")
			Root<Entity> root = query.from(classe);
			return session.createQuery(query).getResultList();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

	}	
}
