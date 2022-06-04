package org.nekoiceteam.nekoicebot;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class App {
	public static void main(String[] args)  throws LoginException {
            if (args.length < 1) {
                System.out.println("You have to provide a token as first argument!");
		System.out.println("Example: java (another args) -jar (path/to/jar) (token)");
                System.exit(1);
            }
		JDABuilder builder = JDABuilder.createDefault(args[0]);
		
		builder.setBulkDeleteSplittingEnabled(false);
		builder.setCompression(Compression.ZLIB);
		builder.setActivity(Activity.playing("With Your Mom"));
		builder.setStatus(OnlineStatus.IDLE);
		builder.addEventListeners(new MessageListener());
		builder.setChunkingFilter(ChunkingFilter.ALL);
        	builder.setMemberCachePolicy(MemberCachePolicy.ALL);
                builder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES);
		builder.build();
            }
}
