class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         
       List<Integer> current = new ArrayList<>();
       List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        helper(0, candidates, target , current,res);
        return res;
        
    }


    void helper(int index , int[] candidates , int target, List<Integer> current , List<List<Integer>> res)
    {
      if(target ==0){
        res.add(new ArrayList<>(current));
        return;

      }else if (target < 0)
      {
        return;
      } 

       
     
      for(int i = index ; i<candidates.length; i++){

         if(i >index && candidates[i]== candidates[i-1])
      {
        continue;
      }


      current.add(candidates[i]);
      helper(i+1, candidates, target-candidates[i], current, res);
      current.remove(current.size()-1);
      }
    }
}
