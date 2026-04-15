class Solution {
    public boolean isPalindrome(String s) {

        if(s.length()==1 || s.length()==0){
            return true;
        }


        // setting the two pointers


         


        int left=0;
        int right=s.length()-1;

        while(left<right){

          // skipping all the alphanumeric character

           while(left<right && !isAlphanumeric(s.charAt(left))){
                left++;
           }

           while(left<right && !isAlphanumeric(s.charAt(right))){
                right--;
           }

           if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
           }

           left++;
           right--;

        }
       return true;         
    
    }

    public boolean isAlphanumeric(Character c){
             if(c>='A' && c<='Z' || c>='a' && c<='z' || (c>='0' && c<='9')){
                return true;
             }
             
            return false;
    }

}
