package com.gautam.filesystem.model;

import com.gautam.filesystem.component.FileSystemItem;
import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    // Composite specific method: Add child
    public void addComponent(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        // RECURSION MAGIC:
        // Sums the size of all children (Files or Sub-folders)
        int totalSize = 0;
        for (FileSystemItem child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    @Override
    public void printDetails() {
        System.out.println("Folder: " + name + " (Total Size: " + getSize() + "KB)");
        for (FileSystemItem child : children) {
            // Delegate printing to children
            child.printDetails();
        }
    }
}