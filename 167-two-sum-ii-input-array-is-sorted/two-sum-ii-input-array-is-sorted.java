class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int[] res=new int[2];
        int i=0;
         int j=n-1;
        while(i<j){
            int f=numbers[i];
            int b=numbers[j];
            if(f+b==target){
                res[0]=i+1;
                res[1]=j+1;
                break;
            }
            else if(f+b<target) i++;
            else j--; 
        }
        return res;
    }
}