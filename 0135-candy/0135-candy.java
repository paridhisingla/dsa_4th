class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int up=0, down=0,peak=0,res=1;
        for(int i=1; i<n; i++){
            int prev=ratings[i-1];
            int curr=ratings[i];
            if(prev<curr){
                up++;
                down=0;
                res+=1+up;
                peak=up;
            }
            else if(prev==curr){
                up=0;
                down=0;
                res+=1;
                peak=0;
            }
                else {
                up=0;
                down++;
                res+=1+down;
                if(peak>=down) res--;
            }
        }
        return res;
    }
}