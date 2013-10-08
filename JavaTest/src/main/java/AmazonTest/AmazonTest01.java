package AmazonTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AmazonTest01 {

/**
 * @param args
 */

static List<Integer> caculate1(List<Integer> a, int b) {
    // a : storing the prices for each good, in the same order as the input good
    // b : money
    // return value: storing the number of bought goods, in the same order as the input good
	List<Integer> aCounts = new ArrayList<Integer>(a.size());
	int min = a.get(0);
	for(int i=1;i<a.size();i++)
		if(a.get(i)<min)
			min = a.get(i);
	if(b<min){
		aCounts.add(0);
		return aCounts;
	}
	
	for(int i=0;i<a.size();i++)
		aCounts.add(0);
	
	
	
	return null;
}

public static void makeChange(int[] values, int valueKinds, int money,  
        int[] coinsUsed) {  
	ArrayList<Integer> usedNumbers;
	
    coinsUsed[0] = 0;  
    // 对每一分钱都找零，即保存子问题的解以备用，即填表  
    for (int cents = 1; cents <= money; cents++) {  
    	usedNumbers=  new ArrayList<Integer>();
    	for(int i=0;i<valueKinds;i++)
    		usedNumbers.add(0);
    	
        // 当用最小币值的硬币找零时，所需硬币数量最多  
        int minCoins = cents;  

        // 遍历每一种面值的硬币，看是否可作为找零的其中之一  
        for (int kind = 0; kind < valueKinds; kind++) {               
            // 若当前面值的硬币小于当前的cents则分解问题并查表  
            if (values[kind] <= cents) {  
                int temp = coinsUsed[cents - values[kind]] + 1;  
                if (temp < minCoins) {
                	usedNumbers.set(kind,usedNumbers.get(kind)+1);
                    minCoins = temp;  
                }
            }  
        }  
        // 保存最小硬币数  
        coinsUsed[cents] = minCoins; 
        System.out.println("面值为 " + (cents) + " 的最小硬币数 : " 
                + coinsUsed[cents]+"shumu="+usedNumbers);  
    }  
}  

static List<Integer> caculate2(List<Integer> a, int b) {
	if(a==null||a.size()<=0||b<1)
		return null;
	 int[] numofStamps = new int[b + 1];
	 numofStamps[0] = 0;
	 for(int i = 1; i <= b; i++){
	  int cn = i;
	  for(int j = 0; j < a.size(); j++){
	   if(a.get(j) <= i){
	    int tmp = numofStamps[i - a.get(j)] + 1;
	    if(tmp < cn)
	     cn = tmp;
	   }
	  }
	  numofStamps[i] = cn;
	 }

	 int rst = numofStamps[b];
//	 return rst;
	 return null;
}




public static void main(String[] args) {
	// TODO Auto-generated method stub
    // 硬币面值预先已经按降序排列  
    int[] coinValue = new int[] { 25, 21, 10, 5, 1 };  
    // 需要找零的面值  
    int money = 63;  
    // 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1  
    int[] coinsUsed = new int[money + 1];  

    makeChange(coinValue, coinValue.length, money, coinsUsed);  
}

}
