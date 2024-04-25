package org.example.service.term;

import org.example.base.service.BaseService;
import org.example.model.Term;

public interface TermService extends BaseService<Term,Long> {
    Term findActiveTerm();
}
