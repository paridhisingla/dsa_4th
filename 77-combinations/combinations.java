class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result= new ArrayList<>();
        backtrack(n, k, 1, result, new ArrayList<>());
        return result;
    }
    public void backtrack(int n, int k, int index, List<List<Integer>> result, List<Integer> current){
        if(current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=index; i<=n-(k-current.size())+1; i++){
            current.add(i);
            backtrack(n, k, i+1, result, current);
            current.remove(current.size()-1);
        }
    }
}