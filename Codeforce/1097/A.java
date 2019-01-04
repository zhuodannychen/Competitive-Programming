import java.util.*;

public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String hand[] = new String[5];
		for(int i = 0;i<5;i++){
			hand[i] = sc.next();
		}
		boolean flag = false;
		for(int i = 0;i < 5;i++){
			if(hand[i].charAt(0) == s.charAt(0) || hand[i].charAt(1) == s.charAt(1)){
				flag = true;
				break;
			}
		}
		if(flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
