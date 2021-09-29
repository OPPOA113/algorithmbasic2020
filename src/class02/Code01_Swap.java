package class02;

public class Code01_Swap {
	
	public static void main(String[] args) {

		
		
		
		
		
		int a = 16;
		int b = 603;
		
		System.out.println(a);
		System.out.println(b);
		
		
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		
		
		System.out.println(a);
		System.out.println(b);
		
		
		
		
		int[] arr = {3,1,100};
		
		int i = 0;
		int j = 0;
		
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
		
		System.out.println(arr[i] + " , " + arr[j]);
		
		
		
		
		
		
		
		
		
		System.out.println(arr[0]);
		System.out.println(arr[2]);
		
		swap(arr, 0, 0);
		
		System.out.println(arr[0]);
		System.out.println(arr[2]);
		
		
		
	}
	
	// 两数交换，可以用这种方式交换的原则是：两数存在不同的内存空间中：
	// 可以按这种方式交换的原因是：异或运算满足交换律和结合律：
	// 0^N = N;
	// N^N = 0;
	// 异或预算实质就是按位不进位相加。
	public static void swap (int[] arr, int i, int j) {
		// arr[0] = arr[0] ^ arr[0];
		arr[i]  = arr[i] ^ arr[j];
		arr[j]  = arr[i] ^ arr[j];
		arr[i]  = arr[i] ^ arr[j];
	}
	
	

}
