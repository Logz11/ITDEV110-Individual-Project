package reinke_individualproject;

import javax.swing.JOptionPane;

public class View {
    
    public void titleScreen(){
        JOptionPane.showMessageDialog(null, "   ______________________________\n" +
" /---\\_____________________________\\.\n" +
"|-----|____________________________|.\n" +
" \\----|____________________________|.\n" +
".....|______WELCOME_____________|.\n" +
"....|____________________________|.\n" +
".....|________TO__________________|.\n" +
"......|_____________________________|.\n" +
".....|_________ROCK,______________|.\n" +
"....|_____________________________|.\n" +
".....|_____PAPER,_________________|.\n" +
"....|_____________________________|.\n" +
".....|_________FIREBALL___________|.\n" +
"...|______________________________|__\n" +
"....|----/____________________________/.\n" +
"....\\__/dc__________________________/.");
    }
    
    
    
    public void introduction(String randomIntroText, String environment, String environmentDescription){
        JOptionPane.showMessageDialog(null, randomIntroText + environment + ". " + environmentDescription);
    }
    
    public String getUserName(){
        return JOptionPane.showInputDialog("What is your name, hero?");
    }
    
    public int getUserCombatStyleChoice(){
        String str = JOptionPane.showInputDialog("What style of combat do you choose to fight with?"
                + "\nPlease enter a number to choose:"
                + "\n(0) for Melee Combat"
                + "\n(1) for Magic Combat");
        int userCombatStyleChoice = Integer.parseInt(str);
        return userCombatStyleChoice;
    }
    
    public int getUserAffinity(int userCombatStyleChoice, String userAffinityChoice){
        int userAffinity = 2, userConfirmationNum = 1;
        String userConfirmationInput;
        do {
            if (userCombatStyleChoice == 1) {
                String str = JOptionPane.showInputDialog("Hero, with which form of Magic do you fight?"
                        + "\n(0) for Fire Magic"
                        + "\n(1) for Ice Magic"
                        + "\n(2) for Lightning Magic");
                userAffinity = Integer.parseInt(str);
                userConfirmationInput = JOptionPane.showInputDialog("You have selected " + userAffinityChoice
                        +"\nIs this correct?"
                        +"\n Enter (0) for No"
                        +"\n Enter (1) for Yes");
                userConfirmationNum = Integer.parseInt(userConfirmationInput);
                
            }

            else if (userCombatStyleChoice == 0) {
                String str = JOptionPane.showInputDialog("Hero, with which weapon are you most proficient?"
                        + "\n(0) for the Spear"
                        + "\n(1) for the Sword"
                        + "\n(2) for the Bow");
                userAffinity = Integer.parseInt(str);
                userConfirmationInput= JOptionPane.showInputDialog("You have selected " + userAffinityChoice
                        +"\nIS this correct?"
                        +"\n Enter (0) for No"
                        +"\n Enter (1) for Yes");
                userConfirmationNum = Integer.parseInt(userConfirmationInput);
            }
        }
        
        while (userConfirmationNum != 1 );

        return userAffinity;
    }
    
    public void displayASCIIArt(String ASCIIArt){
        JOptionPane.showMessageDialog(null, ASCIIArt);
    }
    

    
    public void getCreatureType(String creatureType){
        JOptionPane.showMessageDialog(null, creatureType);
    }
    
    
}
