package core;

import listeners.ReactionListener;
import listeners.ReadyListener;
import listeners.RoleChangeListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import util.SlashCommandHandler;

import java.io.IOException;

import static net.dv8tion.jda.api.interactions.commands.OptionType.*;

public class Main {
    private static JDABuilder builder;

    public static JDA jda;

    public static void main(String[] args) throws InterruptedException, IOException {

        builder = JDABuilder.create(SECRETS.TOKEN,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.GUILD_MESSAGES);
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.of(Activity.ActivityType.PLAYING, "roling"));

        addListeners();

        jda = builder.build();
        jda.awaitReady();

        addSlashCommands(jda);

    }


    private static void addListeners() {
        builder.addEventListeners(new ReadyListener());
        builder.addEventListeners(new RoleChangeListener());
        builder.addEventListeners(new ReactionListener());
        builder.addEventListeners(new SlashCommandHandler());
    }

    private static void addSlashCommands(JDA jda) {
        jda.updateCommands()
                .addCommands(Commands.slash("generate", "Postet eine Nachricht zum Reagieren.")
                        .addOptions(new OptionData(STRING, "messagetype", "Welche Nachricht gesendet werden soll.")
                                .addChoice("Spielerollen", "GameRoles")
                                .addChoice("GMod", "OptOutGmod")
                                .addChoice("Spoiler", "OptInSpoiler")))
                .queue();
    }
}