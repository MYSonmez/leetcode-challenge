package medium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * QUESTION:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a
 * given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * @author m.yusufsonmez03@gmail.com
 */
public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        int length = s.length();

        if (numRows == 1 || numRows >= length) {
            return s;
        }

        LinkedHashMap<Integer, Integer> charDict = new LinkedHashMap<>();
        int row = 1;
        int i = 0;
        boolean goingDown = true;
        while (i < length) {
            charDict.put(i, row);

            if (row == numRows) {
                goingDown = false;
            } else if (row == 1) {
                goingDown = true;
            }

            row = goingDown ? row + 1 : row - 1;
            i++;
        }
        StringBuilder builder = new StringBuilder();
        ArrayList<ArrayList<Character>> letterArrayList = new ArrayList<>(numRows);

        for (int j = 0; j < numRows; j++) {
            letterArrayList.add(new ArrayList<Character>());
        }

        for (Map.Entry<Integer, Integer> entry : charDict.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            letterArrayList.get(value - 1).add(s.charAt(key));
        }
        for (ArrayList<Character> innterArrayList : letterArrayList) {
            for (Character character : innterArrayList) {
                builder.append(character);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);

    }
}
