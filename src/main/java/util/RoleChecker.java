package util;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

public class RoleChecker {
    public static boolean hasRoles(Member member, Role[] roles) {
        for (Role role : roles) {
            if (!member.getRoles().contains(role))
                return false;
        }
        return true;
    }
}