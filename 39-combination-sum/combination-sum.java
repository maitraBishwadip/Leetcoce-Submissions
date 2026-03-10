class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> candidate = new ArrayList<>();
       

        helper(0,target,nums,candidate,res);
        return res ;
        
    }

    private void helper(int index , int target, int[] nums , List<Integer> candidate, List<List<Integer>> res){

    if(target == 0)
    {
        res.add(new ArrayList<>(candidate));
    }else if(target < 0)
    {
        return ; 
    }

    for (int i= index ; i<nums.length; i++)
    {
        candidate.add(nums[i]);
        helper(i, target - nums[i],nums,candidate,res);
        candidate.remove(candidate.size()-1);

    }

    }

}
