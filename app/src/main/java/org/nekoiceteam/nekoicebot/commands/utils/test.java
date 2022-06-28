/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.nekoiceteam.nekoicebot.commands.utils;

import java.io.IOException;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.nekoiceteam.nekoicebot.utils.Logger;

/**
 *
 * @author nekoicecream
 */
public class test extends ListenerAdapter {
    
    //Logger logger;
    
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        //String ftr = event.getAuthor().getAsTag();
        //try {
            //logger = new Logger("Log");
        //} catch (IOException e) {
            //throw new RuntimeException(e);
        //}
        
        if (event.getName().equals("test"))
            event.deferReply().queue();
            event.getHook().sendMessage("test slash work!").setEphemeral(true).queue();
            //logger.info(ftr + " use test slash command!");
    }
}
