import java.util.*;

class sorting {


	public static void quickSort(int[] data, int lo, int hi) {

		if (lo < hi) {
			int p = partition(data, lo, hi);
			quickSort(data,lo,p-1);
			quickSort(data,p+1,hi);
		}

	}

	public static int partition(int[] data, int lo, int hi) {
		int pivot = data[hi];
		int i = lo;
		for (int j = lo; j <= hi; j++) {
			if (data[j] < pivot) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				i++;
			}
		}
		int temp = data[hi];
		data[hi] = data[i];
		data[i] = temp;
		return i;
	}

	public static void mergeSort(int[] data, int l, int r) {
		if (l < r) {
			int m = (l+r)/2;

			mergeSort(data,l,m);
			mergeSort(data,m+1,r);
			merge(data,l,m,r);

		}

	}

	public static void merge(int[] data, int l, int m, int r) {
		int n1 = m-l+1;
		int n2 = r-m;

		int[] A = new int[n1];
		int[] B = new int[n2];

		for (int i = 0; i < n1; i++) {
			A[i] = data[l+i];
		}

		for (int i = 0; i < n2; i++) {
			B[i] = data[m+1+i];
		}

		int i = 0, j = 0;

		while ((i < A.length) && (j < B.length)) {
			if (A[i] < B[j]) {
				data[l++] = A[i++];
			} else {
				data[l++] = B[j++];
			}
		}

		while (i < A.length) {
			data[l++] = A[i++];
		}

		while (j < B.length) {
			data[l++] = B[j++];
		}

	
	}


	public static void main(String[] args) {
		int[] data = {17,15,3,5,9,6,13,10,1,8,4,3}; // array to be sorted

		System.out.println("Before sort: ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}


//		quickSort(data,0,data.length-1);
		mergeSort(data,0,data.length-1);


		System.out.println("\n\nAfter sort: ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
