class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList<>();
        backtrack(n,0, 0, "", result);
        return result;
    }
    public void backtrack(int n , int open , int closed, String current, List<String> result){
        if(current.length()==2*n){
            result.add(current);
            return;
        }
    if(open<n){
        backtrack(n, open+1, closed, current+'(', result);


    }
    if(closed<open){
         backtrack(n, open, closed+1, current+')', result);

    }
    }
}