package com.gautam.filesystem.model;

import com.gautam.filesystem.component.FileSystemItem;

public class File implements FileSystemItem {
    private String name;
    private int sizeKb;

    public File(String name, int sizeKb) {
        this.name = name;
        this.sizeKb = sizeKb;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return sizeKb; // Returns actual size
    }

    @Override
    public void printDetails() {
        System.out.println("  - File: " + name + " (" + sizeKb + "KB)");
    }
}