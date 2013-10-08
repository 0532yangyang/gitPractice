package AmazonTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AmazonTest02 {

/**
 * @param args
 */

static String[] dequeue(int count, String[] queue) {
	if(count<1||queue.length<1)
		return null;
	int i = 0;
	List<Integer> numbers = new ArrayList<Integer>();
	LinkedList<String> queueList = new LinkedList<String>();
	for(int t=0;t<queue.length;t++)
		queueList.add(queue[t]);
	
	for(i=0;i<queue.length;i++)
		numbers.add(i);
	int cur = 0;
	while(numbers.size()>1){
		for(int j=1;j<count;j++){
			cur++;
			if(cur==numbers.size())
				cur = 0;
		}
		
		int next = ++cur;
		if(next == numbers.size())
			next = 0;
		
		--cur;
		System.out.println(" "+queueList.get(cur));
		numbers.remove(cur);
		queueList.remove(cur);
		cur = next;
	}
	System.out.println(" "+queueList.get(cur));
	return null;
}

static String[] dequeue2(int count, String[] queue) {
	if(count<1||queue==null||queue.length<1)
		return null;
	String[] results = new String[queue.length]; 
	int resultsCount = 0;
    int[] a=new int[queue.length];
    int len=queue.length;
    for(int i=0;i<a.length;i++)
        a[i]=i+1;
    int i=0;
    int j=1;
    while(len>0){
        if(a[i%queue.length]>0){
            if(j%count==0){
            	results[resultsCount++] = queue[i%queue.length];
               // System.out.print(queue[i%queue.length]+"  ");
                a[i%queue.length]=-1;
                j=1;
                i++;
                len--;
            }else{
                i++;
                j++;
            }
        }else{
            i++;
        }
    }
	return results;
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	String[] queue = {"a","b","c","d","e","f","g","h","i","j","k"};
	System.out.println(queue.toString());
//	dequeue(3,queue);
	
	String[] results = dequeue2(4,queue);

	System.out.println(queue.toString());
}

}
