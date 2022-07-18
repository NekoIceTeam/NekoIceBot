package org.nekoiceteam.nekoicebot.bot.utils

import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Logger(var logname: String) {
    var logfile: File

    init {
        logfile = File("$logname.log")
        if (logfile.exists() && !logfile.isDirectory) {
            System.out.printf(
                TerminalColors.Companion.YELLOW + "%s[WARN][%s] : An existing file with the name \"%s\" already exists! Deleting.\n" + TerminalColors.Companion.RESET,
                timestampString,
                logname,
                "$logname.log"
            )
            logfile.delete()
        }
        logfile.createNewFile()
    }

    fun writeToFile(content: String): Boolean {
        var success = true
        try {
            logfile.createNewFile()
            //Files.write(Paths.get("logs/" + DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDateTime.now()) + ".log"), content.getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get("$logname.log"), content.toByteArray(), StandardOpenOption.APPEND)
        } catch (exception: IOException) {
            success = false
            System.out.printf(
                TerminalColors.Companion.RED + "%s[ERROR][%s]: Could not create log file:\n%s\n" + TerminalColors.Companion.RESET,
                timestampString,
                logname,
                Arrays.toString(exception.stackTrace)
            )
        }
        return success
    }

    fun log(message: String?) {
        val fmsg = String.format("%s[LOG][%s]: %s\n", timestampString, logname, message)
        System.out.printf(TerminalColors.Companion.WHITE + fmsg + TerminalColors.Companion.RESET)
        writeToFile(fmsg)
    }

    fun warn(message: String?) {
        val fmsg = String.format("%s[WARN][%s]: %s\n", timestampString, logname, message)
        System.out.printf(TerminalColors.Companion.YELLOW + fmsg + TerminalColors.Companion.RESET)
        writeToFile(fmsg)
    }

    fun error(message: String?) {
        val fmsg = String.format("%s[ERROR][%s]: %s\n", timestampString, logname, message)
        System.out.printf(TerminalColors.Companion.RED + fmsg + TerminalColors.Companion.RESET)
        writeToFile(fmsg)
    }

    fun info(message: String?) {
        val fmsg = String.format("%s[INFO][%s]: %s\n", timestampString, logname, message)
        System.out.printf(TerminalColors.Companion.WHITE + fmsg + TerminalColors.Companion.RESET)
        writeToFile(fmsg)
    }

    companion object {
        val timestampString: String
            get() = "[" + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()) + "]"
    }
}