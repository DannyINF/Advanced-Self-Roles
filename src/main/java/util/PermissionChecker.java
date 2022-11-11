package util;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class PermissionChecker {
    public static boolean checkPermission(Permission[] permission, Member member) {
        boolean hasPermission = true;
        for (Permission perm : permission) {
            if (!member.hasPermission(perm)) {
                hasPermission = false;
            }
        }
        return hasPermission;
    }

    public static void noPower(TextChannel textChannel, Member member) {
        textChannel.sendMessage(member.getAsMention() + " https://giphy.com/gifs/RX3vhj311HKLe").queue();
    }

    public static void noPower(SlashCommandInteractionEvent event) {
        event.reply("https://giphy.com/gifs/RX3vhj311HKLe").queue();
    }
}
