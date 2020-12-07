package com;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Process {
    Random random = new Random();
    //private List<Page> pages = new LinkedList<Page>();
    private int ID;
    private PagesTable pageTable;
    private int countPages = random.nextInt( 10 ) + 1;

    Process(int ID) {
        this.ID = ID;
        pageTable = new PagesTable(this);
        createPages();
    }

    private void createPages() {
        for (int i = 0; i < countPages; i++) {
            Page page = new Page( ID, i, "processID: " + ID + ", pageID:  " + i, 0, 0);
            pageTable.addPage(page);
        }
    }

    public int getID() {
        return ID;
    }

    public List<Page> getPageList() {
        return pageTable.getPageList();
    }

    public Page getPage(int index) {
        return pageTable.getPageList().get( index );
    }

    public void setTable(PagesTable table) {
        pageTable = table;
    }

    public PagesTable getTable() {
        return pageTable;
    }
}