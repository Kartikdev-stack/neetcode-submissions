class Solution {
    public boolean isPalindrome(String s) {

        if(s.length()==1 || s.length()==0){
            return true;
        }

        int start=0;
        int end=s.length()-1;

        while(start<end){
            while(start<end && !isAlphanumeric(s.charAt(start)))
                start++;
           while(start<end && !isAlphanumeric(s.charAt(end)))
                end--;
            if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

public boolean isAlphanumeric(Character c){
        if((c>='A' && c<='Z')  || (c>='a' && c<='z') || (c>='0' && c<='9')){
            return true;
        }
        return false;
}
}

