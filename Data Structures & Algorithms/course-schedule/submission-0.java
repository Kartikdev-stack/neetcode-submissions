class Solution {
    private Map<Integer, List<Integer>> preMap=new HashMap<>(); 
    private Set<Integer> visiting=new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            preMap.put(i,new ArrayList<>()); // added individual courses in the map with each associated empty list of prereq 
        }
    
        for(int[] prerequisite: prerequisites){
            preMap.get(prerequisite[0]).add(prerequisite[1]); // mapped the prereq courses to each course
        }

        for(int c=0;c<numCourses;c++){
            // cycle detection
            if(!dfs(c)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int crs){
        if(visiting.contains(crs)){
            return false;
        }

        if(preMap.get(crs).isEmpty()){
            return true;
        }

        visiting.add(crs);

        for(int pre: preMap.get(crs)){
            if(!dfs(pre)){
                return false;
            }
        }

        visiting.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;

    }

}
