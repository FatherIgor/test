package com.company;

import ua.edu.sumdu.ta.Medvedkov.pr2.LinkedTaskList;
import ua.edu.sumdu.ta.Medvedkov.pr2.Task;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedTaskList list = new LinkedTaskList();
        Task abc = new Task("FOFO", 1);
        list.add(abc);
        Task qwer = new Task("qwer", 2);
        list.add(qwer);
        Task qaz = new Task("qaz", 3);
        list.add(qaz);
        Task zxc = new Task("zxc", 4);
        list.add(zxc);
        /*abc.setActive(true);
        qwer.setActive(true);
        qaz.setActive(true);
        zxc.setActive(true);*/
        //list.printList();
        System.out.println(Arrays.toString(list.incoming(1, 4)));
        //System.out.println(list.getTask(0));
    }
}
