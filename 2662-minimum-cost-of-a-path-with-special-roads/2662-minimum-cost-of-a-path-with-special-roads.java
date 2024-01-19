class Solution {
    record Point(int x, int y) {}
    private int manhattenDistance(Point a, Point b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
         Point st = new Point(start[0], start[1]), ed = new Point(target[0], target[1]);
        Map<Point, Integer> map = new HashMap<>();
        Queue<Point> que = new PriorityQueue<>((a, b) -> Integer.compare(map.get(a), map.get(b)));
        map.put(st, 0);
        que.offer(st);
        int res = manhattenDistance(st, ed);
        while(!que.isEmpty()){
            Point cur = que.poll();
            int curCost = map.get(cur);
            res = Math.min(res, curCost + manhattenDistance(cur, ed));
            if(cur == ed) return res;
            for(int[] road: specialRoads){
                Point s = new Point(road[0], road[1]);
                Point e = new Point(road[2], road[3]);
                int cost = Math.min(road[4], manhattenDistance(s, e)) + manhattenDistance(cur, s) + curCost;
                if(cost >= res || cost >= map.getOrDefault(e, Integer.MAX_VALUE)) continue;
                map.put(e, cost);
                que.offer(e);
            }
        }
        return res;
    }
}