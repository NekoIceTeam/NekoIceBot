const { client, ShardingManager } = require("discord.js");
const config = require("./config.js");
var fs = require("fs");
const manager = new ShardingManager("./index.js", {
	respawn: true,
	totalShards: 0,
	token: config.app.token,
	spawnTimeout: -1,
	execArgv: ["--trace-warnings"],
	shardArgs: ["--ansi", "--color"]
});

manager.on("shardCreate", (shard) => {
	console.log(`[\x1b[33mShardsManager\x1b[0m]\x1b[0m Shard ${shard.id} Launched! \x1b[32m✅\x1b[0m`);
	shard.on("ready", () => {
		console.log(`[\x1b[33mShardsManager\x1b[0m]\x1b[0m Shard ${shard.id} Ready! \x1b[32m✅\x1b[0m`);
	});
	shard.on("shardError", (a, b, error) => {
		console.log("[\x1b[33mShardsManager\x1b[0m]\x1b[0m Shard ${shard.id} Error! :\x1b[0m", error);
	});
	shard.on("disconnect", (a, b) => {
		console.log("[\x1b[33mShardsManager\x1b[0m]\x1b[0m Shard ${shard.id} Disconnect!\x1b[0m");
		console.log(a);
		console.log(b);
	});
	shard.on("reconnecting", (a, b) => {
		console.log("[\x1b[33mShardsManager\x1b[0m]\x1b[0m ${shard.id} Shard ${shard.id} Reconnecting!\x1b[0m");
		console.log(a);
		console.log(b);
	});
	shard.on("death", (a, b) => {
		console.log(`[\x1b[33mShardsManager\x1b[0m]\x1b[0m Shard ${shard.id} Dead!\x1b[0m`);
		console.log(a);
		console.log(b);
	});
});

manager.spawn({ timeout: Infinity });