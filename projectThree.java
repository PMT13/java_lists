public class projectThree {
    boolean isSorted = false;
    int[] myList = {1,6,7,7,9,11,19,19};

    public static void main(String args[]){
        projectThree myCase = new projectThree();
        System.out.println(myCase.indexOf(7));
        myCase.sort(true);
        System.out.println("Binary: "+myCase.indexOf(7));
        for(int i =0; i<myCase.myList.length; i++){
            System.out.println(myCase.myList[i]);
        }
    }

    public projectThree() {
    }

    public int size() {
        int elements = 0;
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] != 0) {
                elements++;
            }
        }
        return elements;
    }

    public boolean add(int element) {
        if (element == 0) {                                                   // makes sure user isn't trying to add null to list
            return false;
        }
        if(size() == myList.length){
            int[] newList = new int[myList.length*2];
            for(int i = 0; i < myList.length;i++){
                newList[i] = myList[i];
            }
            myList = newList;
        }
        int i = 0;
        while (myList[i] != 0) {                                             //this loop is used to find next open index in list
            i++;
        }
        myList[i] = element;
        isSorted = false;
        return true;
    }

    public boolean add(int index, int element) {
        if (index < 0 || index >= size() || element == 0) {
            return false;
        }
        if(size() == myList.length){
            int[] newList = new int[myList.length*2];
            for(int i = 0; i < myList.length;i++){
                newList[i] = myList[i];
            }
            myList = newList;
        }
        if (myList[index] == 0) {                                            // if index is empty, element will be placed there
            myList[index] = element;
        } else {
            int idxToMove = 0;
            for (int x = 1; index + x < myList.length; x++) {                   //finds out how many spaces are to the right of index
                idxToMove++;
            }
            if (index + idxToMove < myList.length) {                            // finds out if there are enough spaces to move everything to the right 1
                for (int i = myList.length - 1; i > index; i--) {
                    myList[i] = myList[i-1];
                }
                myList[index] = element;
            } else{
                return false;
            }
        }
        isSorted = false;
        return true;
    }

    public void clear(){
        myList = new int[2];                                       // clears array and resets it to a length of 2
    }

    public boolean contains(int element){
        if(isSorted == true){
            System.out.println("Binary");
            if(binarySearch(element) > 0){                                      // binarySearch either returns an index (which is always > 0) or -1 if the element is not present
                return true;
            }else{
                return false;
            }
        }
        for(int i = 0; i < myList.length; i++){
            if(element != 0 && element == myList[i]){
                return true;
            }
        }
        return false;
    }

    public int get(int index){
        if(index >= myList.length || index < 0){
            return 0;
        }else{
            return myList[index];
        }
    }

    public int indexOf(int element){
        if(element == 0){
            return -1;
        }
        if(isSorted == true){
            System.out.println("Binary");
            int duplicateTracker = binarySearch(element);
            int i = 1;                                                           // just a counter for index purposes
            if(binarySearch(element) > 0) {                                       // binarySearch either returns an index (which is always > 0) or -1 if the element is not present
                while(binarySearch(element) - i >= 0) {
                     if(myList[binarySearch(element) - i] == element){         // this checks to see if there are any duplicates that come before
                        duplicateTracker = binarySearch(element) - i;
                        i++;
                    }else{
                         i = myList.length;
                     }
                }
                return duplicateTracker;
            }else{
                return binarySearch(element);                                    // this will return -1 if element is not found
            }
        }
        for(int i = 0; i < myList.length;i++){
            if(myList[i] != 0 && myList[i]==element){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        if(size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public int lastIndexOf(int element) {
        int idx = -1;
        if(element == 0){
            return -1;
        }
        if(isSorted == true){
            System.out.println("Binary");
            int duplicateTracker = binarySearch(element);
            int i = 1;                                                           // just a counter for index purposes
            if(binarySearch(element) > 0){                                      // binarySearch either returns an index (which is always > 0) or -1 if the element is not present
                while(binarySearch(element) + i <= myList.length - 1){
                    if (myList[binarySearch(element) + i] == element) {        // this checks to see if there are any duplicates that come after
                        duplicateTracker = binarySearch(element) + i;
                        i++;
                    }else{
                        i = myList.length;
                    }
                }
                return duplicateTracker;
            }else{
                return binarySearch(element);                                    // this will return -1 if element is not found
            }
        }
        for (int i = 0; i < myList.length; i++) {
            if (myList[i] != 0 && myList[i] == element) {
                idx = i;                                                         // each time the element is found the index will be updated, the last updated one
            }                                                                   // is also the last index of that element
        }
        return idx;
    }

    public int set(int index, int element){
        if (index < 0 || index >= myList.length || element == 0) {
            return 0;
        }else{
            int original = myList[index];
            myList[index] = element;
            return original;
        }
    }

    public void sort(boolean order){
        if(order == true && isSorted != true) {                                 // makes it so that sorting doesn't happen if both order and isSorted are true
            for(int x = 0; x < myList.length;x++) {
                for (int i = 0; i < myList.length; i++) {                       // the two for loops compare one element with all the other elements one-by-one
                    if (myList[x] < myList[i]) {                   // then necessary changes are made if needed
                        int thirdVar = myList[x];
                        myList[x] = myList[i];
                        myList[i] = thirdVar;
                    }
                }
            }
            isSorted = true;
        }else {
            if (order == false) {
                for (int x = 0; x < myList.length; x++) {                       // same process here as above but just with descending order
                    for (int i = 0; i < myList.length; i++) {
                        if (myList[x] > myList[i]) {
                            int thirdVar = myList[x];
                            myList[x] = myList[i];
                            myList[i] = thirdVar;
                        }
                    }
                    isSorted = false;
                }
            }
        }
    }
    public boolean remove(int element){
        for(int i = 0; i < myList.length;i++){                                  // compares element with every element in array
            if(myList[i] != 0 && myList[i] == element) {
                if(i != myList.length - 1) {                                    // have to move everything to the left 1 if element is not in last index
                    for (int x = i; x < myList.length-1; x++) {                 // length - 1 so we don't go out of index range
                        myList[x] = myList[x+1];
                    }
                }else{                                                          // this happens if the first index of element is the last index.
                    myList[i] = element;                                        //  We don't have to move anything to the left if this is the case
                }
                return true;
            }
        }
        return false;
    }

    public int removeEle(int index) {
        if (index < 0 || index >= myList.length) {
            return 0;
        } else {
            int returnVal = myList[index];
            for (int i = index; i < myList.length - 1; i++) {
                myList[i] = myList[i + 1];
            }
            return returnVal;
        }
    }

    public String toString(){
        String finalString = "";
        for(int i = 0; i < myList.length; i++){
            finalString += myList[i] + "\n";
        }
        return finalString;
    }

    public int binarySearch(int element){
        int max = myList.length;
        int min = 0;
        int binarySearch = (max + min) / 2;
        if(isSorted == true){                                                    // if isSorted is true a binary search will happen
            boolean found = false;                                               // just a variable to keep while loop going
            while (!found) {
                if (element != 0 && element == myList[binarySearch]) {
                    found = true;
                } else {
                    if(binarySearch == min || binarySearch == max){
                        return -1;
                    }
                    if(element < myList[binarySearch]) {
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
}
