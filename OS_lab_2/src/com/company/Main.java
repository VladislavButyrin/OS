package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Core core = new Core();
        Random random = new Random();
        int processQuantity = random.nextInt(10) + 1;

        core.createProcess(processQuantity);
        core.planning();
    }

}
