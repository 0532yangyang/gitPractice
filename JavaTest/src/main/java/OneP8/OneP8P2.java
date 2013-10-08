package OneP8;

public class OneP8P2 {

/**
 * @param args
 */

public static int MoreThanHalfNum1(int[] numbers){
	if(numbers.length<=0)
		return 0;
	int middle = numbers.length>>1;
	int start = 0;
	int end = numbers.length-1;
	int index = Partition2(numbers,start, end);
	while(index!=middle){
		if(index>middle){
			end = index-1;
			index = Partition2(numbers,start, end);
		}
		else{
			start = index+1;
			index = Partition1(numbers,start, end);
		}
	}
	return numbers[middle];
}

public static int MoreThanHalfNum2(int[] numbers){
	//防御性先不写了
	int result = numbers[0];
	int times = 1;
	for(int i=1;i<numbers.length;i++){
		if(times == 0){
			result = numbers[i];
			times = 1;
		}
		else if(numbers[i]==result){
			times++;
		}
		else
			times--;
	}
	return result;
}


public static void swap(int[] numbers, int i, int j){
	int tmp = numbers[i];
	numbers[i] = numbers[j];
	numbers[j] = tmp;
}

public static int Partition1(int[] numbers, int low,int high){
	int key = numbers[high];
	int i = low-1;//i保存numbers中最后一个≤key值的元素的下标。
	for(int j = low;j<high;j++){
		if(numbers[j]<=key){
			i++;
			swap(numbers,i,j);
		}
	}
	swap(numbers,i+1,high);
	return i+1;
}

public static int Partition2(int[] numbers, int low,int high){
	int key = numbers[0];
	while(low<high){
		while(key<=numbers[high]&&low<high)
			high--;
		numbers[low] = numbers[high];
		while(key>=numbers[high]&&low<high)
			low++;
		numbers[high] = numbers[low];
	}
	numbers[low] = key;
	return low;
}

public static void main(String[] args) {
	// TODO Auto-generated method stub

}

}
