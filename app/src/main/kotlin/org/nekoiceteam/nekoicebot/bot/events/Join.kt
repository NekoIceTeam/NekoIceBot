package org.nekoiceteam.nekoicebot.bot.events

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

/**
 *
 * @author nekoicecream
 */
class Join : ListenerAdapter() {
    override fun onGuildMemberJoin(event: GuildMemberJoinEvent) {
        if (event.guild.id != "940595375859974194") {
            return
        }
        event.guild.getTextChannelById("940774861662486558")!!
            .sendMessage("Welcome to NekoIceTeam server " + event.member.asMention + "!").queue()
    }

    fun onGuildMemberRemove(event: GuildMemberJoinEvent) {
        if (event.guild.id != "940595375859974194") {
            return
        }
        event.guild.getTextChannelById("940774861662486558")!!.sendMessage("Goodbye " + event.member.asMention + "!")
            .queue()
    }
}