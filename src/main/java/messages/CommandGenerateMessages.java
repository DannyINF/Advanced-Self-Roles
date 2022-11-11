package messages;

import util.PermissionChecker;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class CommandGenerateMessages {

    public static void generateMessages(SlashCommandInteractionEvent event, MessageType messageType, TextChannel textChannel) {
        event.deferReply(true).queue();
        if (!PermissionChecker.checkPermission(new Permission[]{Permission.ADMINISTRATOR}, event.getMember()))
            return;
        switch (messageType) {
            case GameRoles -> System.out.println("game roles");
            case OptOutGmod -> System.out.println("opt out");
        }
    }
}