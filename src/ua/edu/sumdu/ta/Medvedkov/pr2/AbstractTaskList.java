package ua.edu.sumdu.ta.Medvedkov.pr2;

/**
 * This abstract class for creating task list
 */
public abstract class AbstractTaskList {
    public Task[] array;

    /**
     * This abstract method is for adding non-unique tasks
     *
     * @param task object of class Task
     */
    public abstract void add(Task task);

    /**
     * This abstract method is to remove all tasks equal to the input
     *
     * @param task object of class Task
     */
    public abstract void remove(Task task);

    /**
     * This abstract method returns the quantity of tasks in the current list.
     *
     * @return return quantity of tasks
     */
    public int size() {
        int size = 0;
        for (Task task : array) {
            if (task != null) {
                size++;
            }
        }
        return size;
    }

    /**
     * This abstract method is used to get the task at a given number (from 0)
     *
     * @param index the number of tasks
     * @return the task at a given number
     */
    public abstract Task getTask(int index);

}