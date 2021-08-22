import java.util.*;
import java.lang.*;
import java.io.*;
class fenwickTree {
	public void update(int ind,int val,int[] fen,int n) {		
		while(ind<=n) {
			fen[ind]+=val;
			ind = ind + (ind&-ind);
		}
	}
	public  int sum(int ind,int[] fen) {
		int s = 0;
		while(ind > 0) {
			s+=fen[ind];
			ind = ind - (ind&-ind);
		}
		return s;
	}
}
