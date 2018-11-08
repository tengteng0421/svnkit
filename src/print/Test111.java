package print;

public class Test111 {

	protected void printTest111() {
		System.out.println("test 111");
	}

	public static void main(String[] args) {
		// 不能输入空格的正则表达式
		// String regex = "^[^\\s]+$";
		// String str = "1 2";
		// System.out.println(str.matches(regex));

		System.out.println("数字: 2");
		int i = 0;
		System.out.println("初始i值: " + i);
		i++;
		i++;
		System.out.println("计算后" + i);
		// int count = 0;
		// for (int i = 2; i <= 10000; i++) {
		// boolean flag = true;
		// for (int j = 2; j <= i / 2; j++) {
		// if (i % j == 0) {
		// flag = false;
		// break;
		// }
		// }
		// if (flag) {
		// System.out.print(i + "\t");
		// count++;
		// }
		// if (count >= 10) {
		// break;
		// }
		// }
		System.out.println();
		// calcSum(5, 16);
		// calMinute(5, 16);
		cal(14, 4, "q");

	}

	public static void calcSum(int i, int j) {
		System.out.println("计算结果:" + (i + j));
	}

	public static void calMinute(int i, int j) {
		System.out.println("计算减法结果:" + (i - j));
	}

	public static void cal(int i, int j, String str) {
		double result = 0;
		switch (str) {
		case "+":
			result = i + j;
			break;
		case "-":
			result = i - j;
			break;
		case "*":
			result = i * j;
			break;
		case "/":
			if (j == 0) {
				System.out.println("分母不能为0");
				return;
			} else {
				result = i / (double) j;
			}
			break;

		default:
			System.out.println("符号输入不符合规定");
			return;
		// break;
		}
		System.out.println("计算结果: " + i + str + j + "=" + result);
	}

}
