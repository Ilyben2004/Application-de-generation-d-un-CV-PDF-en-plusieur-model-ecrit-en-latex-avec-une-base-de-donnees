
package org.example;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class Functions {

    private static void printStream(InputStream inputStream) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        }
    }
    public static void convertLatexToPdf() {
        try {
            // Directory where you want to execute the pdflatex command
            String workingDirectory = "C:\\Users\\HP\\IdeaProjects\\CvApp\\pdf"; // Replace with your desired directory

            // Command to execute
            String pdflatexCommand = "pdflatex example.tex"; // Replace with the actual LaTeX file you want to compile

            // Create a process builder with the specified working directory
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", pdflatexCommand);
            processBuilder.directory(new File(workingDirectory));

            // Redirect error stream to standard output
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the process output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();

            // Print the exit code
            System.out.println("Exit Code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void  WriteInLatex(String latexContent) {
        String filePath = "C:\\Users\\HP\\IdeaProjects\\CvApp\\pdf\\example.tex";

        try {
            // Create a FileWriter in append mode to write the LaTeX content to the file
            FileWriter writer = new FileWriter(filePath, true);

            // Write the LaTeX content to the file
            writer.write(latexContent);

            // Close the FileWriter
            writer.close();

            System.out.println("LaTeX content appended to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error appending LaTeX content to the file.");
        }
    }
    public static void clearLatexDocument() {
        String filePath = "C:\\Users\\HP\\IdeaProjects\\CvApp\\pdf\\example.tex";

        try {
            // Create a FileWriter in non-append mode to truncate the LaTeX content
            FileWriter writer = new FileWriter(filePath, false);


            writer.write("");


            writer.close();

            System.out.println("example.tex document content cleared.");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error clearing the LaTeX document content.");
        }
    }

    public static void clearAUXDocument() {
        String filePath = "C:\\Users\\HP\\IdeaProjects\\CvApp\\pdf\\example.aux";

        try {
            // Create a FileWriter in non-append mode to truncate the LaTeX content
            FileWriter writer = new FileWriter(filePath, false);


            writer.write("");


            writer.close();

            System.out.println("example.aux document content cleared.");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error clearing the LaTeX document content.");
        }
    }
    
    public static String imageNameChangeFormat(String imageName) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < imageName.length(); i++) {
            char currentChar = imageName.charAt(i);

            if (currentChar == '\\') {
                result.append('/');
             } else {
                result.append(currentChar);
            }
        }

        return result.toString();
    }


    public static String addNewlineEvery66Chars(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Return the input string if it's null or empty
        }

        StringBuilder result = new StringBuilder();
        int length = input.length();
        int index = 0;

        while (index < length) {
            result.append(input, index, Math.min(index + 66, length)); // Append substring
            index += 66; // Move the index by 66 characters

            if (index < length) {
                result.append("\n"); // Add newline if not at the end of the string
            }
        }

        return result.toString();
    }
	
    
}
