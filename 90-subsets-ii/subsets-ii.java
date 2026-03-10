class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

      List<List<Integer>> res = new ArrayList<>();
      List<Integer> current  = new ArrayList<>();
      Arrays.sort(nums);

      sub(nums,res,0,current);

      return res;
        
    }

    private void sub(int[] nums , List<List<Integer>> res , int indx, List<Integer> current ){

    res.add(new ArrayList<Integer>(current));

    for(int i = indx; i<nums.length ; i++)
    {
        //Skipping Duplicates 
        if(i> indx && nums[i] == nums[i-1])
        {
            continue;
        }
      current.add(nums[i]);
      sub(nums,res,i+1, current);
      current . remove (current.size()-1);
      //sub(nums,res,i+1,current);
    }
    }
}

