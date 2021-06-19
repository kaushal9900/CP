import java.util.*;
import java.lang.*;
import java.io.*;

Class SieveOfEratosthenes {

	public static Seive(int n) {
		boolean seive[] = new boolean[n+1];
		Arrays.fill(seive,true);
		for(int p=2;p*p<=n;p++) {
			if(seive[p]) {
				for(int i=p*p;i<=n;p+=i) {
					seive[i] = false;
				}
			}
		}
	}
}