class Solution {
    public boolean canJump(int[] nums) {
        int goal=0;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]+i>=goal) goal=i;


        }
        if(goal==0) return true;
        return false;
    }
}