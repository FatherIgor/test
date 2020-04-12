package ua.edu.sumdu.ta.Medvedkov.pr2;

public class LinkedTaskList extends AbstractTaskList {
    static class Link {
        public Task task;
        public Link next;
    }

    private Link head;
    private Link tail;
    public int size = 0;
    //public static Link list2 = new Link();

    public void printList() {
        Link t = head;
        while (t != null) {
            System.out.println(t.task + " ");
            t = t.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Task task) {
        Link list = new Link();
        list.task = task;
        if (tail == null) {
            head = list;
            tail = list;
        } else {
            tail.next = list;
            tail = list;
        }
        //list2 = list;
        size++;
    }

    @Override
    public void remove(Task task) {
        if (head.task == task || head == tail) {
            head = head.next;
        } else {
            Link t = head;
            while (t.next != null) {
                if (t.next.task == task) {
                    if (t.next == tail)
                        t = tail;
                    else t.next = t.next.next;
                }
                t = t.next;
            }
        }
        size--;
    }

    @Override
    public Task getTask(int index) {
        //checkArgument(index < 0, "there is no such element in the array");
        if (head != null) {
            Link a = head;
            for (int i = 0; i < index; i++)
                a = a.next;
            return a.task;
        }
        return null;
    }

    public Task[] incoming(int from, int to) {
        Task[] newArr = new Task[size()];
        int index = 0;
        Link a = head;
        while (a != null) {
            a.task.setActive(true);
            if (a.task.nextTimeAfter(from) != -1 && a.task.nextTimeAfter(from) <= to) {
                newArr[index] = a.task;
                index++;
                a = a.next;
            }
            else a = a.next;
        }
        Task[] newArray = new Task[index];
        System.arraycopy(newArr, 0, newArray, 0, index);
        return newArray;
    }

    /*public Task[] incoming(int from, int to) {
        Task[] newArr = new Task[array.length];
        int index = 0;
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
    }*/
}