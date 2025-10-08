class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer,Integer> map= new HashMap<>();
        TreeSet<Integer> st= new TreeSet<>();
        int[] ans= new int[rains.length];
        Arrays.fill(ans,1);
        for(int i=0;i<rains.length;i++){
            if(rains[i]==0){
                st.add(i);
            }
            else{
                ans[i]=-1;
                if(map.containsKey(rains[i])){
                    Integer idx = st.ceiling(map.get(rains[i]));
                    if(idx==null){
                        return new int[0];
                    }
                    ans[idx]=rains[i];
                    st.remove(idx);
                }
                map.put(rains[i],i);

            }
        }
        return ans;
    }
}