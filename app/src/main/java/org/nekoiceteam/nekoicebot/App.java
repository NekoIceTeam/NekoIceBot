package org.nekoiceteam.nekoicebot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.nekoiceteam.nekoicebot.events.Join;

public class App {
	public static void main(String[] args)  throws LoginException, IOException, IllegalArgumentException {
            
            System.out.println("Initializing the bot, Please wait!");
            List<String> list = Files.readAllLines(Paths.get("config.txt"));
            String token = list.get(0);
            
		JDABuilder builder = JDABuilder.createDefault(token);
		
		builder.setBulkDeleteSplittingEnabled(false);
		builder.setCompression(Compression.ZLIB);
		builder.setActivity(Activity.playing("With Your Mom"));
		builder.setStatus(OnlineStatus.IDLE);
		builder.setChunkingFilter(ChunkingFilter.ALL);
        	builder.setMemberCachePolicy(MemberCachePolicy.ALL);
                builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES);
                builder.addEventListeners(new MessageListener(), new Join());
		builder.build();
            }
}
