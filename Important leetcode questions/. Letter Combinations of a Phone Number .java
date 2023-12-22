class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        int index =0;
        if(digits.length()==0){
            return ans;
        }
        String[] mapping ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(digits,output,ans,index,mapping);
        return ans;

    }
    public static void solve(String digits,StringBuilder output,List<String> ans,int index,String[] mapping){
        //how many of digits are there in string digits
        if(index>= digits.length()){
            ans.add(output.toString());
            return;
        }
        //accessing the digits i.e 2
        int number = digits.charAt(index) - '0';
        String value = mapping[number];
        
           
         //accessing each char of the digit in String digits i,e chars linked with 2 
         for(int i =0; i< value.length();i++){
             output.append(value.charAt(i));//add char and than call so, we can make the relations i.e a,d >> a,e >> a,f
             solve(digits,output,ans,index +1,mapping);
             output.deleteCharAt(output.length() -1);// remove the char added i.e a,d >>remove d >> so we can make >> a,e
         }

    }
}
