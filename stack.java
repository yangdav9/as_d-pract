import java.util.*;

class stack {
	/*  variables  */
	ArrayList<String> data; 
	int current = -1;

	/* Consturctor */
	public stack() {
		this.data = new ArrayList<String>();
	}

	/* Methods */
	public static stack push(stack s, String value) {
		if (s.data.size() - 1 == s.current) {
			s.data.add(value);
			s.current++;
			return s;
		} else {
			s.data.set(s.current++,value);
			return s;
		}
	}

	public static stack pop(stack s) {
		if (s.current >= 0) {
			s.data.set(s.current, null);
			s.current--;
		}
		return s;
	}

	public static String peak(stack s) {
		return (s.current >= 0)? s.data.get(s.current) : null;
	}

	public static void main(String[] args) {
		stack s = new stack();

		System.out.println(peak(s));	
		s = push(s, "221");
		s = push(s, "AFK");
		s = push(s, "ARGHH");
		s = push(s, "FEEDING");
		System.out.println(peak(s));	
		s = push(s, "BOOOO");
		s = push(s, "ALL NIGHTER");
		s = push(s, "HOWME");
		System.out.println(peak(s));	

		System.out.println("FULL stack: " + s.data);

		// pop all
		s= pop(s);
		System.out.println("popped: " + peak(s));	
		s= pop(s);
		System.out.println("popped: " + peak(s));	
		s= pop(s);
		System.out.println("popped: " + peak(s));	
		s= pop(s);
		System.out.println("popped: " + peak(s));	
		s= pop(s);
		System.out.println("popped: " + peak(s));	
		s= pop(s);
		System.out.println("popped: " + peak(s));	
		s= pop(s);
		System.out.println(peak(s));	

	}
}

