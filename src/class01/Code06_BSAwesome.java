package class01;

public class Code06_BSAwesome {
// 返回数组的局部最小值索引
	public static int getLessIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1; // no exist
		}
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] > arr[mid - 1]) {				// 中间值大于左边，则坐标存在局部最小值，右边界改为中间
				right = mid - 1;
			} else if (arr[mid] > arr[mid + 1]) {		// 中间值大于右边，则右边存在局部最小值，左边界改为中间
				left = mid + 1;
			} else {
				return mid;								// 不大于左边，也不大于右边，则返回局部最小位置
			}
		}
		return left;
	}

}
