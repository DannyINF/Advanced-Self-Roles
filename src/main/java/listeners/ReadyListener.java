package listeners;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {

    private long members = 0L;

    public void onReady(ReadyEvent event) {

        StringBuilder out = new StringBuilder("\nThis bot is running on following servers: \n");
        for (Guild guild : event.getJDA().getGuilds()) {
            out.append(guild.getName()).append("\n");
            members += guild.getMemberCount();
        }

        System.out.println(out);
        System.out.println("\nInsgesamte Nutzeranzahl: " + members);
    }
}