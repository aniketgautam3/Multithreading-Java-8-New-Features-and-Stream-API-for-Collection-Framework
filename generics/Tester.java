package generics;

import java.util.ArrayList;

public final class Tester {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("A");
		a.add("B");
		a.add("C");
		GenericArray<String> strArr = new GenericArray<String>(a);
		strArr.display();
		
		ArrayList<Float> b = new ArrayList<Float>();
		b.add(10f);
		b.add(20f);
		b.add(30f);
		GenericArray<Float> fArr = new GenericArray<Float>(b);
		fArr.display();
		
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(10);
		c.add(20);
		c.add(30);
		GenericArray<Integer> intArr = new GenericArray<Integer>(c);
		intArr.display();
		
		ArrayList<Double> d = new ArrayList<Double>();
		d.add(20d);
		d.add(40d);
		d.add(60d);
		GenericArray<Double> doubArr = new GenericArray<Double>(d);
		doubArr.display();
		
		
	}

}
