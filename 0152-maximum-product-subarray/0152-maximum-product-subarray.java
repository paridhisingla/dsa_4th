class Solution {
    public int maxProduct(int[] nums) {
        int minpro=nums[0];
        int maxpro=nums[0];
        int result=nums[0];
        for(int i=1;i<nums.length; i++){
            int curr=nums[i];
            int tempmax=Math.max(curr, Math.max(minpro*curr, maxpro*curr));
            minpro=Math.min(curr, Math.min(minpro*curr, maxpro*curr));
            maxpro=tempmax;
            result=Math.max(result, maxpro);

        }
        return result;
    }
}