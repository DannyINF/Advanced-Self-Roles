package listeners;

import core.STATIC;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.List;

public class ReactionListener extends ListenerAdapter {

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        event.deferEdit().queue();
        List<String> buttonIds = Arrays.asList("garrysmod", "pings", "interests", "gleitung", "gadmin", "gsmod", "gmod",
                "gsup", "gdev", "gteam", "gel", "gbalance", "gcc", "pspieleabend", "poverwatch", "pcsgo", "plol", "pamongus", "prainbow",
                "pciv6", "plotro", "pminecraft", "phearthstone",
                "ispoiler");

        List<String> roleIds = Arrays.asList(STATIC.CategoryGmod, STATIC.CategoryPings, STATIC.CategoryInterests,
                STATIC.GLeitung, STATIC.GAdmin, STATIC.GSMod, STATIC.GMod, STATIC.GSup, STATIC.GDev, STATIC.GTeam,
                STATIC.GEL, STATIC.GBalancing, STATIC.GCC, STATIC.PSpieleabend, STATIC.POverwatch, STATIC.PCSGO, STATIC.PLeagueOfLegends,
                STATIC.PAmongUs, STATIC.PRainbow, STATIC.PCiv6, STATIC.PLOTRO, STATIC.PMinecraft, STATIC.PHearthstone, STATIC.ISpoiler);

        int index = 0;
        if (buttonIds.contains(event.getButton().getId())) {
            index = buttonIds.indexOf(event.getButton().getId());
        }

        if (event.getMember().getRoles().contains(event.getGuild().getRoleById(roleIds.get(index))))
            event.getGuild().removeRoleFromMember(event.getMember().getUser(), event.getGuild().getRoleById(roleIds.get(index))).queue();
        else
            event.getGuild().addRoleToMember(event.getMember().getUser(), event.getGuild().getRoleById(roleIds.get(index))).queue();
    }
}
