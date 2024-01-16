class Solution {
    public int longestString(int x, int y, int z) {
        int xy = 2 * Math.min(x, y);
        if (x != y) {
            ++xy;
        }
        return 2 * (xy + z);
    }
}