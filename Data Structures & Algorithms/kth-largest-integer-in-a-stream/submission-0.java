class KthLargest {

    private PriorityQueue<Integer> pq;
    int k;   // size of the pq

    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue();

        for(int num: nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if(pq.size()<k){
            pq.offer(val);  // case when the value of pq means just 3 elements from array are added
        }else if(val > pq.peek()){
            pq.poll(); // removes the top most elemtent i.e kth largest element
            pq.offer(val); // adds the new element in the heap
        }
        return pq.peek();
    }
}
