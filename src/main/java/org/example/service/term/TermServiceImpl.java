package org.example.service.term;

import org.example.base.service.BaseServiceImpl;
import org.example.model.Term;
import org.example.repository.term.TermRepository;
import org.hibernate.SessionFactory;

public class TermServiceImpl extends BaseServiceImpl<Term,Long, TermRepository> implements TermService {
    public TermServiceImpl(TermRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public Term findActiveTerm() {
        return repository.findActiveTerm();
    }
}
