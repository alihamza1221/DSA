public class bubbleSortingRecursive{
  public static void main(String[] args){
    bubbleSortingRecursive main = new bubbleSortingRecursive();
    int[] arr = { 2,4,5,6,6,4,3,1};
    int[] sorted = main.sortarray(arr,arr.length-1);
    for(int i : arr){
        System.out.print(i + " ");
    }
      }
  public int[] sortarray(int[] arr, int n){
    //Base case 
    if(n < 0){
      return arr;
    }
    for(int i = 0 ; i < n; i++){
      if(arr[i] > arr[i+1]){
        //swap
        int temp = arr[i +1];
        arr[i +1] = arr[i];
        arr[i] = temp;
      }
    }
    return sortarray(arr,n -1);
  }
}
