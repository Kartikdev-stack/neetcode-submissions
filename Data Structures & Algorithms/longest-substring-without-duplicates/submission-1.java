class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr=s.toCharArray();
        HashSet<Character> hs=new HashSet<>();
        int left=0; // initialize the left pointer
        int max=0; // let max be initially 0 say when string is empty

        for(int right=0;right<arr.length;right++){
            char current=arr[right];
            
            while(!hs.add(current)){
                hs.remove(arr[left]);
                left++;
            }

            hs.add(current);
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
