class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 1 ; i<=9 ;i++)
        {
            queue.add(i);
        }

        int level = 1;

        while(!queue.isEmpty() && level < n )
        {
            level++;
            int size = queue.size();

            for(int i =0; i<size; i++)
            {
                int element = queue.pop();
                int lastDigit = element%10;
                if(lastDigit+k <= 9) queue.add(element*10+lastDigit+k);
                if(lastDigit-k >= 0 && k!=0) queue.add(element*10+lastDigit-k);
            }
        }
        while(!queue.isEmpty())
        {
            res.add(queue.pop());
        }
         int[] result = new int[res.size()];

         for(int i =0 ; i<result.length; i++)
         {
            result[i] = res.get(i);
         }
         return result;
        
        
    }
}