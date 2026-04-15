class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack=new Stack<>();
        List<int[]> car_map=new ArrayList<>();

        for(int i=0;i<position.length;i++){
            car_map.add(new int[]{position[i], speed[i]}); // adding the elements in the list array
        }

        car_map.sort((a,b)-> b[0] - a[0]);

        for(int[] car: car_map){
            double time=(double) (target - car[0])/ car[1] ;

            if(stack.isEmpty() || time > stack.peek()){
                stack.push(time);
            }   


        }
        
        return stack.size();
    }
}
