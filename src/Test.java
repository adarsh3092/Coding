import java.util.ArrayList;
import java.util.List;

public class Test {
	static List<String> doAdd(List<String> list){
		list.add("2");
		return list;
	}
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("1");
		list.add("3") ;
		doAdd(list);
		System.out.println(list);
	}

}
