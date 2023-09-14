package by.marmur;

class Quicksort2 {
    public static void quickSort(int[] sortArr, int low, int high) {
        /*
        завершить,если массив пуст или уже нечего делить
         */
        if (sortArr.length == 0 || low >= high) return;

        /*
        выбор опорного элемента
         */
        int middle = low + (high - low) / 2;
        int border = sortArr[middle];

        /*
        разделить на подмассивы и меняем местами
         */
        int i = low, j = high;
        while (i <= j) {
            while (sortArr[i] < border) i++;
            while (sortArr[j] > border) j--;
            if (i <= j) {
                int swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }

        /*
        рекурсия для сортировки левой и правой части
         */
        if (low < j) quickSort(sortArr, low, j);
        if (high > i) quickSort(sortArr, i, high);
    }



}
