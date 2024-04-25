package org.example.repository.term;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.Lesson;
import org.example.model.Student;
import org.example.model.Term;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class TermRepositoryImpl extends BaseRepositoryImpl<Term, Long> implements TermRepository {
    public TermRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Term> getEntityClass() {
        return Term.class;
    }

    @Override
    public Term findActiveTerm() {

        Term term = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            term = session.createQuery("FROM Term t WHERE t.status = 1", Term.class)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return term;
    }
}
