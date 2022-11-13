package messages;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;
import util.PermissionChecker;

public class CommandGenerateMessages {

    public static void generateMessages(SlashCommandInteractionEvent event, MessageType messageType) {
        event.deferReply(true).queue();
        if (!PermissionChecker.checkPermission(new Permission[]{Permission.ADMINISTRATOR}, event.getMember()))
            return;
        System.out.println(Component.Type.BUTTON.getMaxPerRow());
        switch (messageType) {
            case GameRoles -> {
                event.getChannel().asGuildMessageChannel().sendMessage("Wähle, welche Spielrollen du willst:")
                        .addActionRow(
                                Button.of(ButtonStyle.PRIMARY, "pspieleabend", "Spieleabend"),
                                Button.of(ButtonStyle.PRIMARY, "poverwatch", "Overwatch"),
                                Button.of(ButtonStyle.PRIMARY, "pcsgo", "CS:GO"),
                                Button.of(ButtonStyle.PRIMARY, "plol", "League of Legends"),
                                Button.of(ButtonStyle.PRIMARY, "pamongus", "Among Us")
                        )
                        .addActionRow(
                                Button.of(ButtonStyle.PRIMARY, "prainbow", "Rainbow Six Siege")
                        ).queue();
            }
            case OptOutGmod -> {
                event.getChannel().asGuildMessageChannel().sendMessage("GMod Benachrichtigungen")
                        .addActionRow(
                                Button.primary("garrysmod", "GMod-Zugriff")
                        ).queue();
            }
            case OptInSpoiler -> {
                event.getChannel().asGuildMessageChannel().sendMessage("Spoilerchannel:")
                        .addActionRow(
                                Button.primary("ispoiler", "Spoilerchannel")
                        ).queue();
            }
        }
    }
}