class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int lastindexn1 = m -1;
      int lastindexn2 = n -1;
      int lastindexmerged = nums1.length-1;
      while(lastindexn2 >= 0){
        if(lastindexn1 >= 0 && nums1[lastindexn1] > nums2[lastindexn2]){
            nums1[lastindexmerged--] = nums1[lastindexn1--];
        }
        else{
            nums1[lastindexmerged--] = nums2[lastindexn2--];
        }
      }
     

    }
}
