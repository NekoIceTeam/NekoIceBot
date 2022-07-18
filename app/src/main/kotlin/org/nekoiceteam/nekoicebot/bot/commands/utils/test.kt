package org.nekoiceteam.nekoicebot.bot.commands.utils

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

//import java.io.IOException;
//import org.nekoiceteam.nekoicebot.utils.Logger;
/**
 *
 * @author nekoicecream
 */
class test : ListenerAdapter() {
    //Logger logger;
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        //String ftr = event.getAuthor().getAsTag();
        //try {
        //logger = new Logger("Log");
        //} catch (IOException e) {
        //throw new RuntimeException(e);
        //}
        if (event.name == "test") event.deferReply().queue()
        event.hook.sendMessage("test slash work!").setEphemeral(true).queue()
        //logger.info(ftr + " use test slash command!");
    }
}