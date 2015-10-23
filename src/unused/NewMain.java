package unused;

import java.util.ArrayList;

/**
 *
 * @author endbr
 */
public class NewMain {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int columns = 32;
        int rows = 23;

        for (int x = 0; x < columns; x++) {
            list.add(new ArrayList<>());
            for (int y = 0; y < rows; y++) {
                int position = (columns - x - 1);
                position += ((rows - y - 1) * (columns));
                list.get(x).add(position);
            }
        }

        int count = 0;
        for (int y = rows - 1; y >= 0; y--) {
            for (int x = columns - 1; x >= 0; x--) {
                System.out.println("(" + x + ", " + y + ") " + list.get(x).get(y));
                count++;
            }
            System.out.println("-------------------------------------------");
        }
        System.out.println(rows * columns);
        System.out.println(count);
    }

}
