class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.isEmpty()){
            return new ArrayList<>();
        }

        String[] letters={ "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Map<Character,String> hm=new HashMap<>();
        for(int i=0;i<letters.length;i++){
            hm.put((char)('2'+i),letters[i]);
        }



        List<String> result=new ArrayList<>();
        backtrack(digits, 0, hm, new StringBuilder(),result);
        return result;
    }

    public void backtrack(String digits, int idx, Map<Character, String> hm, StringBuilder path, List<String> result){
        
        // Base Case
        if(idx==digits.length()){
            result.add(path.toString());
            return;
        }

        char digit=digits.charAt(idx);
        String list=hm.get(digit);

        for(int j=0;j<list.length();j++){
            
            char ch=list.charAt(j);

            path.append(ch);  // add the first char associated with first digit to the path

            backtrack(digits, idx+1, hm,  path, result);

            path.deleteCharAt(path.length()-1);
        }

    }
}
