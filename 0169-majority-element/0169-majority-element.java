class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int candi=0;
        for(int i=0; i<nums.length; i++){
            if(count==0) candi=nums[i];
            if(nums[i]==candi) count++;
            else count--;
        }
        return candi;
    }
}