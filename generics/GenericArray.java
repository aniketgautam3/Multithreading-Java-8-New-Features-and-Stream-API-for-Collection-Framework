package generics;

import java.util.ArrayList;
import java.util.Iterator;

public final class GenericArray <T> {
	ArrayList <T> arr;

	public GenericArray(ArrayList<T> arr) {
		this.arr = arr;
	}
	
	public final void display() {
		System.out.print("Contents of the array: ");
		
		Iterator<T> it = arr.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		
		System.out.println("\n");
	}
	
}
