import java.util.*;

public class Solution {
    public static List<Integer> quickSort(List<Integer> arr) {
        Solution main = new Solution();
        main.sort(arr, 0, arr.size() - 1);
        return arr;
    }

    // Quick sort algo
    public void sort(List<Integer> arr, int s, int e) {
      if(s >= e ) return ;
      int p = partition(arr, s, e);
      sort(arr, s, p -1);
      sort(arr, p+1, e);
    }

  public int partition(List<Integer> arr, int s, int e) {
         int pivot = arr.get(s);
         int count =0;
         for(int i =s +1; i <=e; i++){
              if(arr.get(i)< pivot) {
                  count ++;
              }
         }

         //swap to right positioning
         int pivotIndex = s + count;
         int temp = arr.get(s);
         arr.set(s, arr.get(pivotIndex));
         arr.set(pivotIndex, temp);

         //swap ele left -right
         int i =s, j=e;
         while(i < pivotIndex && j > pivotIndex){
             while(arr.get(i) < pivot ){
                 i++;
             }
             while(arr.get(j)> pivot){
                 j--;
             }
             if(i < pivotIndex && j > pivotIndex){
                 int swap = arr.get(i);
                 arr.set(i, arr.get(j));
                 arr.set(j, swap);
             }
             i++;
             j--;
         }
         return pivotIndex;
        }   
}
