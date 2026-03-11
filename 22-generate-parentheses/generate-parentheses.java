class Solution {
    public List<String> generateParenthesis(int n) {
        String current = "";
        int opernParan = 0;
        int  closedParan = 0;

        List<String>result = new ArrayList<>();

        helper("",0,0,n,result);

        return result;
        
    }

    void helper(String current , int open , int closed , int n ,
                       List<String>result )
    {
        if(open == n && closed == n)
        {
            result.add(current);
            return ;
        }

        //Adding new open bracket
        if(open< n)
        {
            helper(current + "(", open+1 , closed , n , result);
        }

        //Adding       closed Bracket 

        if(closed < open)
        {
            helper(current + ")", open, closed+1 , n , result);
        }
    }                   

                      
}
