package class03;

public class Code08_GetMax {

	// 求arr中的最大值：递归实现
	public static int getMax(int[] arr) {
		return process(arr, 0, arr.length - 1);
	}

	// arr[L..R]范围上求最大值  L ... R   N
	public static int process(int[] arr, int L, int R) {
		// arr[L..R]范围上只有一个数，直接返回，base case
		if (L == R) { 
			return arr[L];
		}
		// L...R 不只一个数
		// mid = (L + R) / 2
		int mid = L + ((R - L) >> 1); // 中点   	1
		int leftMax = process(arr, L, mid);					// 该层会一直深入递归函数，直到不能进入，并返回左边最大值；再执行下一步的右边递归
		int rightMax = process(arr, mid + 1, R);		
		return Math.max(leftMax, rightMax);
	}
	
	// 记录几点：
	/*
		1、递归实现时，递归函数要有跳出口；
		2、递归的时间复杂度计算公式：T(N) = aT(N/b) + O(N^d)；
				如果 ....
		3、注意递归的执行逻辑，先进入一层，如果该层还能往下进行，则一直往下进行，返回结果后，再返回走第二层
	*/

}
