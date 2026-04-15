class Solution {
    public int lengthOfLongestSubstring(String s) {
        //  Sliding Window Approach
        int start=0; // starting of the window
        int maxLength=0; // initialising the max window size

        Set<Character> set=new HashSet<>();
        for(int end=0;end<s.length();end++){
            while(set.contains(s.charAt(end))){
               set.remove(s.charAt(start));
               start++;
            }

            set.add(s.charAt(end));
            maxLength=Math.max(maxLength,set.size());
        }
       
      return maxLength;  
    }
}
