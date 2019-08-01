/**
 * 简易二分查找
 *
   假设数组从小到大排序，且数组元素，不重复

 * Author: JiahaoWu
 */
public class BinarySearch {

	public int bsearch(int[] a, int n , int value){
		int low = 0;
		int hight = n - 1;
		
		while(low <= high){
			int mid = low + (high - low)/2;
			if (a[mid] == value) {
				return mid;
			}elseif(a[mid] < value){
				low = mid + 1;
			}else{
				high = mid - 1;
			}
		}
		return - 1;
	}


	//递归实现
	public int bsearch(int[] a, int n , int value){
		return bsearchInternally(a,0,n-1,value);
	}

	private int bsearchInternally(int[] a, int low,int high , int value){
		if(low > high) return;

		int mid = low + (high - low ) / 2;
		if (a[mid] == value) {
			return mid;
		}elseif(a[mid] < value){
			bsearchInternally(a,mid+1,high,value);
		}else{
			bsearchInternally(a,low,mid-1,value);
		}

	}


}