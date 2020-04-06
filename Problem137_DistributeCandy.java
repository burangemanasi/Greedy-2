//Time Complexity: O(2n) ~ O(n)
//Space Complexity: O(n)

class Solution {
    public int candy(int[] ratings) {
        //base case
        if(ratings == null || ratings.length == 0)
            return 0;
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);
        //pass1 -> looking into left neighbors
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        //pass2 -> looking into right neighbors
        for(int i = n-2; i>= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i+1] + 1, candies[i]);
            }
        }
        //sum of all candy's in candies array
        int sum=0;
        for(int candy : candies){
            sum = sum + candy;
        }
        return sum;
    }
}