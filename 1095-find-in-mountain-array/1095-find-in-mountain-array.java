/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int B, MountainArray A) {
        int n = A.length();
        int maxPosition = -1;
        int left = 1;
        int right = n-2;
        int mid;
        while(left<right){
            mid = left + (right-left)/2;
            if(A.get(mid)<A.get(mid+1)){
                left = mid +1;
            }else{
                right = mid;
            }
            
        }
        maxPosition = left;
        left = 0;right = maxPosition;
        int me;
        while (left<=right){
            mid = left +(right-left)/2;
            me = A.get(mid);
            if(me==B) return mid;
            if(me>B) right = mid-1;
            else left = mid+1;
        }
        left = maxPosition; right = n-1;
        while (left<=right){
            
            mid = left +(right-left)/2;
            me = A.get(mid);
            if(me==B) return mid;
            if(me<B) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
}