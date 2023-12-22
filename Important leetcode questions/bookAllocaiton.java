public class bookAllocaiton {
    public static void main(String[] args){
        bookAllocaiton main  = new bookAllocaiton();
        int[] arr = {10,20,30,40};//each book pages
        int n = arr.length;//no of books
        int m = 2;// Number of students
        //hint: number of pages are the minimum of maximum no alloted to students 
        int minima =main.minima(arr , n , m);
        System.out.println(minima);
    }
    public boolean ispossible(int[] arr, int n , int m , int mid){
      int pagesum = 0;
      int student = 1;
      for(int i = 0; i < n ; i ++){
        if(pagesum + arr[i] <= mid){
            pagesum += arr[i];
        }
        else{
            student++;
            if( student > m || arr[i] > mid){
                return false;
            }
            pagesum  = arr[i];
        }
      }
      return true;
    }
    public int minima(int[] arr, int n, int m){
       int s = 0;
       int sum = 0;
       for( int i= 0; i < n ; i ++)
       {
          sum += arr[i];  
       }
       int e = sum;
       int mid = s + (e -s )/2;
       int ans = -1;
       while(s <= e){
         if(ispossible(arr,n,m,mid)){
             ans = mid;
             e = mid -1;
         }
         else{
            s = mid + 1;
         }
         mid = s + (e -s )/2;
          }
          return ans;

    }
}
