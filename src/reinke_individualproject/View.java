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
    
    public int getUserAffinity(int userCombatStyleChoice){
        int userAffinity = 5;
        
            if (userCombatStyleChoice == 1) {
                String str = JOptionPane.showInputDialog("Hero, with which form of Magic do you fight?"
                        + "\n(0) for Fire Magic"
                        + "\n(1) for Ice Magic"
                        + "\n(2) for Lightning Magic");
                userAffinity = Integer.parseInt(str);
            }

            else if (userCombatStyleChoice == 0) {
                String str = JOptionPane.showInputDialog("Hero, with which weapon are you most proficient?"
                        + "\n(0) for the Spear"
                        + "\n(1) for the Sword"
                        + "\n(2) for the Bow");
                userAffinity = Integer.parseInt(str);
            }
        return userAffinity;
    }
    
    public int getUserConfirmation(String userAffinityChoice){
        String userConfirmationInput = JOptionPane.showInputDialog("You have selected " + userAffinityChoice
                        +"\nIs this correct?"
                        +"\n Enter (0) for No"
                        +"\n Enter (1) for Yes");
        int userConfirmationNum = Integer.parseInt(userConfirmationInput);
        return userConfirmationNum;
    }

    public void displayASCIIArt(String ASCIIArt){
        JOptionPane.showMessageDialog(null, ASCIIArt);
    }
    
    public void displayUserTitleAndQuarry(String creatureType, String userName, String playerCharacterTitle, String userAffinityChoice, String environment, String creatureDescription){
        JOptionPane.showMessageDialog(null, "You are "+userName + playerCharacterTitle +", master of "+userAffinityChoice+"."+
                "\nYou have come to "+environment+" to hunt a "+creatureType + creatureDescription);
    }

    public void beginCombat(String creatureType){//PLACEHOLDER NEEDS WORK
        JOptionPane.showMessageDialog(null, "Leelde leedle leedle lee Oh no, the "+creatureType+" confronts you!");
    }
    
    public int getUserAttackOrDefend(){
        String str = JOptionPane.showInputDialog("Will you attack the monster or defend yourself?"
                + "\nEnter (0) to defend yourself"
                + "\nEnter (1) to attack the monster");
        return Integer.parseInt(str);
    }
    
    public void combatTurnResults(int turnNumber, String flavorText){
        JOptionPane.showMessageDialog(null, "~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ Turn " + turnNumber + " ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n"+flavorText);
    }
    
    public void displayHealthTotals(double monsterHealth, double playerHealth){
        JOptionPane.showMessageDialog(null, "Monster Health: " + monsterHealth
            + "\nPlayer Health: " +playerHealth);
    }
    
    public void combatOutcomeMessage(double monsterHealth, double playerHealth, int turnCount){
        //PLAYER VICTORY
        if (playerHealth > 0.00){
            JOptionPane.showMessageDialog(null, "congration you're winner."
                    + "\nYou defeated the monster in "+turnCount+" turns"
                    + "\nwith "+playerHealth+" lifepoints remaining.");
        }
        //PLAYER DEFEAT
        else {
            JOptionPane.showMessageDialog(null, "You have been defeated!"
                    +"\nThough you fought valiantly"
                    +"\nand reduced the monster's  lifepoints to "+monsterHealth
                    +"\nyou had no lifepoints remaining.");
        }
    }
    
    public void displayUserScore(double userScore){
        JOptionPane.showMessageDialog(null, "Your score for this hunt is "+userScore);
    }
    
    public void displayHighScores(){
        
    }
    
    public int userPlayAgain(){
        String str = JOptionPane.showInputDialog("Would you like to embark on another hunt?"
            +"\n Enter (0) for No"
            +"\n Enter (1) for Yes");
        int userPlayAgain = Integer.parseInt(str);
        return userPlayAgain;
    }
    
    public void exitMessage(String userName, String playerCharacterTitle){
        JOptionPane.showMessageDialog(null,"So ends the song of " + userName + playerCharacterTitle
            +"\nAnd you close the Book of Heroes.");
    }

}
