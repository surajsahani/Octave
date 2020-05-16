package gg.octave.bot.commands.general

import kotlinx.coroutines.future.await
import me.devoxin.flight.api.Context
import me.devoxin.flight.api.annotations.Command
import me.devoxin.flight.api.entities.Cog
import net.dv8tion.jda.api.Permission

class General : Cog {
    @Command(aliases = ["invitebot", "add", "link", "links"], description = "Get a link to invite the bot to your server.")
    fun invite(ctx: Context) {
        val link = ctx.jda.getInviteUrl(Permission.ADMINISTRATOR)

        ctx.send {
            setColor(0x9570D3)
            setTitle("Add Octave to your server!")
            setDescription("__**[Click to invite Octave to your server.]($link)**__")
        }
    }

    @Command(aliases = ["pong", "hello????"], description = "Show the bot's current response time.")
    suspend fun ping(ctx: Context) {
        val latency = ctx.jda.restPing.submit().await()
        ctx.send(
            "```prolog\n" +
                "Shard ID: ${ctx.jda.shardInfo.shardId}\n" +
                "Latency (HTTP): ${latency}ms\n" +
                "Latency (WS  ): ${ctx.jda.shardManager!!.averageGatewayPing.toInt()}ms```"
        )
    }

    @Command(description = "Shows how to vote for the bot.")
    fun vote(ctx: Context) {
        ctx.send {
            setColor(0x9570D3)
            setTitle("Vote")
            setDescription(
                "Vote here to increase the visibility of the bot!\nIf you vote for Octave, you can get a normie box in Dank Memer everytime you vote too!\n" +
                    "**[Vote by clicking here](https://discordbots.org/bot/octave/vote)**"
            )
        }
    }

    @Command(aliases = ["supportserver"], description = "Shows a link to the support server.")
    fun support(ctx: Context) {
        ctx.send {
            setColor(0x9570D3)
            setTitle("Support Server")
            setDescription("[Join our support server by clicking here!](https://discord.gg/musicbot)")
        }
    }

    @Command(description = "Show the donation info.")
    fun donate(ctx: Context) {
        ctx.send {
            setColor(0x9570D3)
            setDescription("Want to donate to support Octave?\n**[Patreon](https://www.patreon.com/octavebot)**")
        }
    }
}
