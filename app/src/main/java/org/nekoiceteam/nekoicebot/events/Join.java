/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.nekoiceteam.nekoicebot.events;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author nekoicecream
 */
public class Join extends ListenerAdapter {
    
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        
        if(!event.getGuild().getId().equals("940595375859974194")){
        return;
    }
    event.getGuild().getTextChannelById("940774861662486558").sendMessage("Welcome to NekoIceTeam server " + event.getMember().getAsMention() + "!").queue();
    
    }
}