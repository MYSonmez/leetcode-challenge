package easy;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        int[] lengthArr = new int[strs.length];
        int i = 0;
        for (String str : strs) {
            lengthArr[i] = str.length();
            i++;
        }

        int minLength = Integer.MAX_VALUE;
        int j = 0;
        int minLindex = 0;
        for (int length : lengthArr) {
            if (length < minLength) {
                minLindex = j;
                minLength = length;
            }
            j++;
        }

        String shortestStr = strs[minLindex];
        if (minLength == 0) {
            return "";
        }
        for (int k = 0; k < shortestStr.length(); k++) {
            char c = shortestStr.charAt(k);
            for (String str : strs) {
                if (c != str.charAt(k)) {
                    return shortestStr.substring(0, k);
                }
            }
        }
        return shortestStr;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
