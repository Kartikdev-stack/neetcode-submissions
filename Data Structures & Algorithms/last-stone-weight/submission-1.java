class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>( (a,b) -> b-a );  // defining the maxHeap
        for(int stone: stones){
            pq.add(stone); // adding stones one by one
        }        

        while(pq.size()!=1){ // if the total elements are not equal to 1

            int y=pq.remove(); // getting the maximum element
            int x=pq.remove(); // getting the second max element

            if((x!=y) || (x==y && pq.size()==0)){
                pq.add(y-x); // adding the difference if they are not equal
            }
        }
        
       return pq.peek();  // retrieving the last remaining element      

    }
}
