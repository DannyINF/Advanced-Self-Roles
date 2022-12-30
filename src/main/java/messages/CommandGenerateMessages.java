package messages;

import core.STATIC;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;
import util.PermissionChecker;

import java.awt.*;

public class CommandGenerateMessages {

    public static void generateMessages(SlashCommandInteractionEvent event, MessageType messageType) {
        event.deferReply(true).queue();
        if (!PermissionChecker.checkPermission(new Permission[]{Permission.ADMINISTRATOR}, event.getMember()))
            return;
        switch (messageType) {
            case GameRoles -> {
                EmbedBuilder builder = new EmbedBuilder();
                builder.setDescription("Du möchtest benachrichtigt werden, wenn auf diesem Server deine Lieblingsspiele gespielt werden? Dann hol' dir hier die Spielerollen!");
                builder.setFooter("(Mit einem erneuten Klick auf den Button verlierst du die Rolle wieder.)");
                builder.setTitle("Pingbare Spielerollen");
                builder.setColor(Color.ORANGE);
                event.getChannel().asGuildMessageChannel().sendMessageEmbeds(builder.build())
                        .addActionRow(
                                Button.of(ButtonStyle.PRIMARY, "pspieleabend", "Spieleabend")
                        )
                        .addActionRow(
                                Button.of(ButtonStyle.PRIMARY, "poverwatch", STATIC.Overwatch),
                                Button.of(ButtonStyle.PRIMARY, "pcsgo", STATIC.CSGO),
                                Button.of(ButtonStyle.PRIMARY, "plol", STATIC.LoL),
                                Button.of(ButtonStyle.PRIMARY, "pamongus", STATIC.AmongUs),
                                Button.of(ButtonStyle.PRIMARY, "prainbow", STATIC.Rainbow)
                        )
                        .addActionRow(
                                Button.of(ButtonStyle.PRIMARY, "pciv6", STATIC.Civ6),
                                Button.of(ButtonStyle.PRIMARY, "plotro", STATIC.LOTRO),
                                Button.of(ButtonStyle.PRIMARY, "pminecraft", STATIC.Minecraft),
                                Button.of(ButtonStyle.PRIMARY, "phearthstone", STATIC.Hearthstone)
                        ).queue();
            }
            case OptOutGmod -> {
                EmbedBuilder builder = new EmbedBuilder();
                builder.setDescription("\"Herr der Ringe\"-RP auf unserem Garry's Mod Server ist nichts für dich? Hier kannst du den gesamten Bereich verstecken!");
                builder.setFooter("(Mit einem erneuten Klick auf den Button bekommst du die Rolle wieder.)");
                builder.setTitle("Kein Garry's Mod");
                builder.setColor(Color.getColor("#0081ff"));
                event.getChannel().asGuildMessageChannel().sendMessageEmbeds(builder.build())
                        .addActionRow(
                                Button.primary("garrysmod", STATIC.GarrysMod)
                        ).queue();
            }
            case OptInSpoiler -> {
                EmbedBuilder builder = new EmbedBuilder();
                builder.setDescription("Du willst an Diskussionen rund um aktuelle Veröffentlichungen teilnehmen? Dann hol' dir hier den Zugriff!");
                builder.setFooter("(Mit einem erneuten Klick auf den Button verlierst du die Rolle wieder.)");
                builder.setTitle("Zugriff Spoilerchannel");
                builder.setColor(Color.getColor("#8B0000")); // dark red
                event.getChannel().asGuildMessageChannel().sendMessageEmbeds(builder.build())
                        .addActionRow(
                                Button.primary("ispoiler", "Spoilerchannel")
                        ).queue();
            }
        }
    }
}