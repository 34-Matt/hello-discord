package TestBot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class MyEvents {

    int error;

    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) {
        error = 0;

        // Given a message "/test arg1 arg2", argArray will contain ["/test", "arg1", "arg"]
        String[] argArray = event.getMessage().getContent().split(" ");

        // First ensure at least the command and prefix is present, the arg length can be handled by your command func
        if (argArray.length == 0) {
            return;
        }

        // Check if the first arg (the command) starts with the prefix defined in the utils class
        if (!argArray[0].startsWith(BotUtils.BOT_PREFIX)) {
            return;
        }

        // Extract the "command" part of the first arg out by just ditching the first character
        String commandStr = argArray[0].substring(1);

        switch (commandStr) {
            case "roll":
            case "r":
                // Uses the roll a dice 
                BotUtils.sendMessage(event.getChannel(),RollDice(argArray));
                break;
        }

        switch (error) {
            case 1:
                BotUtils.sendMessage(event.getChannel(), "There an array size error detected in your last request.");
                break;
        }
    }

    
    
    
    
    private String RollDice(String[] argArray){
        String message;
        int[] values;
        
        if (argArray.length <= 1) {
            return "You rolled a 0 on your 0 dice roll.";
        }

        message = "Roll Results: ";
        
        int sum = 0;
        int roll20 = 0;

        for (int i = 1; i < argArray.length; i++) {
            if (argArray[i].contains("d")) {
                String[] numArrayS = argArray[i].split("d");

                if (numArrayS.length != 2) {
                    error = 1;
                    return "There was an array size error detected in your last request";
                }
                
                values = EventUtil.rollDice(Integer.parseInt(numArrayS[0]), Integer.parseInt(numArrayS[1]));
                
                for (int j = 1; j < values.length; j++) {
                    int result = values[j];
                    
                    message += result;
                    sum += result;
                    
                    if (result == 2 && values[0] == 20) {
                        roll20 += 1;
                    }

                    if(j != values.length-1){
                        message += " + ";
                    }
                }
            } else {
                int num = Integer.parseInt(argArray[i]);
                message += num;
                sum += num;
            }
            
            if(i != argArray.length-1){
                message += " + ";
            }
        }

        message += "\nYou rolled a " + sum;
        
        if (roll20 != 0) {
            message += "\nYou rolled " + roll20 + " twos on your d20 rolls.";
        }
        return message;
    }
}