package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.stream.IntStream;

public class Core {
    private Queue<Process> processesQueue = new LinkedList<>();
    private Process processes;
    private int maxTime = 20;
    Random random = new Random();

    public void planning() {
        processes = processesQueue.poll();

        while(processes != null){
            if(processes.start()) processesQueue.add(processes);
            processes = processesQueue.poll();
        }
    }
    public void createProcess(int processQuantity) {
        IntStream.range(0, processQuantity).forEach(i -> {
            processes = new Process(i, maxTime, random.nextInt(10) + 1);
            processes.createThread();
            processesQueue.add(processes);
        });
    }

}
