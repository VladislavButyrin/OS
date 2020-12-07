package com;

import java.util.LinkedList;
import java.util.Random;

public class MemoryManager {
    private int countProcess;
    Disk disk = new Disk();
    RAM RAM = new RAM();
    private LinkedList<Page> pagesQueue = new LinkedList<Page>();

    public void createProcess(int countProcess) {
        this.countProcess = countProcess;
        for (int i = 0; i < countProcess; i++) {
            Process newProcess = new Process( i );
            RAM.addProcess( newProcess );
            PagesTable pageTable = new PagesTable( newProcess );
            RAM.addTable( pageTable, i );
        }
    }

    public void work(int count) {
        RAM.initIDList();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Process process = RAM.getProcess( random.nextInt( countProcess ));
            Page page = process.getPage( random.nextInt( process.getTable().getPageListSize() ) );
            System.out.println( "ОС запрашивает у процесса " + page.getProcessID() + " страницу " + page.getID() );
            RAM.setInTableNRU( page, disk );
        }

        System.out.println( "________________________________________________________________________\n" +
                "Финальные таблицы" );
        for (int i = 0; i < countProcess; i++) {
            RAM.getTable( i ).printTable();
        }
        RAM.printTable();
    }

    public void swap(Process process) {
        System.out.println("Swapping start");
        for (int i = 0;i<RAM.getProcessList().size();i++) {
            Page safePage = pagesQueue.poll();
            if (safePage != null) {
                System.out.println("\tSave page " + safePage.getID() + " of process : " + safePage.getProcessID());
                RAM.getProcess(i).getTable().deleteFromRAM(safePage.getID());
                for (Process safeProcess : RAM.getProcessList()) {
                    if (safePage.getProcessID() == safeProcess.getID()) {
                        safeProcess.getTable().addPage(safePage);
                        break;
                    }
                }
            }
            Page nowPage = process.getTable().getPageList().get(safePage.getID() + 1);
            System.out.println("\tAdding a page " + nowPage.getID() + " of  process : " + nowPage.getProcessID());
            pagesQueue.add(nowPage);
            RAM.getProcess(i).getTable().addPage(nowPage);
        }
    }
}
