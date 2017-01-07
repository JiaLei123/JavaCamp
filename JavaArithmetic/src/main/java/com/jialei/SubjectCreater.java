package com.java.jialei;

import com.java.jialei.Interface.ISubject;
import com.java.jialei.ObserverModel.SearchSubject;
import com.java.jialei.ObserverModel.SortSubject;

import java.nio.channels.IllegalSelectorException;

/**
 * Created by JiaLei on 2016/9/16.
 */
public enum SubjectCreater {

    Instance;

    public ISubject Create(Operation op) {
        ISubject result = null;
        switch (op){
            case sort:
                result = new SortSubject();
                break;
            case search:
                result = new SearchSubject();
                break;
            default:
                throw new IllegalSelectorException();
        }
        return result;
    }
}
