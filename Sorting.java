public class Sorting extends Second {
    boolean isSorted = true;

    public static void main(String[] args) {
        Sorting practice = new Sorting();
        Second myC = new Sorting();
        int[] array = {5, 3, 7, 6, 2};
        int[] array2 = {104, 64, 89, 24, 75};
        int[] array3 = {-5, -3, -17, -62, -25};
        int[] array4 = {0,3,5,7,9,11,13,14,18};
        practice.reverse(array);
        practice.SelectionSort(array2);
        System.out.println(practice.emptyArray(3));
    } // main bracket

    public void SelectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minimum = array[i];
            for (int x = i + 1; x < array.length; x++) {
                if (array[x] < minimum) {
                    minimum = array[x];
                    array[x] = array[i];
                    array[i] = minimum;
                }
            }
        }
        String blank = "";
        for (int i = 0; i < array.length; i++) {
            blank += " " + array[i] + " ";
        }
        System.out.println("Iterative: " + blank);
    } // SelectionSort() bracket

    // SelectionSort() bracket

    public int emptyArray(int x) {
        int count = 0;
        int[] array = new int[x];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = i + 1;
        }
        for (int o = 0; o < array.length; o++) {
            if (array[o] != 0) {
                count++;
            }
        }
        return count;
    }

    public void reverse(int[] array) {
        String blank = "";
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            num++;
        }
        int index = 0;
        for (int x = num - 1; x >= 0; x--) {
            blank += " " + array[x] + " ";
        }
        System.out.println("Reversed: " + blank);
    }

    public void bubbleSort(int[] array) {
        String blank = "";
        for (int i = 0; i < array.length; i++) {
            blank += " " + array[i] + " ";
        }
        System.out.println(blank);
        for (int x = 0; x < array.length; x++) {
            for (int i = 0; i + 1 < array.length; i++) {
                if (array[i + 1] < array[i]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }
        blank = "";
        for (int i = 0; i < array.length; i++) {
            blank += " " + array[i] + " ";
        }
        System.out.println("Bubble Sort: " + blank);
    }

    public void insertionSort(int[] array) {
        String blank = "";
        for (int i = 0; i < array.length; i++) {
            blank += " " + array[i] + " ";
        }
        System.out.println(blank);
        for (int i = 0; i < array.length; i++) {
            for (int x = 0; x < i; x++) {
                if (array[i] < array[x]) {
                    int temp = array[i];
                    for (int c = i - 1; c >= x; c--) {
                        array[c + 1] = array[c];
                    }
                    array[x] = temp;
                }
            }
        }
        blank = "";
        for (int i = 0; i < array.length; i++) {
            blank += " " + array[i] + " ";
        }
        System.out.println("Insertion Sort: " + blank);
    }

    public int binarySearch(int[] sortedList,int element){
            int max = sortedList.length;
            int min = 0;
            int binarySearch = (max + min) / 2;
            if(isSorted == true){                   // if isSorted is true a binary search will happen
                boolean found = false;              // just a variable to keep while loop going
                while (!found) {
                    if (element == sortedList[binarySearch]) {
                        found = true;
                    } else {
                        if(binarySearch == min || binarySearch == max){
                            return -1;
                        }
                        if (element < sortedList[binarySearch]) {
                            max = binarySearch;
                            binarySearch = (max+min) / 2;
                        } else {
                            min = binarySearch;
                            binarySearch = (max+min) / 2;
                        }
                    }
                }
            }
            return binarySearch;
    }
    public void sortingArray(int[] myList){
    for (int x = 0; x < myList.length; x++) {                       // same process here as above but just with descending order
        for (int i = 0; i < myList.length; i++) {
            if (myList[x] > myList[i]) {
                int thirdVar = myList[x];
                myList[x] = myList[i];
                myList[i] = thirdVar;
            }
        }
    }
        for(int i = 0; i < myList.length; i++){
            System.out.println(myList[i]);
        }
    }

    public static int highCount(int[][] a) {
        int max = 0;
        for(int i = 0; i < a.length; i++){
            for(int x = 0; x < a[i].length; x++){
                if(a[i][x] > max){
                    max = a[i][x];
                }
            }
        }
        return max;
    }
    public IntNode makeList(int n) {
        if (n < 1) {
            return null;
        } else {
            IntNode newNode = new IntNode(1, null);
            IntNode nodePtr = newNode;
            for (int i = 2; i <= n; i++) {
                nodePtr.setNext(new IntNode(i, null));
                nodePtr = newNode.getNext();
            }
            return newNode;
        }
    }
    /* Node start;
    int actualSize = 0;
    public void pushN(T item, int n) {
        if(n > 0){
            if(n == 0){
                start = new N(o, start);
                actualSize++;
            }else{
                Stack1 thirdStack = new Stack1();
                for (int i = 0; i < n - 1; i++) {
                    T data = (T) this.pop();
                    thirdStack.push(data);
                }
                this.push(item);
                for (int i = 0; i < n; i++) {
                    T dataTwo = (T) thirdStack.pop();
                    this.push(dataTwo);
                }
                actualSize++;
            }
        }
    } */
}