package test.gof23;

public class WatcherTest {
	public static void main(String[] args) {
		Watched watched = new Watched();
		Watcher w1 = new Watcher();
		watched.addObserver(w1);
		watched.addObserver(new Watcher());
		watched.addObserver(new Watcher());
		watched.addObserver(new Watcher());
		watched.changeData(1);
	}
}
