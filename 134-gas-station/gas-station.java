class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int totalgas=0;
        int totalcost=0;
        for(int i=0; i<n; i++){
            totalgas+=gas[i];
            totalcost+=cost[i];
        }
        if(totalcost>totalgas) return -1;
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