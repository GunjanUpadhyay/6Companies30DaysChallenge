class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> cinemaSeats = new HashMap<>();
        for (int[] reserved: reservedSeats) {
            int row = reserved[0] - 1, col = reserved[1];
            cinemaSeats.put(row, setBit(cinemaSeats.getOrDefault(row, 0), 10 - col));
        }
        int numFamilies = 0;
        int leftAisle = 480, rightAisle = 30, middleAisle = 120;
        for (int row: cinemaSeats.values()) {
            row = ~(row) & ((1 << 10) - 1);
            if(((row & (leftAisle | rightAisle)) ^ (leftAisle | rightAisle)) == 0) numFamilies += 2;
            else if(((row & leftAisle) ^ leftAisle) == 0 ||
                    ((row & rightAisle) ^ rightAisle) == 0 ||
                    ((row & middleAisle) ^ middleAisle) == 0)
                numFamilies++;
        }
        return numFamilies + 2 * (n - cinemaSeats.keySet().size());
    }

    private int setBit(int cinemaSeat, int i) { return cinemaSeat | (1 << i); }
}