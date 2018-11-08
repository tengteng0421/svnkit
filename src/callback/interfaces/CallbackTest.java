package callback.interfaces;

import callback.interfaces.CallbackTest.CallInter;

public class CallbackTest {

	public static interface CallInter {
		void fun1(int i, int j);
	}

	public void run(CallInter ci) {
	}
}

class Test {

	public void test(CallInter ci) {
		CallbackTest ct = new CallbackTest();
		ct.run(ci);
	}

	public static void main(String[] args) {
		Test t = new Test();
		// t.test((e) -> {

		// });
	}
}
