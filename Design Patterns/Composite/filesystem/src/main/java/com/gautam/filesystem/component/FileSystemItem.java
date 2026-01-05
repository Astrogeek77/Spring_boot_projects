package com.gautam.filesystem.component;

public interface FileSystemItem {
    String getName();
    int getSize(); // The magic recursive method
    void printDetails();
}