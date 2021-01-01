import java.util.*;

public class Main {
	static String hello= "dfdf";
	public static void main(String[] args) {
		//static String hello= "dfdf";
		// TODO Auto-generated method stub
		/*
		int[] brr = new int[4];
		brr[0]= 10;
		brr[1]=11;
		brr[2]=12;
		brr[3]=13;
		swap(brr,1,2);
		for(int i: brr) {
			print(i+"  ");
		}
		print("\n");
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		swap(arr,1,2);
		int a = 3;
		int b = 4;
		change(a,b);
		for(int i: arr) {
			System.out.printf(i+"  ");
		}
		print("\n");
		System.out.println(a+"  /  "+b);
		*/
		test t = (a,b) -> {return a*b;};
		int a = t.func(3,4);
		print(a);
		final int bye = 0;
		
	}
	public static void swap(int[] brr, int num1, int num2) {

		int temp = brr[num1];
		brr[num1] = brr[num2];
		brr[num2] = temp;
	}
	public static void swap(ArrayList<Integer> arr, int num1, int num2) {
		int temp = arr.get(num1);
		arr.set(num1, arr.get(num2));
		arr.set(num2, temp);
	}
	public static void change(Integer a, Integer b) {
		Integer temp = a.intValue();
		a = new Integer(b.intValue());
		b = new Integer(temp);
	}
	public static void println(Object o) {
		System.out.println(o);
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public interface test{
		public int func(int a, int b);
	}
	

}

