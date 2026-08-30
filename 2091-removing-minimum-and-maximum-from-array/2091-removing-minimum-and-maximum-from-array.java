class Solution {
    public int minimumDeletions(int[] nums) {
        int min = 0;
        int max = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[max]){
                max = i;
            }
            if(nums[i] < nums[min]){
                min = i;
            }
        }

        if(max < min){
            int temp = min;
            min = max;
            max = temp;
        }

        int ans = 0;
        int i = 0;
        int j = nums.length-1;
        int last = -1;

        if(min == max) return 1;

        if(min - i < j - max){
            ans += min + 1;
            i = min + 1;
            last = max;
        } else{
            ans += (j-max) + 1;
            j = max - 1;
            last = min;
        }
        if(last - i < j - last){
            ans += last - i + 1;
        } else{
            ans += j - last + 1;
        }
        return ans;

        
    }
}