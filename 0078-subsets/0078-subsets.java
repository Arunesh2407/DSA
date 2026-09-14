class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int i = 0; i < arr.length; i++){
            int n  =  outer.size();
            for(int j = 0; j < n; j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}