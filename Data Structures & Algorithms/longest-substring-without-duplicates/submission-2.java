class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Brute Force Approach
        int longestSS=0; // initialised to 0
        for(int i=0;i<s.length();i++){
            Set<Character> set=new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
            }
            longestSS=Math.max(longestSS,set.size());
        }
        return longestSS;
    }
}
