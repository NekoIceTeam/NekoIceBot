package org.nekoiceteam.nekoicebot.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Logger {
    String logname;
    File logfile;

    public Logger(String name) throws IOException {
        logname = name;
        logfile = new File(name + ".log");

        if (logfile.exists() && !logfile.isDirectory()) {
            System.out.printf(TerminalColors.YELLOW + "%s[WARN][%s] : An existing file with the name \"%s\" already exists! Deleting.\n" + TerminalColors.RESET, getTimestampString(), logname, logname + ".txt");
            logfile.delete();
        }
        logfile.createNewFile();
    }
    public boolean writeToFile(String content) {
        boolean success = true;
        try {
            logfile.createNewFile();
            //Files.write(Paths.get("logs/" + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDateTime.now()) + ".log"), content.getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(logname + ".log"), content.getBytes(), StandardOpenOption.APPEND);
        } catch(IOException exception) {
            success = false;
            System.out.printf(TerminalColors.RED + "%s[ERROR][%s]: Could not create log file:\n%s\n" + TerminalColors.RESET, getTimestampString(), logname, Arrays.toString(exception.getStackTrace()));
        }
        return success;
    }

    public void log(String message) {
        String fmsg = String.format("%s[LOG][%s]: %s\n", getTimestampString(), logname, message);
        System.out.printf(TerminalColors.WHITE + fmsg + TerminalColors.RESET);
        writeToFile(fmsg);
    }

    public void warn(String message) {
        String fmsg = String.format("%s[WARN][%s]: %s\n", getTimestampString(), logname, message);
        System.out.printf(TerminalColors.YELLOW + fmsg + TerminalColors.RESET);
        writeToFile(fmsg);
    }

    public void error(String message) {
        String fmsg = String.format("%s[ERROR][%s]: %s\n", getTimestampString(), logname, message);
        System.out.printf(TerminalColors.RED + fmsg + TerminalColors.RESET);
        writeToFile(fmsg);
    }

    public void info(String message) {
        String fmsg = String.format("%s[INFO][%s]: %s\n", getTimestampString(), logname, message);
        System.out.printf(TerminalColors.WHITE + fmsg + TerminalColors.RESET);
        writeToFile(fmsg);
    }

    public static String getTimestampString() {
        return "[" + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()) + "]";
    }
}
