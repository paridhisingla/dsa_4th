import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort by end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // At least one arrow needed
        long arrowPos = points[0][1]; // Use long to avoid int overflow

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPos) {
                // Need a new arrow
                arrows++;
                arrowPos = points[i][1];
            }
            // else: current balloon bursts with existing arrow
        }

        return arrows;
    }
}
