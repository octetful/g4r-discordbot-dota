
import com.jessecorbett.diskord.api.model.Message
import com.jessecorbett.diskord.dsl.Bot
import com.jessecorbett.diskord.dsl.bot
import com.jessecorbett.diskord.dsl.command
import com.jessecorbett.diskord.dsl.commands

object G4RDotaDiscordBot {
    fun getBotToken(): String = System.getenv("G4R_BOT_TOKEN") ?: "UNKNOWN"

    fun reactToMessage(message: Message): String? = when {
        message.content.contains("G4RBot", true) -> "\uD83E\uDD16"
        else -> null
    }

    fun replyToMessage(message: Message): String? = when {
        message.content.contains("G4RBot", true) -> "Beep bop boop"
        else -> null
    }

    public fun botResponder(): Bot.() -> Unit = {
        messageCreated {
            val reaction = reactToMessage(it)
            if ( reaction != null ) {
                it.react(reaction)
            }

            val msgReply = replyToMessage(it)
            if ( msgReply != null ) {
                it.reply(msgReply)
            }
        }
        commands("!") {
            command("ping") {
                reply("pong")
                delete()
            }
        }
    }
}

suspend fun main() {
    bot(G4RDotaDiscordBot.getBotToken(), block = G4RDotaDiscordBot.botResponder())
}


