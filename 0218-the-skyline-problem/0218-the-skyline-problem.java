class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();

	for (int[] building : buildings) {
		heights.add(new int[] { building[0], -building[2] }); 
		heights.add(new int[] { building[1], building[2] });
	}

	Collections.sort(heights, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
	List<List<Integer>> result = new ArrayList<>();

	TreeMap<Integer, Integer> treeMap = new TreeMap<>();
	treeMap.put(0, 1);

	int maxHeight = 0;

	for (int[] height: heights) {
		if (height[1] < 0) {
			treeMap.put(-height[1], treeMap.getOrDefault(-height[1], 0) + 1);
		} else {
			treeMap.put(height[1], treeMap.get(height[1]) - 1);
			if(treeMap.get(height[1]) == 0) 
				treeMap.remove(height[1]);
		}
		
		int currMaxHeight = treeMap.lastKey();

		if (currMaxHeight != maxHeight) {
			result.add(List.of(height[0], currMaxHeight));
			maxHeight = currMaxHeight;
		}
	}

	return result;
    }
}