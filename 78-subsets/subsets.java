class Solution {
    public List<List<Integer>> subsets(int[] nums) {

          List<Integer> current = new ArrayList<>();
          List<List<Integer>> result = new ArrayList<>();

        subset(0, current ,  result,nums);

        return result;
        
    }

   public void subset(int index , List<Integer> current , List<List<Integer>> res, int[] nums)
    {
         res.add(new ArrayList<>(current) );

         for(int i = index; i< nums.length; i++)
         {
            current.add(nums[i]);
            subset(i+1,current,res, nums);
            current.remove(current.size()-1);
            
         }
    }
}
