package reinke_individualproject;

import java.util.Random;

public class Model {
    
/* --------------------------------------------- */
/* DECLARING VARIABLES & INSTANTIATING OBJECTS */
/* --------------------------------------------- */
    Random rand = new Random();
    private int randomEnvironmentNumber, userAffinity, userCombatStyleChoice;
    private String creatureType, environment, randomIntroText, environmentDescription, userName, ASCIIArt;
    
    String[] combatChoice = {"Melee Combat", "Magic Combat"};
    String[][] affinityChoice = { {"Spear", "Sword", "Bow"},
                                  {"Fire Magic", "Ice Magic", "Lightning Magic"} };
    
/* --------------------------------------------- */
/* RANDOM NUMBER GENERATORS */
/* --------------------------------------------- */
    
    public void generateEnvironment(){
        
        randomEnvironmentNumber = rand.nextInt(6);
        switch (randomEnvironmentNumber){
        
        case 0:
            environment = "the Thunder Peaks";
            creatureType = "Impundulu";
            environmentDescription = "\nSnowcapped peaks and the blade-sharp edges of mountains hem in the periphery of your vision."
                    + "\nThere is a rolling, growing roar in the distance though you cannot tell if it is thunder or an avalanche"
                    + "\nwhipped onward by the biting wind. Lightning arcs between the tips of the mountains like filaments of silk"
                    + "\nigniting and dying in a moment.";
            break;
            
        case 1:
            environment = "the Freezing Fjord";
            creatureType = "Salamander";
            environmentDescription = "\nThis place is not for the weak, and the landscape itself seems to challenge your existence."
                    + "\nThe Freezing Fjord is so different from anything you know as to be alien to you. Color ripples softly in the"
                    + "\nsky, like gossamer shrouds of green and blue flapping in the wind. It is a land of extremes; you would be cold"
                    + "\n were it not for the heat coming from the hot springs and distant, belching volcanoes.";
            break;
            
        case 2:
            environment = "the Gloamwood";
            creatureType = "Wendigo";
            environmentDescription = "\nThere is precious little to see in the Gloamwood besides trees and mist; light itself would be scarce"
                    + "\n were it not for your torch. It's cold enough it could snow, though you'd never know if it did; the canopy far, far"
                    + "\nabove would catch it, just like it catches all the light of the sun. Your feet squelch in heaps of moldering leaves"
                    + "\nas the mist about you seems to grow thicker.";
            break;
                        
        case 3:
            environment = "the Yawning Abyss";
            creatureType = "Manticore";
            environmentDescription = "\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
                    + "\net dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex"
                    + "\nea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat"
                    + "\nnulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim"
                    + "\nid est laborum.";
            break;
                        
        case 4:
            environment = "the Tazeem Jungle";
            creatureType = "Tiger";
            environmentDescription = "\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
                    + "\net dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex"
                    + "\nea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat"
                    + "\nnulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim"
                    + "\nid est laborum.";
            break;
                        
        case 5:
            environment = "the Sea of Sand";
            creatureType = "Spitting Cobra";
            environmentDescription = "\nSands so white they hurt the eyes stretch for miles in any direction. You wonder if they ever end."
                    + "\nIt's good you've brought water, because the Sea of Sand is inhospitable a place as you've ever been, and you will"
                    + "\n be glad when your quarry is dead at your feet.";
            break;
            
        default:
            environment = "Uh-oh, something's gone wrong!";
            break;
        }
    }
    
    public void generateIntroText(){
        int randomIntroTextNum = rand.nextInt(6);
        switch(randomIntroTextNum){
            case 0:
                randomIntroText = "You awake at dawn in ";
                break;
            case 1:
                randomIntroText = "You are hunting a ferocious beast in ";
                break;
            case 2:
                randomIntroText = "You wake with a start to the distant keening of some unseen creature in ";
                break;
            case 3:
                randomIntroText = "You hate that you've been sent to ";
                break;
            case 4:
                randomIntroText = "You find yourself marooned, with no memory, alone in ";
                break;
            case 5:
                randomIntroText = "You look over your shoulder, again. Alone, still, but you have decided you do not like ";
                break;
            case 6:
                randomIntroText = "This quest has been wearing at your skill and patience in the ";
                break;
            case 7:
                randomIntroText = "You stop for a rest and a meal, unsure when you may have another moment's respite in ";
                break;
        }
    }
    
/* --------------------------------------------- */
/* GETTERS AND SETTERS */
/* --------------------------------------------- */
    
    public String getEnvironment(){
        return environment;
    }
    
    public String getCreatureType(){
        return creatureType;
    }
    
    public String getRandomIntroText(){
        return randomIntroText;
    }
    
    public String getEnvironmentDescription(){
        return environmentDescription;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getUserName() {
        return userName;
    }

    public int getUserCombatStyleChoice() {
        return userCombatStyleChoice;
    }

    public void setUserCombatStyleChoice(int userCombatStyleChoice) {
        this.userCombatStyleChoice = userCombatStyleChoice;
    }

    public int getUserAffinity() {
        return userAffinity;
    }

    public void setUserAffinity(int userAffinity) {
        this.userAffinity = userAffinity;
    }
    
    public String getUserAffinityChoice(){
        return affinityChoice[userCombatStyleChoice][userAffinity];
    }
    
/* --------------------------------------------- */
/* ASCII ART AND FALVOR TEXT TO DISPLAY AFTER    */
/* USER CONFIRMS THEIR COMBAT STYLE & AFFINITY   */
/* --------------------------------------------- */
    
    public String generateASCIIArt(){

        if(userCombatStyleChoice == 0 && userAffinity == 0){
        ASCIIArt = ("");
        }        
        else if(userCombatStyleChoice == 0 && userAffinity == 1){
        ASCIIArt = ( "\"[after giving Arya her sword] First lesson: stick them with the pointy end,\""
                + "\n--Jon Snow, Game of Thrones, S01 E02"
                +"\n\n_________---~~~/\\______________________________,.......-----\"\"\"\"¯¯¯,,,\n" +
"|/VVVVVVVVVVV|====================---------------------------,,,,,,’’’ \n" +
"¯¯¯¯¯¯¯¯¯\"\"~~~\\/¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        }        
        else if(userCombatStyleChoice == 0 && userAffinity == 2){
        ASCIIArt = ("\"Every aspect of human technology has a dark size, including the bow and arrow,\""
                + "\n--Margaret Atwood");
        }        
        else if(userCombatStyleChoice == 1 && userAffinity == 0){
        ASCIIArt = ("\"	Fire is always dancing, leaping and whirling, seeking more fuel. It never rests, so why should I?\""
                + "\n--Chandra Nalaar, Wildfire Elemental, Magic 2020");
        }        
        else if(userCombatStyleChoice == 1 && userAffinity == 1){
        ASCIIArt = ("\"If you're skating on thin ice, you might as well dance,\""
                + "\n--Anita Shreve");
        }
        else if(userCombatStyleChoice == 1 && userAffinity == 2){
        ASCIIArt =  ("\"If Lightning is the anger of the gods, then the gods are"
                + "\nmostly concerned with trees,\" - Lao Tzu"
                + "\n\n              zeeeeee-\n" +
"            z$$$$$$\"\n" +
"           d$$$$$$\"\n" +
"          d$$$$$P\n" +
"         d$$$$$P\n" +
"      .$$$$$$\"\n" +
"     .$$$$$$\"\n" +
"    4$$$$$$$$$$$$$\"\n" +
"   z$$$$$$$$$$$$$\"\n" +
"   \"\"\"\"\"\"\"3$$$$$\"\n" +
"         z$$$$P\n" +
"        d$$$$\"\n" +
"     z$$$$$\"\n" +
"    z$$$$P\n" +
"   d$$$$$$$$$$\"\n" +
"  *******$$$\"\n" +
"       .$$$\"\n" +
"     4$P\"\n" +
"    z$\"\n" +
"   zP\n" +
"  z\"\n" +
" /    Gilo94'\n" +
"^");
        }
        
        else ASCIIArt = ("Rut Row, something went wrong");
        
        return ASCIIArt;
    }
    
}
