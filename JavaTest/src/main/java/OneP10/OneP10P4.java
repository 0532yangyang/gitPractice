package OneP10;

import java.util.ArrayList;
import java.util.Collections;

public class OneP10P4 {

/**
 * @param args
 */

public static int maxSubString1(ArrayList<Integer> a){
	if(a.size()==1)
		return 1;
	int maxDiff = -1;
	int curDiff = -1;
	int curStartNum = -1;
	int maxStartNum = -1;
	int curLength = 0;
	int maxLength = 0;
	for(int i=1;i<a.size();i++){
		if(curDiff<0){//第一次
			maxDiff = curDiff = a.get(i)-a.get(i-1);
			maxStartNum = curStartNum = i-1;
			maxLength = curLength = 2;
		}
		else{
			if(curDiff != a.get(i)-a.get(i-1)){
				curDiff = a.get(i)-a.get(i-1);
				curStartNum = i-1;
				curLength = 2;
			}
			else{
				curLength++;
				if(curLength>maxLength){
					maxDiff = curDiff;
					maxStartNum = curStartNum;
					maxLength = curLength;
				}
			}
		}
	}//end for
	if(maxLength>=3){
		for(int i=0;i<maxLength;i++)
			System.out.print(a.get(maxStartNum+i)+" ");
		return maxLength;
	}
	else return -1;
}

public static int maxSubString2(ArrayList<Integer> a){
	if(a.size()<=1)
		return 1;
	int maxLength = 1; 
	int maxEnd = -1;
	int maxDiff = -1;
	int[][] dp = new int[a.size()][a.get(a.size()-1)-a.get(0)+1];
	for(int i=0;i<a.size();i++)
		for(int j=0;j<(a.size()-a.get(0));j++)
			dp[i][j] = 1;
	for(int i=1;i<a.size();i++){
		for(int j=0;j<i;j++){
			if(dp[i][a.get(i)-a.get(j)]!=1)
				continue;
			dp[i][a.get(i)-a.get(j)] = dp[j][a.get(i)-a.get(j)]+1;
			if(dp[i][a.get(i)-a.get(j)]>maxLength){
				maxLength = dp[i][a.get(i)-a.get(j)];
				maxEnd = i;
				maxDiff = a.get(i)-a.get(j);
			}
		}
	}
	
	if(maxLength>=2)
		for(int i = 0;i<maxLength;i++)
			System.out.println((a.get(maxEnd)-maxDiff*i)+" ");
	return maxLength;
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	ArrayList<Integer> a = new ArrayList<Integer>();
	a.add(1);
	a.add(3);
	a.add(0);
	a.add(5);
	a.add(-1);
	a.add(6);
	Collections.sort(a);
	maxSubString2(a);
}

}
