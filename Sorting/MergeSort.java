public class Solution {
	public static void mergeSort(int[] arr, int n) {
		// Write your code here.
		Solution main = new Solution();
		main.sort(arr, 0 , n -1);
	}
	public void  sort(int[] arr, int s,int e){
		if(s >= e){ return;}
		int mid  = s + ( e-s )/2;
		sort(arr,s, mid);
		sort(arr,mid+1,e);
		merge(arr,mid,s , e);
	}
	public void merge (int []arr,int mid, int s , int e){
		int[] merged = new int[e - s +1];
		int index1 = s;
		int index2 = mid+1;
		int k = 0;
		while( index2 <= e && index1 <= mid){
			if(arr[index1] > arr[index2]){
				merged[k++]  = arr[index2++];
			}
			else{
				merged[k++] = arr[index1++];
			}
		}
		while(index1 <= mid){
			merged[k++] = arr[index1++];
		}
		while(index2  <= e){
			merged[k++] = arr[index2++];
		}
	  for(int i = 0,j = s; i< merged.length;i++,j++){
		  arr[j] = merged[i];
	  }
	}
}
