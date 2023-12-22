class Solution {
    public int maxLength(List<String> arr) {
        int index  = 0;
        int[] selected = new int [26];
        int len = 0;
        return solve(index,arr,selected,len);
    }
    public static boolean compare (int[] selected, String currentstr){
         int[] selfchk = new int[26];
         for(int i =0; i< currentstr.length() ; i++){
            if(selfchk[currentstr.charAt(i) -'a'] == 1 ) return false;
            selfchk[currentstr.charAt(i) -'a'] = 1;
         }
         for(int i =0; i< currentstr.length(); i++){
             if(selected[currentstr.charAt(i) -'a'] ==1 ) return false;
         }
         return true;
  
    }
    public static int solve(int index ,List<String> arr, int[] selected , int len){
        if(index >= arr.size()){
            return len;
        }
        String currentstr = arr.get(index);
        if(compare(selected , currentstr ) == false){
            return solve(index +1, arr, selected,len);
        }    
        else{
          
           for(int i =0; i < currentstr.length(); i++){
              selected[currentstr.charAt(i) -'a'] = 1;
           }
            len += currentstr.length();
            int opt1 =  solve(index +1, arr, selected,len);
           //skip and backtrack
           for(int i =0; i < currentstr.length(); i++){
               selected[currentstr.charAt(i) -'a'] = 0;
           }
              len -= currentstr.length();
           //opt2
           int opt2 =  solve(index +1, arr, selected,len);
           return Math.max(opt1,opt2);
        }
        
    }
}
