import java.io.Serializable;

@SuppressWarnings("serial")
public class MyTest implements Serializable {
	public Object readResolve() {
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	// public static void main(String[] args) throws CloneNotSupportedException
	// {
	// CloneTest t1 = new CloneTest();
	// t1.num = 3;
	// t1.name = "asd";
	// t1.printInfo("t1: ");
	//
	// CloneTest t2 = t1;
	// CloneTest t3 = (CloneTest) t1.clone();
	// t1.num = 4;
	// t1.name = "qwe";
	// t2.printInfo("t2: ");
	// t3.printInfo("t3: ");
	// }

}

class CloneTest implements Cloneable {

	public int num;
	public String name;

	@Override
	public Object clone() throws CloneNotSupportedException {
		CloneTest ct = (CloneTest) super.clone();
		return ct;
	}

	public void printInfo(String str) {
		System.out.println(str + "num: " + num + " , name: " + name);
	}
}
