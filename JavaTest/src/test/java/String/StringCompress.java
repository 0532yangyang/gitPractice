package String;

import java.util.ArrayList;

public class StringCompress {

/**
 * @param args
 */

public static ArrayList<Integer> primeList = new ArrayList<Integer>();

public static String strCompress(String s){
	StringBuilder sb = new StringBuilder();
	if(s==null||s.length()==1)
		return s;
	char curChar = s.charAt(0);
	int times = 1;
	for(int i=1;i<s.length();i++){
		if(curChar==s.charAt(i)){
			times++;
		}
		else{
			sb.append(curChar+String.valueOf(times));
			curChar = s.charAt(i);
			times = 1;
		}
	}//end for
	sb.append(curChar+String.valueOf(times));
	return sb.toString();
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(strCompress("eeeeeaaaff"));
}

}
