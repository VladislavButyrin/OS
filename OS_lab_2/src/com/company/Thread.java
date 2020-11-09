package com.company;

import java.util.Random;

public class Thread {
    Random random = new Random();
    private int ID;
    private int time;
    private int workTime = random.nextInt(4) + 1;

    public Thread(int ID, int time){
        this.ID = ID;
        this.time = time;
    }

    public boolean start(){
        System.out.print("- Поток " + ID + " выполняется" + '\n');

        //что-то происходит

        if(workTime > time){
            System.out.print("- Поток " + ID + " приостановлен." + " Времени затрачено: " + time + '\n');
            workTime -= time;
            return true;
        }
        System.out.print("- Поток " + ID + " выполнен."  + " Времени затрачено: " + workTime + '\n');
        return false;
    }

    public int getWorkTime(){
        if(workTime > time) return time;

        return workTime;
    }
}
