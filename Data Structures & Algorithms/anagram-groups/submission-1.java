class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length==0){
            return new ArrayList<>();  // return empty arraylist
        }

        HashMap<String, List<String>> map=new HashMap<>();
        for(String s: strs){
            char[] characters=s.toCharArray();
            Arrays.sort(characters);
            String sorted=new String(characters);

            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>()); // setting the key as the sorted string
            }

            map.get(sorted).add(s); // we access the list(value) whose key is sorted and then add the string s to it

        }
        return new ArrayList<>(map.values());
    }
}
