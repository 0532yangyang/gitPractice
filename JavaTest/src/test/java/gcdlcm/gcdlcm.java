package gcdlcm;

public class gcdlcm {

/**
 * @param args
 */


 public static int gcd(int a, int b){
	 if(a<b){
		 int tmp = a;
		 a = b;
		 b = tmp;
	 }		 
	 if(b==0)
		 return a;
	 return gcd(b,a%b);
 }
 
 
 public static int ngcd(int[] a){
	 if(a.length==1)
		 return a[0];
	 int tmpGcd = gcd(a[0],a[1]);
	 for(int i=2;i<a.length;i++)
		 tmpGcd = gcd(tmpGcd,a[i]);
	 return tmpGcd;
 }

public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(gcd(15,3));
	int[] a = {15,625,125};
	System.out.println(ngcd(a));
}

}
