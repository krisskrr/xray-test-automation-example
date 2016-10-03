package com.kristapsmelderis.examples.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.IOException;

public class ImportUtils {
    private static String encodeBase64String(String inputString) {
        return Base64.encodeBase64URLSafeString(inputString.getBytes());
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

    public static void curlJIRA(String username, String password, String jiraURL, String jiraKeys, String pathToOutputFile) {

            String[] command = {"curl.exe", "-D-", "-X", "GET", "-H",
                    "Authorization: Basic " + encodeBase64String(username + ":" + password),
                    jiraURL + "/rest/raven/1.0/export/test?keys=" + jiraKeys, "-o", pathToOutputFile
            };

        ProcessBuilder process = new ProcessBuilder(command);
        Process p;
        try {
            System.out.println("info: Starting process that accepts curl command");
            p = process.start();
        } catch (IOException e) {
            System.out.print("\nerror: tried to execute curl command and output to a file, something went wrong\n");
            e.printStackTrace();
        }
    }
}
