package org.nekoiceteam.nekoicebot;

import java.awt.Color;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
	public String prefix = ","; 
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        
        if (args[0].equalsIgnoreCase(prefix + "help")) {
           embed.setTitle("Coming Soon!");
           channel.sendMessageEmbeds(embed.build()).queue();
           embed.clear();
           }
           
        if (args[0].equalsIgnoreCase(prefix + "ping")) {
            long gw = event.getJDA().getGatewayPing();
            String gwp = Long.toString(gw);
            embed.setTitle("Pong!", null);
            embed.setDescription("");
            embed.addField("Ping:", "...." + "ms", false);
            embed.addField("Websocket:", gwp + "ms", false);
            channel.sendMessageEmbeds(embed.build()).queue();
            embed.clear();
            }
       
    }
}
