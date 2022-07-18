package org.nekoiceteam.nekoicebot

import org.nekoiceteam.nekoicebot.bot.Bot
import java.io.IOException
import javax.security.auth.login.LoginException

/**
 *
 * @author nekoicecream
 */
object App {
    @Throws(NullPointerException::class, LoginException::class, IOException::class, InterruptedException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val Client = Bot(args)
    }
}