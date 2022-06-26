package org.nekoiceteam.nekoicebot;

import java.awt.Color;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.nekoiceteam.nekoicebot.utils.Logger;

public class MessageListener extends ListenerAdapter {

    Logger logger;
	public String prefix = ","; 
	
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Color.PINK);

        final MessageChannel channel = event.getChannel();
        String ftr = event.getAuthor().getAsTag();
        String avURL = event.getAuthor().getAvatarUrl();
        embed.setFooter(ftr, avURL);
        logger = new Logger("Log");
        
        if (args[0].equalsIgnoreCase(prefix + "help")) {
           embed.setTitle("Coming Soon!");
           channel.sendMessageEmbeds(embed.build()).queue();
           embed.clear();
           logger.info(ftr + " use help command!");
           }
           
    }
}
