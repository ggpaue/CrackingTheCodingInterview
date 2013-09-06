import java.util.ArrayList;
public class ARStack {
	ArrayList array = new ArrayList();
	
	public Object pop() {
		if(array.size() == 0) return null;
		return array.remove(array.size() - 1);
	}
	
	public void push(Object item) {
		array.add(item);
	}
	
	public Object peek() {
		if(array.size() == 0) return null;
		return array.get(array.size() - 1);
	}
	
	public boolean isEmpty() {
		return (array.size() == 0);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = array.size() - 1; i >= 0; i--) {
			sb.append(array.get(i).toString());
			if(i != 0) {
				sb.append("->");
			}
		}
		return sb.toString();
	}

}
