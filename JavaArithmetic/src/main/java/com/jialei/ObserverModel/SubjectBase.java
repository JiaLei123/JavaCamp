package com.java.jialei.ObserverModel;

import com.java.jialei.Interface.IObserver;
import com.java.jialei.Interface.ISubject;
import java.util.*;

/**
 * Created by JiaLei on 2016/9/12.
 */
public abstract class SubjectBase implements ISubject {
    public List<IObserver> ObsereverList = new ArrayList<IObserver>();

    public void Dettach(IObserver observer) {
        int index = this.ObsereverList.indexOf(observer);
        if (index > 1) {
            this.ObsereverList.remove(this.ObsereverList.indexOf(observer));
        }
    }

    public void Attach(IObserver observer) {
        if(!this.ObsereverList.contains(observer)){
            this.ObsereverList.add(observer);
        }
    }

    public void NotifyObserver() {
        if (ObsereverList.size() > 0) {
            for (IObserver observer : ObsereverList) {
                observer.Update();
            }
        }
    }


}
