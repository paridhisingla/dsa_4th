class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int expecteds=n*(n+1)/2;
        int actuals=0;
        for(int value:nums){
            actuals+=value;
        }
        return expecteds-actuals; 
    }
}