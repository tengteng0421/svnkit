package test.gof23;

public class InterFaceImpl extends SuperClass implements InterFace1 {

	public static void main(String[] args) {
		InterFaceImpl inter = new InterFaceImpl();
		inter.getStr("12345");
	}

	@Override
	public String getStr(String str) {
		// TODO Auto-generated method stub
		return null;
	}
}
