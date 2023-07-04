import java.util.Arrays;

public class MyArrayList <T> {
    private int size = 0;
    private T [] array;

    public MyArrayList(T[] array) {
        this.array = array;
    }


    public void add(T elem){
        if (size == array.length){
            array = Arrays.copyOf(array, (int) (array.length*1.5));
        }
        array[size] = elem;
        size++;
    }


    public void addAll(T[] c){
        if (size == array.length){
            array = Arrays.copyOf(array, (int) (array.length*1.5));
        }
        System.arraycopy(c,0, array, size+1, c.length);
        size += c.length;
    }



    public T get(int index) throws IndexOutOfBoundsException{
        if (index >= size){
            String s = "invalid index of element";
            throw new IndexOutOfBoundsException(s);
        }else {
            return array[index];
        }
    }


    public void remove(int index) throws IndexOutOfBoundsException{
        if (array.length - index >= 0){
            System.arraycopy(array, index + 1, array, index, array.length - index-1);
            size--;
        }else {
            String errorMessage = "invalid index of element";
            throw new IndexOutOfBoundsException(errorMessage);
        }
    }


    public void remove(Object o){
        for(int i=0; i<array.length; i++){
            if(o.equals(array[i])){
                System.arraycopy(array, i + 1, array, i, array.length - i -1);
            }else{
                System.out.println("Element was not found");
            }
        }
    }


    public void clear(){
        for (int i = 0; i < array.length; i++){
            array[i] = null;
        }
        size=0;
    }


    public boolean isEmpty(){
        return size == 0; //size == 0 ? true:false;
    }


    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0 || low >= high) return;

        int middle = low + (high - low) / 2;
        int border = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < border) i++;
            while (array[j] > border) j--;
            if (i <= j) {
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(array, low, j);
        if (high > i) quickSort(array, i, high);
    }

}




