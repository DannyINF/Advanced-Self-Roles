package util;

import core.STATIC;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RoleManager {

    private static final Map<String, String> roleToCategory = Map.ofEntries(

            // Gmod
            Map.entry(STATIC.GLeitung, STATIC.CategoryGmod),
            Map.entry(STATIC.GAdmin, STATIC.CategoryGmod),
            Map.entry(STATIC.GSMod, STATIC.CategoryGmod),
            Map.entry(STATIC.GMod, STATIC.CategoryGmod),
            Map.entry(STATIC.GSup, STATIC.CategoryGmod),
            Map.entry(STATIC.GFAdmin, STATIC.CategoryGmod),
            Map.entry(STATIC.GDev, STATIC.CategoryGmod),
            Map.entry(STATIC.GTeam, STATIC.CategoryGmod),
            Map.entry(STATIC.GFTeam, STATIC.CategoryGmod),
            Map.entry(STATIC.GEL, STATIC.CategoryGmod),
            Map.entry(STATIC.GBalancing, STATIC.CategoryGmod),
            Map.entry(STATIC.GCC, STATIC.CategoryGmod),

            // Pings
            Map.entry(STATIC.CategoryPings, STATIC.CategoryPings),
            Map.entry(STATIC.PSpieleabend, STATIC.CategoryPings),
            Map.entry(STATIC.POverwatch, STATIC.CategoryPings),
            Map.entry(STATIC.PCSGO, STATIC.CategoryPings),
            Map.entry(STATIC.PLeagueOfLegends, STATIC.CategoryPings),
            Map.entry(STATIC.PAmongUs, STATIC.CategoryPings),
            Map.entry(STATIC.PRainbow, STATIC.CategoryPings),
            Map.entry(STATIC.PCiv6, STATIC.CategoryPings),
            Map.entry(STATIC.PLOTRO, STATIC.CategoryPings),
            Map.entry(STATIC.PMinecraft, STATIC.CategoryPings),
            Map.entry(STATIC.PHearthstone, STATIC.CategoryPings),
            Map.entry(STATIC.CategoryGmod, STATIC.CategoryPings),

            // Interests
            Map.entry(STATIC.CategoryInterests, STATIC.CategoryInterests),
            Map.entry(STATIC.ISpoiler, STATIC.CategoryInterests)
    );

    public static boolean hasRoleOfCategory(List<Role> roles, String categoryId) {
        List<String> rolesOfCategory = getAllKeysForValue(roleToCategory, categoryId);
        rolesOfCategory.remove(categoryId);
        for (Role role : roles) {
            if (rolesOfCategory.contains(role.getId()))
                return true;
        }
        return false;
    }

    static <K, V> List<K> getAllKeysForValue(Map<K, V> mapOfWords, V value) {
        List<K> listOfKeys = null;

        //Check if Map contains the given value
        if (mapOfWords.containsValue(value)) {
            // Create an Empty List
            listOfKeys = new ArrayList<>();

            // Iterate over each entry of map using entrySet
            for (Map.Entry<K, V> entry : mapOfWords.entrySet()) {
                // Check if value matches with given value
                if (entry.getValue().equals(value)) {
                    // Store the key from entry to the list
                    listOfKeys.add(entry.getKey());
                }
            }
        }
        // Return the list of keys whose value matches with given value.
        return listOfKeys;
    }
}