package javaperf.definitiveguide.chap04.inlining;

import java.util.ArrayList;
import java.util.Random;

public class PointMain {

	public static void main(String[] args){
		
		PointMain.testInlining(250000);
	}
	
	// �����̴׸� �׽�Ʈ�Ұ��̹Ƿ� ���� ���� ����ũ�κ�ġ��ũ�� ��Ģ�� ������ �ʴ´�.
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
