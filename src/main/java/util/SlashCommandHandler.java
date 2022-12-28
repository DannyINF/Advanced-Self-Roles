package util;

import core.STATIC;
import messages.CommandGenerateMessages;
import messages.MessageType;
import net.dv8tion.jda.api.entities.Member;
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
                case "generate" ->
                        CommandGenerateMessages.generateMessages(event, MessageType.valueOf(event.getOption("messagetype").getAsString()));
                case "init" -> {
                    event.deferReply().queue();
                    int counter = 0;
                    for (Member member : event.getGuild().getMembers())
                        if (member.getRoles().contains(event.getGuild().getRoleById(STATIC.CategoryGmod))) {
                            try {
                                event.getGuild().addRoleToMember(member, event.getGuild().getRoleById(STATIC.CategoryGmod)).queue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                break;
                            }
                            Thread.sleep(250);
                            counter++;
                        }
                    System.out.println("Weitere " + counter + " Rollen vergeben.");
                }
            }
        } catch (Exception ignored) {
        }
    }
}