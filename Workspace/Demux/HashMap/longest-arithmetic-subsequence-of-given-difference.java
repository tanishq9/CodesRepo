class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=1;
        // dp[i] tells what will be the longest sequence of -2 ENDING at index i
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]-difference)){
                map.put(arr[i],map.get(arr[i]-difference)+1);
            }else{
                map.put(arr[i],1);                
            }
            max=Math.max(max,map.get(arr[i]));
        }
        return max;
    }
}