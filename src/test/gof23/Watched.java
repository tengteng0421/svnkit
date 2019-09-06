package test.gof23;

import java.util.Observable;
import java.util.Observer;

public class Watched extends Observable {
	@Override
	public synchronized void addObserver(Observer o) {
		System.out.println("add " + o);
		super.addObserver(o);
	}

	@Override
	protected synchronized void setChanged() {
		// TODO Auto-generated method stub
		super.setChanged();
	}

	public void changeData(Object o) {
		setChanged();
		notifyObservers(o);
	}
}
