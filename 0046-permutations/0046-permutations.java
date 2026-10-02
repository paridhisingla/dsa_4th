class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        boolean[] visited= new boolean[nums.length];

        backtrack(nums, new ArrayList<>(), result, visited);
        return result;
    }
    public void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] visited){
        if(nums.length== current.size()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(visited[i]) continue;
            visited[i]=true;
            current.add(nums[i]);
            backtrack(nums, current, result, visited);
            current.remove(current.size()-1);
            visited[i]=false;
        }
    }
}