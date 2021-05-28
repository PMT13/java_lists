public class Second {
    private String blank;
    public String selectionSortRecursive(int[] array, int first, int length) {
        if (length == 0) {
            blank = "";
            for (int i = 0; i < array.length; i++) {
                blank += " " + array[i] + " ";
            }
            System.out.println(blank);
            return blank;
        }
        int minimum = array[first];
        for (int x = 0; x < array.length; x++) {
            if (array[x] < minimum) {
                minimum = array[x];
                array[x] = array[first];
                array[first] = minimum;
            }
        }
        return selectionSortRecursive(array, first, length - 1);
    }
}
