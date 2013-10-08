package OneP10;

public class OneP10P3 {

/**
 * @param args
 */

public static void reverseStrWithNoExtraSpace(StringBuffer str){
	for(int i=0;i<str.length()/2;i++){
		int j = str.length()-i-1;
		System.out.println(str.charAt(j)+str.charAt(i));
		str.replace(i, i+1, String.valueOf((char)(str.charAt(i)^str.charAt(j))));
		str.replace(j, j+1, String.valueOf((char)(str.charAt(i)^str.charAt(j))));
		str.replace(i, i+1, String.valueOf((char)(str.charAt(i)^str.charAt(j))));
	}
	System.out.println("ReversedStr="+str);
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	reverseStrWithNoExtraSpace(new StringBuffer("abcdefg"));
}

}
