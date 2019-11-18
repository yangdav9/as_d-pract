import java.util.*;

class queue {

	/* Variables */
	LinkedList<String> data;

	/* Constructor */
	public queue() {
		this.data = new LinkedList<String>();
	}

	/* Methods */
	public static queue enqueue(queue q, String s) {
		q.data.addLast(s);
		return q;
	}

	public static queue dequeue(queue q) {
		if(q.data.size() != 0) q.data.removeFirst();
		return q;

	}

	public static String peak(queue q) {
		if(q.data.size() == 0) return null;
		else return q.data.getFirst();
	}

	public static void main(String[] args) {
		queue q = new queue();


		System.out.println(peak(q));
		q = enqueue(q, "oom");
		System.out.println(peak(q));
		q = enqueue(q, "tweet");
		q = enqueue(q, "cow");
		q = enqueue(q, "zoom");
		q = enqueue(q, "runescape");
		q = enqueue(q, "29384");
		System.out.println(peak(q));
		System.out.println("whole queue: " + q.data);
		q = dequeue(q);
		System.out.println(peak(q));
		q = dequeue(q);
		System.out.println(peak(q));
		q = dequeue(q);
		System.out.println(peak(q));
		q = dequeue(q);
		System.out.println(peak(q));
		q = dequeue(q);
		System.out.println(peak(q));
		q = dequeue(q);
		System.out.println(peak(q));
	}

}
