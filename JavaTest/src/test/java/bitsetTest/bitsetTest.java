package bitsetTest;

import java.util.BitSet;

public class bitsetTest {

/**
 * @param args
 */

	public static void int2Bin(long data){
		char b[] = {'0','1'};
		int base = 2;
		StringBuilder sb = new StringBuilder("");
		do{
			sb.append(b[(int)(data%base)]);
			data/=base;
		}while(data!=0);
		System.out.println(sb.reverse());
	}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	int2Bin(-1);
}

}
