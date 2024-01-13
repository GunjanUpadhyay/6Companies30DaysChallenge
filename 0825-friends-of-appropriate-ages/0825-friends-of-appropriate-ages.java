class Solution {
    public int numFriendRequests(int[] ages) {
        int map[]=new int[121];
        for(int j=0;j<ages.length;j++){
            map[ages[j]]++;
        }

        for(int i=1;i<=120;i++){
            map[i]+=map[i-1];
        }
        int totalFriend=0;
        for(int i=0;i<ages.length;i++){
            int cond=ages[i]/2+7;
            if(cond>=ages[i]){
                continue;
            }
            totalFriend+=map[ages[i]]-map[cond]-1;
        }
        return totalFriend;
    }
}