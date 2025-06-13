package blind75;

public class ContainsWithMostWater {
    public int maxArea(int[] height) {
        int mostWater = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int minHeight = Math.min(height[start], height[end]);
            int area = (end - start) * minHeight;
            mostWater = Math.max(area, mostWater);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return mostWater;
    }
}
