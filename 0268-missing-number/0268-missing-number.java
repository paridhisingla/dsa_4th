class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int es=n*(n+1)/2;
        int as=0;
        for(int value: nums){
            as+=value;
        }
        return es-as;
    }
}