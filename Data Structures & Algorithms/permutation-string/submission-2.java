class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // lets compare the 2 strings first baased on length
        if(s1.length()>s2.length()){
            return false;
        }

        // defining the hashmap for s1

        HashMap<Character,Integer> s1_map=new HashMap<>();
        for(char c : s1.toCharArray()){
             s1_map.put(c,s1_map.getOrDefault(c,0)+1);
        }

        HashMap<Character,Integer> s2_map=new HashMap<>();
        for(int i=0;i<s2.length();i++){
            char chAdd=s2.charAt(i);
            s2_map.put(chAdd,s2_map.getOrDefault(chAdd,0)+1);


            // we will maintain the length of s2 hashmap only upto the  length s1
            if(i>=s1.length()){
                char charRem=s2.charAt(i-s1.length());
                if(s2_map.get(charRem)==1){
                    s2_map.remove(charRem);
                }else{
                    s2_map.put(charRem, s2_map.get(charRem)-1);
                }
            }


            if(s1_map.equals(s2_map)){
                return true;        // if the maps are equal
            }
        }

        return false;
    }
}
