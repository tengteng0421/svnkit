package print;

public class EnumTe {

	private EnumTest2 e;

	public EnumTe(EnumTest2 e) {
		this.e = e;
	}

	public EnumTest2 getEnum() {
		return e;
	}

	public static void main(String[] args) {
		EnumTe e1 = new EnumTe(EnumTest2.LOW);
		EnumTe e2 = new EnumTe(EnumTest2.HIGH);
		System.out.println(e1.getEnum().getValue() == e2.getEnum().getValue());
		System.out.println(e1.getEnum().getValue().equals(e2.getEnum().getValue()));
		System.out.println(e1.getEnum().getValue());
		System.out.println(e2.getEnum().getValue());
		System.out.println(e1.getEnum().getValue().getClass().getName());
		System.out.println(e2.getEnum().getValue().getClass().getName());
	}

}
