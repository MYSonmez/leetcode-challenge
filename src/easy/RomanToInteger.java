package easy;

public class RomanToInteger {

    public static int romanToInt(String s) {
        int[] values = new int[128];
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        int result = 0;
        int i = 0;

        if (s.length() > 1) {
            for (i = s.length() - 1; i > 0; i--) {
                int preCharValue = values[s.charAt(i - 1)];
                int currentCharValue = values[s.charAt(i)];
                if (currentCharValue == 5 * preCharValue) {
                    result += 4 * preCharValue;
                    i--;
                } else if (currentCharValue == 10 * preCharValue) {
                    result += 9 * preCharValue;
                    i--;
                } else {
                    result += currentCharValue;
                }
            }
        }

        if (i == 0) {
            result += values[s.charAt(i)];
        }
        return result;
    }

    public static void main(String[] args) {
        romanToInt("LVIII");
    }
}
