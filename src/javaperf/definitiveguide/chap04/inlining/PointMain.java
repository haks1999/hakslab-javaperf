package javaperf.definitiveguide.chap04.inlining;

import java.util.ArrayList;
import java.util.Random;

public class PointMain {

	public static void main(String[] args){
		
		PointMain.testInlining(250000);
	}
	
	// 인파이닝만 테스트할것이므로 굳이 보든 마이크로벤치마크의 규칙을 따르지 않는다.
	public static void testInlining(int count){
		long then = System.currentTimeMillis();
		for( int inx = 0 ; inx < count ; inx++ ){
			list.add(createPoint());
		}
		long now = System.currentTimeMillis();
		System.out.println("Elapsed time: " + (now - then) );
	}
	
	static Random rand = new Random();
	static ArrayList<Point> list = new ArrayList<Point>(100);
	public static Point createPoint(){
		Point point = new Point();
		point.setX(rand.nextInt(100));
		point.setY(point.getX() * 2);
		return point;
	}
}
