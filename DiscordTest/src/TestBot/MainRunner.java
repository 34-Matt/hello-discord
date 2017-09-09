package TestBot;

import java.util.Scanner;
import sx.blah.discord.api.IDiscordClient;

public class MainRunner {
    
    private static String tocken;
    private static Scanner input;
    
    public static void main(String[] args){

        input = new Scanner(System.in);
        
        if(args.length != 1){
            System.out.println("Please enter the bots token");
            tocken = input.nextLine();
        }else{
            tocken = args[0];
        }

        IDiscordClient cli = BotUtils.getBuiltDiscordClient(tocken);

        /*
        // Commented out as you don't really want duplicate listeners unless you're intentionally writing your code 
        // like that.
        // Register a listener via the IListener interface
        cli.getDispatcher().registerListener(new IListener<MessageReceivedEvent>() {
            public void handle(MessageReceivedEvent event) {
                if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "test"))
                    BotUtils.sendMessage(event.getChannel(), "I am sending a message from an IListener listener");
            }
        });
        */

        // Register a listener via the EventSubscriber annotation which allows for organisation and delegation of events
        cli.getDispatcher().registerListener(new MyEvents());

        // Only login after all events are registered otherwise some may be missed.
        cli.login();

    }

}