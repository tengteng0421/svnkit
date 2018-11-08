import org.junit.Test;

public class ExceptionTest {
	@Test
	public static void test() throws Exception {
		try {
			System.out.println(5);
			throw new Exception();
		} catch (Exception e) {
			System.out.println(10);
			throw new Exception(e);
		} finally {
			System.out.println(15);
		}
	}

	public static void main(String[] args) throws Exception {
		test();
	}
}
