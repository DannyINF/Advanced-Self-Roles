package util;

import messages.CommandGenerateMessages;
import messages.MessageType;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandHandler extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        // Only accept commands from guilds
        if (event.getGuild() == null)
            return;

        try {
            switch (event.getName()) {
                case "generate":
                    CommandGenerateMessages.generateMessages(event, MessageType.valueOf(event.getOption("messagetype").getAsString()));
                    break;
            }
        } catch (Exception ignored) {
        }
    }
}