package twopointers;

public class DutchNationalFlag {
    public static int[] sortColors(int[] colors) {
        int start = 0, current = 0, end = colors.length - 1;

        while (current <= end) {
            if (colors[current] == 0) {
                int temp = colors[current];
                colors[current] = colors[start];
                colors[start] = temp;
                start++;
                current++;
            }
            else if (colors[current] == 1) {
                current++;
            }
            else {
                int temp = colors[current];
                colors[current] = colors[end];
                colors[end] = temp;

                end--;  // Don't move `current` because swapped value needs to be checked
            }
        }
        return colors;
    }

}
