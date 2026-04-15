class Solution {
    public int characterReplacement(String s, int k) {
        int[] character=new int[26]; // represents all the 26 characters
        int maxFreq=0; // maximmum frequency for a character
        int left=0;
        int windowSize=0;   // max window size till current character

        for(int right=0;right<s.length();right++){
            
            character[s.charAt(right)-'A']++;  // increment the frequency for the particular character
            
            int windowLength=right-left+1;

            maxFreq=Math.max(maxFreq,character[s.charAt(right)-'A']);  // calculating the max frequency

            if(windowLength-maxFreq>k){
                character[s.charAt(left)-'A']--;
                left++;
            }


            windowSize=Math.max(windowSize, right-left+1);
        }
        
        return windowSize;
    }
}
