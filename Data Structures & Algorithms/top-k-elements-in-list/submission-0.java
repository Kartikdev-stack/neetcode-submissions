class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        List<Integer>[] bucket=new List[nums.length+1];

        for(int num: nums){
            hm.put(num,hm.getOrDefault(num,0)+1); // loggingn frequencies in map
        }

        for(int key: hm.keySet()){
            int frequency=hm.get(key); // get the frequency of the current key
            if(bucket[frequency]==null){
                bucket[frequency]=new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        // now we build the result array
        int[] result=new int[k]; 
        int counter=0;  

        for(int pos=bucket.length-1;pos>=0 && counter<k;pos--){
            if(bucket[pos]!=null){
                for(Integer integer: bucket[pos]){  // considering each value inside the individual lists in the array
                     result[counter++]=integer;
                }
            }
        }
        return result;
    }
}
