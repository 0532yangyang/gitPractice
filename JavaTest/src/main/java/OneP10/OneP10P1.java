package OneP10;

public class OneP10P1 {

/**
 * @param args
 */

public static void delNum(String str){
	if(str == null)
		return;
	StringBuffer sb = new StringBuffer(str);
	int j = 0;
	for(int i = 0;i<sb.length();i++){
		if(sb.charAt(i)<'0'||sb.charAt(i)>'9'){
			sb.replace(j, j+1, String.valueOf(sb.charAt(i)));
			j++;
		}
	}
	sb = new StringBuffer(sb.substring(0, j));
	System.out.println(sb);
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	delNum("2ba");
}

}
