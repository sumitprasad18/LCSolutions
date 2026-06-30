class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0;i < n; i ++){
            //step1 sum create
             sum = sum + nums[i];
            //step2 maxi update
            maxi = Math.max(maxi,sum);
            //step3 sum check krte hai for negative value
                if(sum<0){
                    sum =0;
                }
            }
            //retrn max value
        return maxi;
    }
}