package com.java.jialei.ObserverModel;

/**
 * Created by JiaLei on 2016/9/16.
 */
public class SearchSubject extends SubjectBase{
    public SearchSubject() {
        this.Attach(new ZheBan());
    }
}
