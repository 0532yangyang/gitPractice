package OneP7;

public class OneP7P5 {

/**
 * @param args
 */

static void calAmounts(int leftN,int leftS, int S, int[] a){
	if((leftS<leftN)||(leftS>6*leftN))//不合规矩，得不到一个合法序列，回退。
		return ;
	if(leftN == 1)//进行到最后一步了，且leftN和规矩[1,6]，那么其值是能唯一确定的，递归序列为合法序列，在a的对应的位置上+1.
		a[S]++;
	else
		for(int m=1;m<=6;m++)
			calAmounts(leftN-1, leftS-m, S, a);
}

public static void calAmountsAll(int N, int[][] a){
	int flag = 0;
	for(int i=1;i<=6;i++)
		a[flag][i] = 1;
	for(int tzNum=2;tzNum<=N;tzNum++){//从2迭代运算到N，N时的a[flag]即为所求
		for(int i=0;i<tzNum;i++)//对于tzNum个骰子，[0,tzNum-1]是比最小值还要小的，取不到置0.
			a[1-flag][i] = 0;
		
		for(int sum=tzNum;sum<=6*tzNum;sum++){//n个骰子的总和设为sum值∈[tzNum,6tzNum]，对于每一个sum，累加...。
			a[1-flag][sum] = 0;
			for(int i=1;i<=sum&&i<=6;i++)//i从1取到6，但是要保证sum-i>=0：2个骰子sum=3，那么只能分为j=1:1->(2)和j=2:2->(1).
				a[1-flag][sum]+=a[flag][sum-i];
		}
		flag = 1-flag;
	}
	
	double total = Math.pow(6,N);
	for(int i=N;i<=6*N;i++)
	System.out.println("N="+i+",Prob="+a[flag][i]+"/"+total);
}


public static void main(String[] args) {
	// TODO Auto-generated method stub
	int N = 2;
//	int[] a = new int[6*N+1];
//	for(int S=N;S<=6*N;S++)
//		calAmounts(N,S,S,a);
//	int cal = 0;
//	for(int i=N;i<=6*N;i++)
//		cal+=a[i];
//	for(int i=N;i<=6*N;i++)
//		System.out.println("N="+i+",Prob="+a[i]+"/"+cal);
//	
	int[][] a = new int[2][6*N+1]; 
	calAmountsAll(2,a);
}


}
