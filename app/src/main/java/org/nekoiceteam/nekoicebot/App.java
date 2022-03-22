package org.nekoiceteam.nekoicebot;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class App {
	public static void main(String[] args) {
		JDABuilder builder = JDABuilder.createDefault(args[0]);
		
		builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
		builder.setBulkDeleteSplittingEnabled(false);
		builder.setCompression(Compression.ZLIB);
		builder.setActivity(Activity.playing("With Your Mom"));
		builder.setStatus(OnlineStatus.ONLINE);
		builder.addEventListeners(new MessageListener());
		builder.setChunkingFilter(ChunkingFilter.ALL);
        	builder.setMemberCachePolicy(MemberCachePolicy.ALL);
                builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES)    ;
		try {
			builder.build();
		} catch (LoginException e) {
	    e.printStackTrace();
		}
	}
}
