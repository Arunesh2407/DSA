class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                list.add(i);
            }
        }
        if(list.size() < k) return "";
        String ans = s;
        int left = 0;
        int right = k-1;
        while(right != list.size()){
            if(list.get(right) - list.get(left) + 1 < ans.length()){
                ans = s.substring(list.get(left), list.get(right) + 1);
            } else if( list.get(right) - list.get(left) + 1 == ans.length()){
                ans = check(ans, s.substring(list.get(left), list.get(right) + 1));
            }
            right++;
            left++;
        }
        return ans;
    }

    public String check(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return s1;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return s2;
            }
        }
        return s1;
    }
}