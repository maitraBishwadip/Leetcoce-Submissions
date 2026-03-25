class Solution {
    public int climbStairs(int n) {

        if(n == 0) return 1;
        if(n == 1) return 1;

        //Storing previous values 
        int prev1 = 1;
        int prev2 = 1;

        for(int i = 2 ; i<= n ; i++ )

        {
            int current = prev1 +prev2 ; //number of ways to reach the current step
            prev2 = prev1; // updating the previous values 
            prev1 = current;
        }

        // the last current is stored in prev1
        return prev1;

        //the problem is solved from a small base case to the bigger problems using a bottom up approach it is a 
    //tabulation DP method
        
    }
}