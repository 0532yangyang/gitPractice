package OneP7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OneP7P6 {

/**
 * @param args
 */


public static void Least1(List<Integer> a){
	Collections.sort(a,new Comparator<Integer>() {
		public int compare(Integer m, Integer n) {
			String mn = String.valueOf(m)+String.valueOf(n);
			String nm = String.valueOf(n)+String.valueOf(m);
			int result = mn.compareTo(nm);
			if(result>0)
				return 1;
			if(result<0)
				return -1;
			return 0;
		}
	});
}

public static void Least2(List<Integer> a){
	Collections.sort(a,new Comparator<Integer>() {
		public int compare(Integer m, Integer n) {
			String mStr = String.valueOf(m);
			String nStr = String.valueOf(n);
			for(int i=0;;i++){
				//%长度是为了一方走到头之后再从1开始与另一方比较
				if(mStr.charAt(i%mStr.length())>nStr.charAt(i%nStr.length()))
						return 1;
				if(mStr.charAt(i%mStr.length())<nStr.charAt(i%nStr.length()))
						return -1;
				//m=32 n=3232 为了防止这种情况。这种情况的时候会在长串结尾测得两方+1都回到开头。
				if((i+1)%mStr.length()==0&&(i+1)%nStr.length()==0)
					return 0;
			}
		}
	});
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	List<Integer> a = new ArrayList<Integer>();
	a.add(32);
	a.add(3232);
	a.add(452);
	a.add(7);
	Least2(a);
	System.out.println("a="+a);
}

}
