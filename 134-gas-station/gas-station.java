class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int totalg=0;
        int totalc=0;
        for(int i=0; i<n; i++){
            totalg+=gas[i];
            totalc+=cost[i];
        }
        if(totalc>totalg) return -1;
        int sum=0;
        int pos=0;
        for(int i=0; i<n; i++){
            sum+=gas[i]-cost[i];
            if(sum<0){
                sum=0;
                pos=i+1;
            }
        }
        return pos;
    }
}