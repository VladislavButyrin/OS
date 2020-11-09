package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Process {
    private int threadQuantity;
    private int ID;
    private int time;
    private int overallTime = 0;
    private Thread thread;
    private Queue<Thread> threadQueue = new LinkedList<>();

    Process(int ID, int time, int threadQuantity){
        this.threadQuantity = threadQuantity;
        this.ID = ID;
        this.time = time;
    }

    public boolean start(){
        System.out.print("* Процесс " + ID + " выполняется" + '\n');
        thread = threadQueue.poll();

        while(overallTime + thread.getWorkTime() <= time && thread != null){
            overallTime += thread.getWorkTime();

            if(thread.start()){
                threadQueue.add(thread);
            }

            thread = threadQueue.poll();

            if(thread == null){
                break;
            }
        }

        if(thread != null) {
            threadQueue.add(thread);

            if (overallTime + thread.getWorkTime() > time) {
                System.out.print("* Процесс " + ID + " приостановлен." + " Времени затрачено: " + overallTime + '\n' + '\n');
                overallTime = 0;
                return true;
            }

        }

        System.out.print("* Процесс " + ID + " выполнен." + " Времени затрачено: " + overallTime + '\n' + '\n');
        return false;
    }

    public void createThread() {
        IntStream.range(0, threadQuantity).forEach(i -> {
            thread = new Thread(i, 2);
            threadQueue.add(thread);
        });
    }
}
