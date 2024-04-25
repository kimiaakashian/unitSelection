package org.example.base.service;


import lombok.RequiredArgsConstructor;
import org.example.base.entity.BaseEntity;
import org.example.base.repository.BaseRepository;
import org.example.exception.NotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

@RequiredArgsConstructor
public class BaseServiceImpl<T extends BaseEntity<ID>,
        ID extends Serializable,
        R extends BaseRepository<T, ID>>
        implements BaseService<T, ID>{

    protected final R repository;
    protected  final SessionFactory sessionFactory;


    @Override
    public T saveOrUpdate(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            T t = repository.saveOrUpdate(entity);
            transaction.commit();
            return t;
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public T findById(ID id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            T foundEntity = repository.findById(id).get();
            session.getTransaction().commit();
            return foundEntity;
        } catch (Exception e) {
            throw new NotFoundException(String.format("entity with %s not found", id));
        }}
        @Override
        public void delete(T t) {
            Transaction transaction = null;
            try (Session session = sessionFactory.getCurrentSession()) {
                transaction = session.beginTransaction();
                repository.delete(t);
                transaction.commit();
            } catch (Exception e) {
                assert transaction != null;
                transaction.rollback();
            }

}}
