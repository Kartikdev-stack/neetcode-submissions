class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);  // Defining a max heap


        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]); // Inserting elements of arrray into heap
        }


        while(pq.size()>1){
            int y=pq.remove(); // getting the first largest element
            int x=pq.remove(); // getting the second largest element

            if(x<y){
                 pq.add(y-x); // adding the difference
            }
        }

        if(pq.size()==1){
            return pq.peek();
        }

        return 0;
    }
}
