/**
 * 变形二分查找
 *

    前提：假设数组从小到大排序

    核心： 处理 二分查找的变体问题
        （1）查找第一个值等于给定值的元素
           (2)  查找最后一个值等于给定值的元素
         （3）查找第一个大于等于给定值的元素
         （4）查找最后一个小于等于给定值的元素
	细节问题：
	      终止条件、区分上下界更新方法、返回值选择


 * Author: JiahaoWu
 */
public class BinarySearch {

	//（1）查找第一个值等于给定值的元素
	public int bsearch(int[] a, int n , int value){
		int low = 0;
		int hight = n - 1;
		
		while(low <= high){
			int mid = low + (high - low)/2;
			if(a[mid] > value){
				high = mid - 1;
			}else if(a[mid] < value){
				low = mid + 1;
			}else{
				if(mid == 0 || a[mid-1]!=value){
					return mid;
				}else{
					high = mid - 1;
				}
			}
		}
		return - 1;
	}

	// (2)  查找最后一个值等于给定值的元素
	public int bsearch(int[] a, int n , int value){
		int low = 0;
		int hight = n - 1;
		
		while(low <= high){
			int mid = low + (high - low)/2;
			if(a[mid] > value){
				high = mid - 1;
			}else if(a[mid] < value){
				low = mid + 1;
			}else{
				if(mid == n - 1 || a[mid+1]!=value){
					return mid;
				}else{
					low = mid + 1;
				}
			}
		}
		return - 1;
	}

	//（3）查找第一个大于等于给定值的元素
	public int bsearch(int[] a, int n , int value){
		int low = 0;
		int hight = n - 1;
		
		while(low <= high){
			int mid = low + (high - low)/2;
			if(a[mid] >= value){
				if(mid == 0 || a[mid-1] < value){
					return mid;
				}else{
					high = mid - 1;
				}
			}else{
				low = mid + 1;
			}
		}
		return - 1;
	}


	//（4）查找最后一个小于等于给定值的元素
	public int bsearch(int[] a, int n , int value){
		int low = 0;
		int hight = n - 1;
		
		while(low <= high){
			int mid = low + (high - low)/2;
			if(a[mid] > value){
				high = mid - 1;
			}else{
				if(mid == n - 1 || a[mid + 1] > value){
					return mid;
				}else{
					low = mid + 1;
				}
			}
		}
		return - 1;
	}
}