class Solution {
    public int leastInterval(char[] tasks, int n) {
        // first we count the frequencies of each letter

        int[] count=new int[26];
        for(char task: tasks){
            count[task-'A']++; // we log the freq of each letter
        }

        // now lets define a max heap and dummp everything there

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt: count){
            if(cnt>0)
                maxHeap.add(cnt);
        }

        int time=0;
        Queue<int[]> q = new LinkedList<>();
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(maxHeap.isEmpty()){
                time=q.peek()[1];
            }else{
                int cnt=maxHeap.poll()-1;
                if(cnt>0){
                    q.add(new int[]{cnt,time+n});
                }
            }
            if(!q.isEmpty() && q.peek()[1]==time){
                maxHeap.add(q.poll()[0]);
            }

        }
        return time;
    }
}
