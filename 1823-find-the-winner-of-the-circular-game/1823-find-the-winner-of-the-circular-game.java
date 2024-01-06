class Solution {
     public int findTheWinner(int n, int k) {
        return findTheWinner0Based(n, k)+1;
    }
    
    public int findTheWinner0Based(int n, int k) {
        if(n == 1) {
            return 0;
        } else {
            return (findTheWinner0Based(n - 1, k) + k) % n;
        }
    }
}