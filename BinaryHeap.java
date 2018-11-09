public class BinaryHeap {
    private int[] arr;
    private int size;

    BinaryHeap(){
        arr = new int[10];
        size = 0;
    }

    public void add(int c){
        if(size==arr.length-1)
            growArray();

        int pos = ++size;
        arr[pos] = c;
        bottomUp();
    }

    public void bottomUp() {
        int index = size;
        while (index/2>=1 && arr[index/2]>arr[index]) {
            swap(index, index/2);
            index /= 2;
        }
    }

    public void topDown() {
        int index = 1;

        while (index*2<size) {
            int smallerChild = index*2;

            if (index*2+1<size && arr[index*2]>arr[index*2+1]) {
                smallerChild = index*2+1;
            }

            if (arr[index]>arr[smallerChild]) {
                swap(index, smallerChild);
            }
            else {
                break;
            }
            index = smallerChild;
        }
    }

    public void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    public int remove(){
        int returnItem = arr[1];
        arr[1] = arr[size - 1];
        size--;
        topDown();
        return returnItem;
    }

    public void growArray(){
        int[] newArray = new int[arr.length*2];
        for(int i=0;i<arr.length;i++)
            newArray[i] = arr[i];
        arr = newArray;
    }
}
