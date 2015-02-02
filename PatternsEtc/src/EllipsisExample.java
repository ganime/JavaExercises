
public class EllipsisExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EllipsisExample examp = new EllipsisExample();
		System.out.println(examp.generalConcatAll("Hello", "World"));
		
		System.out.println(examp.generalConcatAll("Hello", ",", "World"));
	}

	public String generalConcatAll(String...strings) {

	    StringBuilder sb = new StringBuilder();

	    for(String array : strings) {
	         sb.append(array);
	    }

	    return sb.toString();

	}
}
