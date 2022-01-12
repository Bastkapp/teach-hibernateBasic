package ch.bissbert.hibernatebasics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;

public class GenericDao<T> implements Dao<T, Serializable> {
  static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

  private final Class<T> tClass;

  public GenericDao(Class<T> tClass) {
    this.tClass = tClass;
  }

  @Override
  public T get(Serializable serializable) {
    T t = null;
    try (Session session = sessionFactory.openSession()) {
      Transaction transaction = session.beginTransaction();
      t = session.get(tClass, serializable);
      transaction.commit();
    }
    return t;
  }

  @Override
  public List<T> getAll() {
    List<T> tList = null;
    try (Session session = sessionFactory.openSession()) {
      Transaction transaction = session.beginTransaction();
      tList = session.createQuery("from " + tClass.getName(), tClass).list();
      transaction.commit();
    }
    return tList;
  }

  @Override
  public void delete(T t) {
    try (Session session = sessionFactory.openSession()) {
      Transaction transaction = session.beginTransaction();
      session.delete(t);
      transaction.commit();
    }
  }

  @Override
  public void update(T t) {
    try (Session session = sessionFactory.openSession()) {
      Transaction transaction = session.beginTransaction();
      session.update(t);
      transaction.commit();
    }
  }

  @Override
  public void insert(T t) {
    try (Session session = sessionFactory.openSession()) {
      Transaction transaction = session.beginTransaction();
      session.save(t);
      transaction.commit();
    }
  }
}
