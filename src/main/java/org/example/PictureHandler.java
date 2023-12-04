package org.example;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import java.nio.file.Path;



public class PictureHandler {

    public void renameAndReplaceImage(String imagePath, String targetPath) {
        File originalFile = new File(imagePath);
        String extension = getFileExtension(originalFile.getName());

        System.out.println("File name: " + originalFile.getName());
        System.out.println("File extension: " + extension);

        if (!extension.equalsIgnoreCase("png")) {
            System.out.println("Changing extension and renaming file...");

            // Rename the file to 'avatar.png'
            File newFile = new File(targetPath + File.separator + "avatar.png");

            try {
                Path sourcePath = originalFile.toPath();
                Path targetPathWithNewName = newFile.toPath();
                Files.copy(sourcePath, targetPathWithNewName, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File copied and renamed to avatar.png at the target path.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File already has a PNG extension. Copying the file as is...");

            File newFile = new File(targetPath + File.separator + "avatar.png");

            try {
                Path sourcePath = originalFile.toPath();
                Path targetPathWithNewName = newFile.toPath();
                Files.copy(sourcePath, targetPathWithNewName, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File copied to the target path as avatar.png.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        return (lastDotIndex == -1) ? "" : fileName.substring(lastDotIndex + 1);
    }


}