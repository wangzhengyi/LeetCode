import java.util.HashMap;

public class MaxPointsOnaLine {
    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    public static int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int max = 0;

        HashMap<Double, Integer> collectMap = new HashMap<Double, Integer>();
        
        for (int i = 0; i < points.length; i++) {
            collectMap.clear();
            int duplicate = 1;
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicate ++;
                    continue;
                }
                double k = points[i].x == points[j].x ? Integer.MAX_VALUE : (1.0 * (points[j].y - points[i].y)) / (points[j].x - points[i].x);
                if (collectMap.get(k) != null) {
                    collectMap.put(k, collectMap.get(k) + 1);
                } else {
                    collectMap.put(k, 1);
                }
            }
            
            if (duplicate > max) {
                max = duplicate;
            }
            
            for (Integer num : collectMap.values()) {
                if (num + duplicate > max) {
                    max = num + duplicate;
                }
            }
        }

        return max;
    }
}
