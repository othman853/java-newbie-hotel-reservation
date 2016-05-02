package com.yrachid.reservations.parsing;


import com.yrachid.reservations.data.FileLine;

import java.util.Collection;
import java.util.Map;

public interface PatternParserExecuter<T> {

    void execute(Collection<FileLine> lines);
    Map<FileLine, Exception> getErrors();
    Collection<T> getValidParses();

}
