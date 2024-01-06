class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));
        
        // Calculate the distance between the closest point and the center of the circle
        int distanceX = xCenter - closestX;
        int distanceY = yCenter - closestY;
        
        // Calculate the squared distance
        int squaredDistance = distanceX * distanceX + distanceY * distanceY;
        
        // Compare the squared distance with the squared radius
        return squaredDistance <= radius * radius;
    }
}