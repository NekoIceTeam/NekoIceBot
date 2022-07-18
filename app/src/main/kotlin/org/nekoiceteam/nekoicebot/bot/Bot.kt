package org.nekoiceteam.nekoicebot.bot

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.utils.ChunkingFilter
import net.dv8tion.jda.api.utils.Compression
import net.dv8tion.jda.api.utils.MemberCachePolicy
import org.nekoiceteam.nekoicebot.bot.commands.utils.test
import org.nekoiceteam.nekoicebot.bot.events.Join
import org.nekoiceteam.nekoicebot.bot.utils.Logger
import java.nio.file.Files
import java.nio.file.Paths

class Bot(args: Array<String?>?) {
    var Builder: JDABuilder? = null
    var Client: JDA
    var logger: Logger

    init {
        logger = Logger("latest")
        logger.info("Initializing bot!")
        val list = Files.readAllLines(Paths.get("config.txt"))
        val token = list[0]
        val builder = JDABuilder.createDefault(token)
        builder.setBulkDeleteSplittingEnabled(false)
        builder.setCompression(Compression.ZLIB)
        builder.setActivity(Activity.playing("With Your Mom"))
        builder.setStatus(OnlineStatus.IDLE)
        builder.setChunkingFilter(ChunkingFilter.ALL)
        builder.setMemberCachePolicy(MemberCachePolicy.ALL)
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES)
        builder.addEventListeners(Join(), test())
        Client = builder.build()
        Client.awaitReady()
        logger.info("Bot is ready!")
        Client.upsertCommand("test", "testing slash command").queue()
    }
}