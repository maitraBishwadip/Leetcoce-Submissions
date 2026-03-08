class Solution {

    public void helper(int[] nums , List<Integer> current , int index, List<List<Integer>> res)
    {
        if(index >= nums.length)
        {
          res.add(new ArrayList<>(current));
            return ;
        }

     current.add(nums[index]);
     helper(nums,current,index+1,res);
      current.remove(current.size()-1);

     helper(nums,current,index+1, res);
    }
    public List<List<Integer>> subsets(int[] nums) {




        

        List<Integer> current = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        helper(nums,current,0,res);

        return res;
        
    }
}