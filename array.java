//import java.util.*;

class array {

	public static void main(String args[]) {
		int [] anArray;		
		int [] scndArray = { 1,4,5,6,2,5,6,9,11,13,15,0,13};
		//allocate mem here
		anArray = new int[10];
		

		anArray[0] = 5;

		System.arraycopy(scndArray,0,anArray,1,8);
		for (int i = 0; i < 10; ++i) {
			System.out.println("Element at index " + i +
								" is: " + anArray[i]);
		}
	}

}
