import java.util.*;
import java.lang.*;
import java.io.*;
class fenwickTree {
	int[] fenwick = new int[100005];
	int[] arr = new int[100005]; // in this we will take intput
	public static void update(int ind,int val) {
		a[ind] +=val;
		while(ind<=n) {
			fen[ind]+=val;
			ind = ind + (ind&-ind);
		}
	}
	public static int sum(int ind) {
		int s = 0;
		while(ind > 0) {
			sum+=fen[ind];
			ind = ind - (ind&-ind);
		}
		return s;
	}
}