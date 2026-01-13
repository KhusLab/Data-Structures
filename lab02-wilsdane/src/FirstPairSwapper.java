public class FirstPairSwapper<T> {
    private T[] array;

    public FirstPairSwapper(T[] array) {
        //swapping first elem
        this.array = array;
        if (array != null && array.length > ) {
            T[] temp = array[0];
            array[0] = array[1];
            array[1] = temp;
        }
    }

    public T[] getArray() {
        return array;
    }
}
