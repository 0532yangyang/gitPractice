package OneP7;

public class OneP7P9 {

/**
 * @param args
 */

static boolean g_valid = true;
static double Power(double base, int exponent){
	if(base==0&&exponent==0){
		g_valid = false;
		return 0; 
	}
	if(Math.abs(base) <0.0001)//近似为0.
		return 0;
	if(exponent == 0)
		return 1.0;
	if(exponent<0)
		return 1/Power(base,-1*exponent);//幂是负数，相当于幂是正数再取倒数
	if(exponent==1)//也是下面迭代的终点
		return base;
	
	if(exponent>1){
		if(exponent%2 == 0){//幂是偶数
			double b = Power(base,exponent/2);
			return b*b;
		}
		else{//幂是奇数
			double b = Power(base,exponent/2);
			return b*b*Power(base,1);
		}
	}
	
	
	g_valid = false;
	return 0; 
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(Power(2,9)+",g_valid="+g_valid);
}

}
