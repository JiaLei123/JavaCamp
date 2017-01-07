package com.java.jialei.ObserverModel;

import com.java.jialei.Interface.IObserver;

/**
 * Created by JiaLei on 2016/9/12.
 */
public class SortSubject extends SubjectBase {
    public SortSubject(){
        this.Attach(new Maopao());
    }
}
