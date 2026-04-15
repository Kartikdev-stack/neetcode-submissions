class TimeMap {

    Map<String, List<String>> valueMap;
    Map<String, List<Integer>> timeStampMap;

    public TimeMap() {
        valueMap=new HashMap<>();
        timeStampMap=new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        if(!valueMap.containsKey(key)) {
            valueMap.put(key, new ArrayList<>());
            timeStampMap.put(key, new ArrayList<>());
        }
        valueMap.get(key).add(value);
        timeStampMap.get(key).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        
        List<Integer> timestamps=timeStampMap.get(key);

        if(!timeStampMap.containsKey(key)){
            return "";
        }

        int left=0;
        int right=timestamps.size()-1;
        String result="";
        

        while(left<=right){
            int mid=left+(right-left)/2;
            if(timestamps.get(mid) <= timestamp){
                result=valueMap.get(key).get(mid);
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        return result;
    }
}
