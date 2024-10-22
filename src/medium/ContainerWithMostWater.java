package medium;

/**
 * QUESTION: 
 * You are given an integer array height of length n. There are n
 * vertical lines drawn such that the two endpoints of the ith line are (i, 0)
 * and (i, height[i]). Find two lines that together with the x-axis form a
 * container, such that the container contains the most water. Return the
 * maximum amount of water a container can store. Notice that you may not slant
 * the container.
 *
 * @author m.yusufsonmez03@gmail.com
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int waterAmount = 0;
        int maxWaterAmount = 0;
        int waterHeight = 0;
        int floorLength = 0;

        while (right > left) {
            floorLength = right - left;
            waterHeight = Math.min(height[left], height[right]);
            waterAmount = floorLength * waterHeight;
            maxWaterAmount = Math.max(maxWaterAmount, waterAmount);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxWaterAmount;
    }

    public static void main(String[] args) {
        maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

}
