
public class Solution {
    public static int search(int []nums, int target) {
        // Write your code here.
        Solution main = new Solution();
        int index = main.binarysearch(nums, target,0,nums.length -1);
        return index;
    }
     public int binarysearch(int[] nums , int target,int s , int e){
        int mid = s + (e - s)/2;
         //Base Case 
         if(s > e){
             return -1;
         } 
         if(target == nums[mid]){
             return mid;
         }
         // Recusrion- Relation
         if(target > nums[mid]){
           return binarysearch(nums,target,mid +1,e);
         }
         else if(target < nums[mid]){
           return  binarysearch(nums,target,s,mid -1);
         }
         return -1;
       
        }
}
