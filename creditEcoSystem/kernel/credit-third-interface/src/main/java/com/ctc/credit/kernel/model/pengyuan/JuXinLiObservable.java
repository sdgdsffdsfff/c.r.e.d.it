package com.ctc.credit.kernel.model.pengyuan;

import java.util.Observable;

/**
 * 被观察者
 * 
 * @author adrian
 *
 */
public class JuXinLiObservable extends Observable {

	private boolean flag1;

	private boolean flag2;

	private String value;

	public boolean isTrue() {
		return flag1 && flag2;
	}

	public void flag1(String v) {
		value = v;
		flag1 = true;
		setChanged();
		notifyObservers();
	}

	public void flag2(String v) {
		value = v;
		flag2 = true;
		setChanged();
		notifyObservers();
	}

	public String getValue() {
		return value;
	}

}
