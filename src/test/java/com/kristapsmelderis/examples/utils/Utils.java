package com.kristapsmelderis.examples.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.IOException;


public class Utils {
    private static String encodeBase64String(String inputString) {
        return Base64.encodeBase64URLSafeString(inputString.getBytes());
    }

    private static boolean fileExists(String pathToFile) {
        return new File(pathToFile).exists();
    }

    public static void makeDirectory(String newDirString) {
        File file = new File(newDirString);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("\ninfo: Directory was created!\n");
            } else {
                System.out.println("\nerror: Failed to create directory!\n");
            }
        }
    }

    public static void importTestsFromJIRA(String username, String password, String jiraURL, String jiraKeys, String pathToOutputFile) {
        String[] command = {"curl.exe", "-D-", "-X", "GET", "-H",
                "Authorization: Basic " + encodeBase64String(username + ":" + password),
                jiraURL + "/rest/raven/1.0/export/test?keys=" + jiraKeys, "-o", pathToOutputFile
        };
        ProcessBuilder process = new ProcessBuilder(command);
        Process p;
        try {
            System.out.println("\ninfo: Starting process that accepts curl GET command\n");
            p = process.start();
        } catch (IOException e) {
            System.out.print("\nerror: Tried to execute curl command and output to a file, something went wrong\n");
            e.printStackTrace();
        }
        do {
            System.out.println("\ninfo: Checking if tests are imported and put in a new file\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        } while (!fileExists(pathToOutputFile));
    }

    public static void exportReportToJIRA(String username, String password, String jiraURL, String reportFilePath) {
        String[] command = {"curl.exe", "-D-", "-X", "POST",
                "-H", "Content-Type: application/json",
                "-H", "Authorization: Basic " + encodeBase64String(username + ":" + password),
                "--data", "@" + reportFilePath,
                jiraURL + "/rest/raven/1.0/import/execution/cucumber"
        };

        ProcessBuilder process = new ProcessBuilder(command);
        Process p;

        do {
            System.out.println("\ninfo: Checking if cucumber.json file has been generated\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        } while (!fileExists(reportFilePath));

        try {
            System.out.println("\ninfo: Starting process that accepts curl POST command\n");
            p = process.start();
        } catch (IOException e) {
            System.out.print("\nerror: Tried to execute curl command that posts json file to JIRA Xray, something went wrong\n");
            e.printStackTrace();
        }
    }

}