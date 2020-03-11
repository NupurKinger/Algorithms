import java.util.Stack;

/**
 * 
 * GIVEN: Dn-D1 are in S1
 * 
 * GOAL: Transfer Dn-D1 from S1 to S3
 *	1. Transfer D(n-1)-D1 from S1 to S2
 *	2. Transfer Dn from S1 to S3
 *  3. Transfer D(n-1)-D1 from S2 to S3
 * 
 * @author Nupur Kinger
 *
 */
public class TowerOfHanoiUsingStacks {
	private int n;
	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();
	private Stack<Integer> s3 = new Stack<>();
	
	public TowerOfHanoiUsingStacks(int discsCount) {
		n = discsCount;
	}
	
	public static void main (String[] args) {
		TowerOfHanoiUsingStacks discs_3 = new TowerOfHanoiUsingStacks(3);
		TowerOfHanoiUsingStacks discs_4 = new TowerOfHanoiUsingStacks(4);

		discs_3.start();
		discs_4.start();
	}
	
	void start() {
		// GIVEN: Dn-D1 are in S1
		initializeStack1WithDiscs();
		
		printStacks();
		
		// GOAL: Transfer Dn-D1 from S1 to S3
		transferDiscs(n, s1, s3, s2);
		
		System.out.println("*********************************** COMPLETE **********************************");
	}
	
	void transferDiscs(int disc, Stack<Integer> fromStack, Stack<Integer> toStack, Stack<Integer> extraStack) {
		if (disc == 1) {
			transferDisc(fromStack, toStack);
			return;
		} 
		
		// 1. Transfer D(n-1)-D1 from 'fromStack' to 'extraStack'
		transferDiscs(disc - 1, fromStack, extraStack, toStack);
		
		// 2. Transfer Dn from 'fromStack' to 'toStack'
		transferDisc(fromStack, toStack);
		
		// 3. Transfer D(n-1)-D1 from 'extraStack' to 'toStack'
		transferDiscs(disc - 1, extraStack, toStack, fromStack);
		}
	
	void transferDisc(Stack<Integer> fromStack, Stack<Integer> toStack) {
		int disc = fromStack.pop();
		toStack.push(disc);
		
		printStacks();
	}
	
	void initializeStack1WithDiscs() {
		for (int i = n ; i > 0 ; i--) {
			s1.add(i);
		}
	}
	
	void printStacks() {
		
		System.out.print("\n## S1 ##  ");
		s1.stream().forEach(disc -> System.out.print(disc + "\t"));

		System.out.print("\n## S2 ##  ");
		s2.stream().forEach(disc -> System.out.print(disc + "\t"));

		System.out.print("\n## S3 ##  ");
		s3.stream().forEach(disc -> System.out.print(disc + "\t"));

		System.out.println();
	}
}
