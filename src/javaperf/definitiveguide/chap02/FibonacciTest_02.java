package javaperf.definitiveguide.chap02;

import java.util.Random;

public class FibonacciTest_02 {
	private int nLoops;
	private int[] input;
	volatile double[] output;
	private volatile double l;

	public static void main(String[] args) {
		// warm up 없이
		// 생성 변수 volatile 로 안 받고 
		FibonacciTest_02 ft = new FibonacciTest_02(100000);
		//ft.doTest(true);
		ft.doTest(false);
	}

	private FibonacciTest_02(int n) {
		nLoops = n;
		input = new int[nLoops];
		output = new double[nLoops];
		Random r = new Random();
		for (int i = 0; i < nLoops; i++) {
			input[i] = r.nextInt(20);
		}
	}

	private void doTest(boolean isWarmup) {
		long then = System.currentTimeMillis();
		for (int i = 0; i < nLoops; i++) {
			output[i] = fibImpl(input[i]);
		}
		if (!isWarmup) {
			long now = System.currentTimeMillis();
			System.out.println("Elapsed time: " + (now - then) );
		}
		for (int i = 0; i < nLoops; i++) {
			if(output[i] > 4000) System.out.print(output[i]);
		}
	}

	private double fibImpl(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Must be > 0");
		if (n == 0)
			return 0d;
		if (n == 1)
			return 1d;
		double d = fibImpl(n - 2) + fibImpl(n - 1);
		if (Double.isInfinite(d))
			throw new ArithmeticException("Overflow");
		return d;
	}
}