package listeners;

import core.STATIC;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import util.RoleManager;

import java.util.Arrays;
import java.util.List;

public class RoleChangeListener extends ListenerAdapter {
    @Override
    public void onGuildMemberRoleAdd(GuildMemberRoleAddEvent event) {
        updateMemberRoles(event.getMember());
    }

    @Override
    public void onGuildMemberRoleRemove(GuildMemberRoleRemoveEvent event) {
        updateMemberRoles(event.getMember());
    }

    public static void updateMemberRoles(Member member) {
        List<String> categories = Arrays.asList(STATIC.CategoryPings, STATIC.CategoryInterests);

        for (String category : categories) {
            boolean shouldHaveCategory = RoleManager.hasRoleOfCategory(member.getRoles(), category);
            boolean hasCategory = member.getRoles().contains(member.getGuild().getRoleById(category));
            if (!shouldHaveCategory && hasCategory)
                member.getGuild().removeRoleFromMember(member.getUser(), member.getGuild().getRoleById(category)).queue();
            else if (shouldHaveCategory && !hasCategory)
                member.getGuild().addRoleToMember(member.getUser(), member.getGuild().getRoleById(category)).queue();
        }

        boolean hasGmod = member.getRoles().contains(member.getGuild().getRoleById(STATIC.CategoryGmod));
        boolean shouldHaveGmod = RoleManager.hasRoleOfCategory(member.getRoles(), STATIC.CategoryGmod);
        if (!hasGmod && shouldHaveGmod)
            member.getGuild().addRoleToMember(member.getUser(), member.getGuild().getRoleById(STATIC.CategoryGmod)).queue();
    }
}
