package com.java.jialei.Interface;

/**
 * Created by JiaLei on 2016/9/12.
 */
public interface ISubject {
    void Attach(IObserver observer);

    void Dettach(IObserver observer);

    void NotifyObserver();
}
