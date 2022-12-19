package spreadsheet;

import java.util.HashMap;
import java.util.Map;

public class SpreadSheetDemo {

    /**
     * Example:
     * setCellValue("A1", 13)
     * setCellValue("A2", 14)
     * getCellValue("A1") -> 13
     * setCellValue("A3", "=A1+A2")
     * getCellValue("A3") -> 27
     * setCellValue("A4", "=A1+A2+A3")
     * getCellValue("A3") -> 54
     *
     */
    static Map<String, Integer> map = new HashMap<>();

    /**
     * Main method to run program
     */

    public static void main(String[] args) {
        setCellValue("A1", 13);
        setCellValue("A2", 14);
        System.out.println("A1::" + getCellValue("A1"));
        System.out.println("A2::" + getCellValue("A2"));
        System.out.println("A3::" + getCellValue("A3"));//A1+A2
        System.out.println("A4::" + getCellValue("A4"));//A1+A2+A3
        System.out.println("A5::" + getCellValue("A5"));//A1+A2+A3+A4
        System.out.println("A6::" + getCellValue("A6"));//A1+A2+A3+A4+A5
        System.out.println("A3::" + getCellValue("A3"));//A1+A2
    }

    /**
     * set values to map
     * @param cellId
     * @param value
     */
    static void setCellValue(String cellId, int value) {
        map.put(cellId, value);
    }

    /**
     * get values from map
     * @param cellId
     * @return
     */
    static int getCellValue(String cellId) {
        map.putIfAbsent(cellId, sumOfCells(map));
        return map.get(cellId);
    }

    /**
     * sum of all the values in map
     * @param map
     * @return
     */
    static int sumOfCells(Map<String, Integer> map) {
        return map.values().stream().mapToInt(Integer::intValue).sum();
    }
}
//map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))
