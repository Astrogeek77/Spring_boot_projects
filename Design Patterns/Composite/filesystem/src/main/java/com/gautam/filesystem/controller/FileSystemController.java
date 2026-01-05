package com.gautam.filesystem.controller;

import com.gautam.filesystem.model.File;
import com.gautam.filesystem.model.Folder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileSystemController {

    @GetMapping("/api/filesystem")
    public String getFileSystemStats() {
        // 1. Create Leaf nodes (Files)
        File movie = new File("Avengers.mp4", 2000); // 2000KB
        File song1 = new File("ShapeOfYou.mp3", 10);
        File song2 = new File("Believer.mp3", 12);

        // 2. Create Composite nodes (Folders)
        Folder musicFolder = new Folder("Music");
        Folder rootFolder = new Folder("Root");

        // 3. Compose the tree
        musicFolder.addComponent(song1);
        musicFolder.addComponent(song2);

        rootFolder.addComponent(movie);
        rootFolder.addComponent(musicFolder); // Adding a folder inside a folder!

        // 4. Test the pattern
        // We only call getSize() on the Root.
        // It recursively calculates EVERYTHING inside.
        int totalSize = rootFolder.getSize();

        // Print to console to see structure
        System.out.println("--- FILE SYSTEM STRUCTURE ---");
        rootFolder.printDetails();

        return "Root Folder Size: " + totalSize + " KB. (Check console for tree structure)";
    }
}