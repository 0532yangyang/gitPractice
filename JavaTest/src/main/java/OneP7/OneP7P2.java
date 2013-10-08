package OneP7;

public class OneP7P2 {

/**
 * @param args
 */

public static void LargestN(int nValue){
	int[] a = new int[nValue];
	a[0] = 1;
	while(StrIncrement(a))
		PrintStrNum(a);
}
//如果溢出（n=3  999+1后，最后jinwei=true,a[2]=0），返回false,否则返回true
public static boolean StrIncrement(int[] a){
	boolean jinwei = true;
	for(int i=0;i<a.length;i++){
		if(a[i]!= 9){
			a[i]++;
			jinwei = false;
			break;
		}
		else 
			a[i] = 0;
	}
	if(jinwei == true && a[a.length-1]==0)//如果溢出
		return false;
	else return true;
}
//前面的0不打印
public static void PrintStrNum(int[] a){
	boolean noOutPut = true;
	for(int i=a.length-1;i>=0;i--){
		if(noOutPut==true){
			if(a[i]==0)
				continue;
			else
				noOutPut = false;
		}//end if
		System.out.print(a[i]);
	}//end for
	System.out.println();
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	LargestN(3);
}

}
