import java.util.*;

class heap {

	/* Variables */
	ArrayList<Integer> data;
	int n;

	/* Constructor */
	public heap(ArrayList<Integer> temp) {
		data = new ArrayList<Integer>(temp); //copy array into heap to heapify
		n = data.size();
		buildHeap(this);
	}

	public static void buildHeap(heap h) {
		int index = (h.n-1)/2;
		for(int i = index; i >= 0; i--) {
			minHeapify(h,i);
		}
	}

	public static void minHeapify(heap h, int index) {
		int leftIndex = (2*index)+1, rightIndex = (2*index)+2, smallest = index;

		if ((leftIndex < h.n) && (h.data.get(leftIndex) < h.data.get(index))) {
			smallest = leftIndex;
		}

		if ((rightIndex < h.n) && (h.data.get(rightIndex) < h.data.get(smallest))) {
			smallest = rightIndex;
		}

		if (smallest != index) {
			//swap smallest with IndexA
			Collections.swap(h.data, index, smallest);
			minHeapify(h,smallest);
		}

		return;
	}

    public void print(heap h) 
	{ 
		for (int i = 0; i < (h.n-1) / 2; i++) { 
			System.out.print(" PARENT : " + h.data.get(i) + " LEFT CHILD : " + h.data.get(2*i+1) 
					+ " RIGHT CHILD :" + h.data.get(2*i+2)); 
			System.out.println(); 
		}																				
	} 

	public static Integer getMin(heap h) {
		return h.data.get(0); //root at 0th element should be min in minHeap
	}


	public static heap extractMin(heap h) {
		h.data.set(0,h.data.get(h.n-1)); //replace first elem with last in list
		h.data.set(h.n-1,Integer.MAX_VALUE); //replace last elem with max
		h.n--;
		buildHeap(h);
		return h;
	}

	public static heap insert(heap h, Integer val) {
		if (h.data.size() == h.n) { //no elem deleted before
			h.data.add(val);
		} else {
			h.data.set(h.n, val); // add elem to immediately after (n-1)
		}
		h.n++;
		buildHeap(h);
		return h;
	}


	public static void main(String[] args) {
		ArrayList<Integer> temp = new ArrayList<Integer>( Arrays.asList(17,15,3,5,9,6,13,10,1,8,4,3) );
		heap h = new heap(temp);
		/*
		System.out.println("MIN: " + getMin(h));
		h = extractMin(h);
		System.out.println("MIN: " + getMin(h));
		h = insert(h,2);
		System.out.println("MIN: " + getMin(h));
		*/

		// HeapSort
		for (int i = 0; i < h.data.size(); i++) {
			System.out.println("MIN: " + getMin(h));
			h = extractMin(h);
		}
		
	}


}
