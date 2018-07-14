

public class ArrangeNumbers {
    static int[] arr = new int[] {1,2,4,6,3,9,5,8,7};

    static void arrange(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 0, j = arr.length - 1; i < j;) {
            boolean iOddPlace = false;
            boolean jOddPlace = false;

            if ((i % 2) == (arr[i] % 2)) {
                i++;
            } else {
                iOddPlace = true;
            }

            if ((j % 2) == (arr[j] % 2)) {
                j--;
            } else {
               jOddPlace = true;
            }

            if (iOddPlace && jOddPlace) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++; j--;
            }
        }
    }

    public static void main(String args[]) {
        arrange(arr);
        System.out.println(arr);
    }
}