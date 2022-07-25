import java.util.ArrayList;


public class ArrayListFunctions {
	
	/**
	 * 
	 * Write a function that takes an array of strings and returns
	 * an arraylist.  The arraylist should contain only the strings
	 * in the original list that begin with 'A'
	 * 
	 * So arrayListOfAs({"Abc","foo","AAA", "bar"}) yields ["Abc","AAA"]
	 */
	public static ArrayList<String> arraylistOfAs(String[] strings) {
		ArrayList st=new ArrayList();
		for(int i=0; i<strings.length;i++) {
			if(strings[i].charAt(0)=='A') st.add(strings[i]);
		}
		return st;
	}
	/**
	 * Takes an arrayList of numbers in sorted (ascending) 
	 * order and a number to add.
	 * 
	 * Adds the number in the correct place in the sorted list.
	 * 
	 * so insertIntoSorted([1,5,9],6) yields [1,5,6,9]
	 * 
	 */
	public static void insertIntoSorted(ArrayList<Integer> list, int number) {
		boolean pl=true;
		int i=0;
		while(pl=true) {
			if(list.get(i)>number) {
				list.add(i-1,number);
			}
		}
	}
	
	/**
	 * Takes an arraylist of strings and removes all strings longer
	 * than 3 characters.
	 * 
	 * So removeLongStrings(["a","xxxx","b","zzzzz"]) yields ["a","b"]
	 */
	public static void removeLongStrings(ArrayList<String> strings) {
		int i=0;
		while(i<strings.size()) {
			if(strings.get(i).length()>3) {
				strings.remove(i);
			}
			else i++;
		}
	}
	
}
