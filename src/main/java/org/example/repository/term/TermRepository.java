package org.example.repository.term;

import org.example.base.repository.BaseRepository;
import org.example.model.Lesson;
import org.example.model.Term;

public interface TermRepository extends BaseRepository<Term, Long> {
    Term findActiveTerm();
}
