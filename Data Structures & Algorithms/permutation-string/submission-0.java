class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }

        char[] s1_array=s1.toCharArray();
        Arrays.sort(s1_array);
        String s1_sorted=new String(s1_array); // sorted array of s1

        for(int i=0;i<=s2.length()-s1.length();i++){
            String ss=s2.substring(i,i+s1.length());
            char[] ss_array= ss.toCharArray();
            Arrays.sort(ss_array);
            String ss_sorted=new String(ss_array); // sorted substring in s2


            if(s1_sorted.compareTo(ss_sorted)==0){
                return true;
            }
        }
       return false;
    }
}
