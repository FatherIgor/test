package ua.edu.sumdu.ta.Medvedkov.pr2;

public class ArrayTaskList {
    public static int size;
    public static final String name = "[EDUCTR][TA]";
    public static int quantity=0;

    public static Task[] array = new Task[15];

    public ArrayTaskList() {
        quantity++;
    }

    public static Task next(int index){
        return array[index+1];
    }

    public Task prev(int index){
        return array[index-1];
    }

    public static void add(Task task) {
        //if (task.isActive()) {
        final int add = 3;
        if (size() == array.length) {
            //array = Arrays.copyOf(array, array.length + add);
            Task[] arr = new Task[array.length + add];
            System.arraycopy(array, 0, arr, 0, array.length);
            array = arr;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = task;
                array[i].setTitle(name+array[i].getTitle());
                break;
            }
        }
    }
    //}

    public static void remove(Task task) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == task) {
                array[i] = null;
                for (int k = i; k < array.length - 1; k++)
                    array[k] = array[k + 1];
            }
        }
    }

    /*@Override
    public int size() {
        return super.size();
    }*/

    public static int size() {
        int size = 0;
        for (Task task : array) {
            if (task != null) {
                size++;
            }
        }
        //System.out.println(size);
        return size;
    }

    public static Task getTask(int index) {
        //checkArgument(index <= 0, "there is no such element in the array");
        return array[index];
    }

    public static Task[] incoming(int from, int to) {
        int index = 0;
        Task[] newArr = new Task[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].nextTimeAfter(from) != -1 && array[i].nextTimeAfter(from) <= to) {
                newArr[index] = array[i];
                index++;
            }
        }
        int j = 0;
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] != null)
                j++;
        }
        Task[] newArray = new Task[j];
        System.arraycopy(newArr, 0, newArray, 0, j);
        return newArray;
    }


    /*public Task[] incoming(int from, int to) {
        //int a;
        Task[] newArr = new Task[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getRepeatInterval() == 0) {
                if (from < array[i].getTime() && array[i].getTime() <= to) {
                    newArr[index] = array[i];
                    index++;
                }
            }
            else if (array[i] != null) {
                int a = array[i].getStartTime();
                //for (a = a; (a + getTask(i).getRepeatInterval()) <= getTask(i).getEndTime(); a += getTask(i).getRepeatInterval()) {
                    if (from < a+12 && a+12 <= to) {
                        newArr[index] = array[i];
                        index++;
                        break;
                    }
                //}
            }
        }
        return newArr;
    }*/
}