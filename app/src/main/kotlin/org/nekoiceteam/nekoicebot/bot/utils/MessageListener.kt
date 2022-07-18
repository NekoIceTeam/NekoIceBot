package org.nekoiceteam.nekoicebot.bot.utils

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color
import java.io.IOException

class MessageListener : ListenerAdapter() {
    var logger: Logger? = null
    var prefix = ","
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val args = event.message.contentRaw.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val embed = EmbedBuilder()
        embed.setColor(Color.PINK)
        val channel = event.channel
        val ftr = event.author.asTag
        val avURL = event.author.avatarUrl
        embed.setFooter(ftr, avURL)
        logger = try {
            Logger("Log")
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        if (args[0].equals(prefix + "help", ignoreCase = true)) {
            embed.setTitle("Coming Soon!")
            channel.sendMessageEmbeds(embed.build()).queue()
            embed.clear()
            logger!!.info("$ftr use help command!")
        }
    }
}