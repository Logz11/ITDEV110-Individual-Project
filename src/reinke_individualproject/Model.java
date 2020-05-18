package reinke_individualproject;

import java.util.Random;

public class Model {
    
/* --------------------------------------------- */
/* DECLARING VARIABLES & INSTANTIATING OBJECTS */
/* --------------------------------------------- */
    Random rand = new Random();
    private final double INITIAL_HEALTH = 50.00;
    private double playerHealth = INITIAL_HEALTH, monsterHealth = INITIAL_HEALTH,
            damageModifier, monsterDefenseValue, playerDefenseValue, playerAttackValue, monsterAttackValue, 
            userScore, scoreModifier;
    private int randomEnvironmentNumber, userAffinity, userCombatStyleChoice, combatFlavorTextNum,
            combatLoopCounter = 0;
    private String creatureType, creatureDescription, environment, randomIntroText, environmentDescription, 
            userName, defenseOutcome, combatFlavorText, highScoreStringConcat = "";
    private boolean playerHasAdvantage = false, monsterHasAdvantage = false, monsterAttack = true, playerAttack = true;
    
    private final String[] combatChoice = {"Melee Combat", "Magic Combat"};
    private final String[][] affinityChoice = { {"the Spear", "the Sword", "the Bow"},
                                  {"Fire Magic", "Ice Magic", "Lightning Magic"} };
    private final String[][] playerCharacterTitle = { {" the Jouster", " the Gladiator", " the Eagle-Eyed Archer"}, 
                                        {" the Pyromancer", " the Coldbringer", " the Storm Itself"} };
    
    //TWO PARALLEL ARRAYS INITIALIZED WITH SEED DATA TO RECORD HIGH SCORES
    private double[] highScoreValues = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 0.0};
    private String[] highScorerNames = {"A Mysterious Stranger", "The Chosen One", "The Evil Overlord",
                                    "The Reluctant Hero", "The Lucky Novice", "Collin",
                                    "An Obnoxious Bard", "A Weary Soldier", "A Poorly Disguised Assassin",
                                    "The Overconfident Protagonist", ""};
/* --------------------------------------------- */
/* RANDOM NUMBER GENERATORS */
/* --------------------------------------------- */
    
    public void generateEnvironment(){
        
        randomEnvironmentNumber = rand.nextInt(6);
        switch (randomEnvironmentNumber){
        //CREATURE AND EVNIRONMENT HAVE EXCLUSIVE RELATIONSHIP
        case 0:
            //MONSTER = LIGHTNING
            environment = "the Thunder Peaks";
            creatureType = "Impundulu";
            environmentDescription = "\nSnowcapped peaks and the blade-sharp edges of mountains hem in the periphery of your vision."
                    + "\nThere is a rolling, growing roar in the distance though you cannot tell if it is thunder or an avalanche"
                    + "\nwhipped onward by the biting wind. Lightning arcs between the tips of the mountains like filaments of silk"
                    + "\nigniting and dying in a moment.";
            creatureDescription= ",\na savage thunderbird that summons bolts of lightning"
                    + "\nand gale winds with the beating of its massive wings."
                    + "\nThose who weather the Impundulu's storm will have to contend"
                    + "\n with the needle sharp beak the beast uses to skewer"
                    + "\nits victims and drain their blood.";
            break;
            
        case 1:
            //MONSTER = FIRE
            environment = "the Freezing Fjord";
            creatureType = "Salamander";
            environmentDescription = "\nThis place is not for the weak, and the landscape itself seems to challenge your existence."
                    + "\nThe Freezing Fjord is so different from anything you know as to be alien to you. Color ripples softly in the"
                    + "\nsky, like gossamer shrouds of green and blue flapping in the wind. It is a land of extremes; you would be cold"
                    + "\n were it not for the heat coming from the hot springs and distant, belching volcanoes.";
            creatureDescription =",\na stranger and unwelcome guest in these parts."
                    + "\nPerhaps a wizard's familiar grown large enough to escape its captivity,"
                    + "\nthe Salamander is a reptilian spirit of fire at home in coals or ash."
                    + "\nThe volcanoes here provide ample feeding ground, but so far"
                    + "\nfrom the Salamander's natural habitat has allowed it to grow"
                    + "\nfar beyond what could be considered natural. It must be put down.";
            break;
            
        case 2:
            //MONSTER = ICE
            environment = "the Gloamwood";
            creatureType = "Wendigo";
            environmentDescription = "\nThere is precious little to see in the Gloamwood besides trees and mist; light itself would be scarce"
                    + "\n were it not for your torch. It's cold enough it could snow, though you'd never know if it did; the canopy far, far"
                    + "\nabove would catch it, just like it catches all the light of the sun. Your feet squelch in heaps of moldering leaves"
                    + "\nas the mist about you seems to grow thicker.";
            creatureDescription =",\na terrible corruption of the natural order."
                    + "\nLegend says the Wendigo was human once, but was transformed"
                    + "\ninto a beast after committing a grave sin against the ones it loved."
                    + "\nWhat is known for certain, though, is that the Wendigo is a bottomless"
                    + "\npit of gluttony. It will consume everything in its territory until nothing remains.";
            break;
                        
        case 3:
            //MONSTER = SPEAR
            environment = "the Yawning Abyss";
            creatureType = "Manticore";
            environmentDescription = "\nYou cannot imagine a less inviting place than these caves."
                    + "\nSo quiet is the Yawning Abyss that you find yourself jumping at"
                    + "\nthe inconsistent sound of drops of water striking the marble of the floor."
                    + "\nIt is a maw filled with knives, and as your torch glints from the dagger"
                    + "\npoints of jagged stalactites, your mind is drawn inexorably back"
                    + "\nto your quarry.";
            creatureDescription =",\na mythical abomination terrorizing a nearby village."
                    + "\nThe only winning move against a Manticore is to forgo fightning"
                    + "\none at all. With wings to fly and the powerful body of a tiger,"
                    + "\nno place but the grave is truly safe from the beast. Should you"
                    + "\navoid the Manticore's tiger-like fangs and claws, you'll still"
                    + "\nhave to contend with its stinging scorpion tail, oozing venom"
                    + "\nstrong enough to lay low an elephant; just the sort of challenge you like.";
            break;
                        
        case 4:
            //MONSTER = SWORD
            environment = "the Tazeem Jungle";
            creatureType = "Feathered Raptor";
            environmentDescription = "\nA lush, warm realm ruled by a King named"
                    + "\n\"Survival of the Fittest\". In this paradise, life itself is malignant"
                    + "\nand each new sight is somehow more vicious than the last:"
                    + "\ntall trees strangle new saplings; leeches devour living anything"
                    + "\nthat rests for too long; tigers and panthers stalk what does not."
                    + "\nThere are no laws here, no man, no mercy, no gods. In the Tazeem"
                    + "\nJungle there is only the rule of the sword.";
            creatureDescription =",\na remnant of an age that was already ancient"
                    + "\nat the dawn of man. How this creature has survived so long"
                    + "\npast its kin is a terrifying mystery in and of itself, but"
                    + "\nyou doubt its temperment has been mellowed by time;"
                    + "\ntime will have turned this already famously vicious predator"
                    + "\ninto something truly lethal.";
            break;
                        
        case 5:
            //MONSTER = BOW
            environment = "the Sea of Sand";
            creatureType = "Spitting Cobra";
            environmentDescription = "\nSands so white they hurt the eyes stretch for miles in any direction. You wonder if they ever end."
                    + "\nIt's good you've brought water, because the Sea of Sand is inhospitable a place as you've ever been, and you will"
                    + "\n be glad when your quarry is dead at your feet.";
            creatureDescription =",\nan opportunistic hunter given easy prey by caravans"
                    + "\nof traders traversing the Sea of Sand. Traders, merchants,"
                    + "\nand even local farmers have assembled an acceptable reward for"
                    + "\nslaying the serpent and you've come to try your hand. They"
                    + "\nwere kind enough to include a visor for your eyes, suitable"
                    + "\nfor the sun or venom. You'll surely need it, as you've been"
                    + "\ntold the Spitting Cobra prefers to fight from afar until its"
                    + "\nprey has been blinded. Then it strikes a mortal blow.";
            break;
            
        default:
            environment = "Uh-oh, something's gone wrong!";
            break;
        }
    }
    
    public void generateIntroText(){
        //RANDOM INTRODUCTION FLAVOR TEXT
        int randomIntroTextNum = rand.nextInt(8);
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
    
    public String getCreatureDescription(){
        return creatureDescription;
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
    
    public String getPlayerCharacterTitle(){
        return playerCharacterTitle[userCombatStyleChoice][userAffinity];
    }
    
    public String getPlayerNameAndTitleForScore(){
        return userName +","+ playerCharacterTitle[userCombatStyleChoice][userAffinity];
    }
    
    public void setUserAttackOrDefend(int userAttackOrDefend){
        if(userAttackOrDefend == 0){
            this.playerAttack = false;
        }
        else {
            this.playerAttack = true;
        }
    }
    
    public double getPlayerHealth(){
        return playerHealth;
    }
    
    public double getMonsterHealth(){
        return monsterHealth;
    }
    
    public int getCombatLoopCounter(){
        return combatLoopCounter;
    }
    
    public String getCombatFlavorText(){
        return combatFlavorText;
    }
    public double getUserScore(){
        return userScore;
    }
    
    public String getHighScores(){
        //CONCATENATES ALL THE PARALLEL ARRAYS INTO ONE HIGH SCORE DISPLAY
        for(int i = 0; i < 10; i++){
            highScoreStringConcat += highScorerNames[i] + "  |      "+highScoreValues[i];
            highScoreStringConcat += "\n";
        }
        return highScoreStringConcat;
    }
    
/* --------------------------------------------- */
/* ASCII ART AND FALVOR TEXT TO DISPLAY AFTER    */
/* USER CONFIRMS THEIR COMBAT STYLE & AFFINITY   */
/* WARNING - REPLACED BY GENERATEART.JAVA        */    
/* --------------------------------------------- */
    
    /*public String generateASCIIArt(){

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
        
        else ASCIIArt = ("Error in Model.generateASCIIArt");
        
        return ASCIIArt;
    }*/
    
/* --------------------------------------------- */
/* COMBAT DAMAGE CALCULATOR, DETERMINING WHO HAS */
/* ADVANTAGE, RNG FOR MONSTER'S DEFENSE SEQUENCE */
/* MONSTER & PLAYER HEALTH ACCUMULATORS          */    
/* --------------------------------------------- */
    
    public void determineAdvantage(){
        
        //MONSTER LIGHTNING VS. PLAYER SWORD: SWORD > LIGHTNING = PLAYER ADVANTAGE
        if(randomEnvironmentNumber == 0 && userCombatStyleChoice == 0 && userAffinity == 1){
            playerHasAdvantage = true;
        }
        
        //MONSTER LIGHTNING VS. PLAYER ICE: LIGHTNING > ICE = MONSTER ADVANTAGE
        else if(randomEnvironmentNumber == 0 && userCombatStyleChoice == 1 && userAffinity == 1){
            monsterHasAdvantage = true;
        }
        
        //MONSTER LIGHTNING VS. PLAYER BOW: LIGHTNING > BOW = MONSTER ADVANTAGE
        else if(randomEnvironmentNumber == 0 && userCombatStyleChoice == 0 && userAffinity == 2){
            monsterHasAdvantage = true;
        }
        
        //PLAYER LIGHTNING VS. MONSTER SWORD: SWORD > LIGHTNING = MONSTER ADVANTAGE
        else if(randomEnvironmentNumber == 4 && userCombatStyleChoice == 1 && userAffinity == 2){
            monsterHasAdvantage = true;
        }
        //PLAYER LIGHTNING VS. MONSTER ICE: LIGHTNING > ICE = PLAYER ADVANTAGE
        else if(randomEnvironmentNumber == 2 && userCombatStyleChoice == 1 && userAffinity == 2){
            playerHasAdvantage = true;
        }
        //PLAYER LIGHTNING VS. MONSTER BOW: LIGHTNING > BOW = PLAYER ADVANTAGE
        else if(randomEnvironmentNumber == 5 && userCombatStyleChoice == 1 && userAffinity == 2){
            playerHasAdvantage = true;
        }
        //MONSTER ICE VS. PLAYER SPEAR: ICE > SPEAR = MONSTER ADVANTAGE
        else if(randomEnvironmentNumber == 2 && userCombatStyleChoice == 0 && userAffinity == 0){
            monsterHasAdvantage = true;
        }
        //PLAYER ICE VS MONSTER SPEAR: ICE > SPEAR = PLAYER ADVANTAGE
        else if(randomEnvironmentNumber == 3 && userCombatStyleChoice == 1 && userAffinity == 1){
            playerHasAdvantage = true;
        }
        //MONSTER FIRE VS. PLAYER SWORD: FIRE > SWORD = MONSTER ADVANTAGE
        else if(randomEnvironmentNumber == 1 && userCombatStyleChoice == 0 && userAffinity == 1){
            monsterHasAdvantage = true;
        }
        //PLAYER FIRE VS. MONSTER SWORD: FIRE > SWORD = PLAYER ADVANTAGE
        else if(randomEnvironmentNumber == 4 && userCombatStyleChoice == 1 && userAffinity == 0){
            playerHasAdvantage = true;
        }
        //MONSTER ICE VS. PLAYER FIRE: ICE > FIRE = MONSTER ADVANTAGE
        else if(randomEnvironmentNumber == 2 && userCombatStyleChoice == 1 && userAffinity == 0){
            monsterHasAdvantage = true;
        }
        //PLAYER ICE VS. MONSTER FIRE: ICE > FIRE = PLAYER ADVANTAGE
        else if(randomEnvironmentNumber == 1 && userCombatStyleChoice == 1 && userAffinity == 1){
            playerHasAdvantage = true;
        }
        //MONSTER FIRE VS. PLAYER LIGHTNING: FIRE > LIGHTNING = MONSTER ADVANTAGE
        else if(randomEnvironmentNumber == 1 && userCombatStyleChoice == 1 && userAffinity == 2){
            monsterHasAdvantage = true;
        }
        //PLAYER FIRE VS. MONSTER LIGHTNING: FIRE > LIGHTNING = PLAYER ADVANTAGE
        else if(randomEnvironmentNumber == 0 && userCombatStyleChoice == 1 && userAffinity == 0){
            playerHasAdvantage = true;
        }
        //MONSTER BOW VS. PLAYER ICE: BOW > ICE = MONSTER ADVANTAGE
        else if(randomEnvironmentNumber == 5 && userCombatStyleChoice == 1 && userAffinity == 1){
            monsterHasAdvantage = true;
        }
        //PLAYER BOW VS. MONSTER ICE: BOW > ICE = PLAYER ADVANTAGE
        else if(randomEnvironmentNumber == 2 && userCombatStyleChoice == 0 && userAffinity == 2){
            playerHasAdvantage = true;
        }
        //MONSTER SPEAR VS. PLAYER FIRE: SPEAR > FIRE = MONSTER ADVANTAGE
        else if(randomEnvironmentNumber == 3 && userCombatStyleChoice == 1 && userAffinity == 0){
            monsterHasAdvantage = true;
        }
        //PLAYER SPEAR VS. MONSTER FIRE: SPEAR > FIRE = PLAYER ADVANTAGE
        else if(randomEnvironmentNumber == 1 && userCombatStyleChoice == 0 && userAffinity == 0){
            playerHasAdvantage = true;
        }
        //MONSTER SPEAR VS. PLAYER SWORD: SPEAR > SWORD = MONSTER ADVANTAGE
        else if(randomEnvironmentNumber == 3 && userCombatStyleChoice == 0 && userAffinity == 1){
            monsterHasAdvantage = true;
        }
        //PLAYER SPEAR VS. MONSTER SWORD: SPEAR > SWORD = PLAYER ADVANTAGE
        else if(randomEnvironmentNumber == 4 && userCombatStyleChoice == 0 && userAffinity == 0){
            playerHasAdvantage = true;
        }
        //MONSTER SWORD VS. PLAYER BOW: SWORD > BOW = MONSTER ADVANTAGE
        else if(randomEnvironmentNumber == 4 && userCombatStyleChoice == 0 && userAffinity == 2){
            monsterHasAdvantage = true;
        }
        //PLAYER SWORD VS. MONSTER BOW: SWORD > BOW = PLAYER ADVANTAGE
        else if(randomEnvironmentNumber == 5 && userCombatStyleChoice == 0 && userAffinity == 1){
            playerHasAdvantage = true;
        }
        //MONSTER BOW VS. PLAYER SPEAR: BOW > SPEAR = MONSTER ADVANTAGE
        else if(randomEnvironmentNumber == 5 && userCombatStyleChoice == 0 && userAffinity == 0){
            monsterHasAdvantage = true;
        }
        //PLAYER BOW VS. MONSTER SPEAR: BOW > SPEAR = PLAYER ADVANTAGE
        else if(randomEnvironmentNumber == 3 && userCombatStyleChoice == 0 && userAffinity == 2){
            playerHasAdvantage = true;
        }
        
        else {
            playerHasAdvantage = false;
            monsterHasAdvantage = false;
        }

    }
    
    public void getAttackValue(){
        if(playerHasAdvantage == true) {
            playerAttackValue = rand.nextInt(12) + 1;
            monsterAttackValue = rand.nextInt(6) + 1;
        }
        else if(monsterHasAdvantage == true){
            playerAttackValue = rand.nextInt(6) + 1;
            monsterAttackValue = rand.nextInt(12) + 1;
        }
        else if(monsterHasAdvantage == false && playerHasAdvantage == false){
            playerAttackValue = rand.nextInt(6) + 1;
            monsterAttackValue = rand.nextInt(6) + 1;
        }
        else System.out.println("Error in Model.getAttackValue");
    }
    
    public double getDefenseValue(){
        int defenseRoll = rand.nextInt(8);
        /* ---------------------------------------------------------- */
        /* 37.5% (3/8) Success - Halves Damange                       */
        /* 25% (1/4) Perfect Success - Negates Damage                 */
        /* 12.5% (1/8) Critical Success - Negates Damage & heals half */ 
        /* 12.5% (1/8) Failure - Blocks No Damage                     */
        /* 12.5% (1/8) Critical Failure - Incoming Damage * 1.5       */
        /* ---------------------------------------------------------- */
        switch(defenseRoll){
            case 0:
                defenseOutcome = "Success";
                damageModifier = 0.5;
                break;
            case 1:
                defenseOutcome = "Success";
                damageModifier = 0.5;
                break;
            case 2:
                defenseOutcome = "Success";
                damageModifier = 0.5;
                break;
            case 3:
                defenseOutcome = "Perfect Success";
                damageModifier = 0.0;
                break;
            case 4:
                defenseOutcome = "Perfect Success";
                damageModifier = 0.0;
                break;
            case 5:
                defenseOutcome = "Critical Success";
                damageModifier = 0.5;
                //REFLECTS 50% OF ATTACK DAMAGE BACK TO ATTACKER
                break;
            case 6:
                defenseOutcome = "Failure";
                damageModifier = 1.0;
                break;
            case 7:
                defenseOutcome = "Critical Failure";
                damageModifier = 1.5;
                break;
        }
        return damageModifier;
    }
    
    public void generateMonsterAction(){
        int monsterAction = rand.nextInt(4);
        //MONSTER ATTACKS 75% OF THE TIME
        switch (monsterAction){
            case 0:
                monsterAttack = true;
                break;
            case 1:
                monsterAttack = true;
                break;
            case 2:
                monsterAttack = true;
                break;
            case 3:
                monsterAttack = false;
                break;
            default: System.out.println("Error in Model.generateMonsterAction");
        }
    }
    
    public void combatCalc(){
        //BOTH ATTACK
        if(playerAttack == true && monsterAttack == true){
            playerHealth = playerHealth - monsterAttackValue;
            monsterHealth = monsterHealth - playerAttackValue;
            combatFlavorTextNum = 1;
        }
        //PLAYER ATTACKS, MONSTER DEFENNDS
        else if(playerAttack == true && monsterAttack == false){
            monsterDefenseValue = damageModifier;
            //REFLECTS HALF OF PLAYER'S ATTACK BACK TO PLAYER
            if (defenseOutcome == "Critical Success"){
                playerHealth = playerHealth - (playerAttackValue * monsterDefenseValue);
                combatFlavorTextNum = 2;
            }
            //ALL OTHER DEFENSES
            else {
                monsterHealth = monsterHealth - (playerAttackValue * monsterDefenseValue);
                switch (defenseOutcome) {
                    //MONSTER DEFENDS SUCCESSFULLY
                    case "Success":
                        combatFlavorTextNum = 3;
                        break;
                    //MONSTER DEFENDS PERFECTLY
                    case "Perfect Success":
                        combatFlavorTextNum = 4;
                        break;
                    //MONSTER FAILS TO DEFEND
                    case "Failure":
                        combatFlavorTextNum = 5;
                        break;
                    //MONSTER CRITICALLY FAILS TO DEFEND
                    default:
                        combatFlavorTextNum = 6;
                        break;
                }
            }
        }
        //PLAYER DEFENDS, MONSTER ATTACKS
        else if(playerAttack == false && monsterAttack == true){
            playerDefenseValue = damageModifier;
            //REFLECTS HALF OF THE MONSTER'S ATTACK BACK TO MONSTER
            if (defenseOutcome == "Critical Success"){
                monsterHealth = monsterHealth - (monsterAttackValue * playerDefenseValue);
                combatFlavorTextNum = 7;
            }
            //ALL OTHER DEFENSES
            else {
                playerHealth = playerHealth - (monsterAttackValue * playerDefenseValue);
                switch (defenseOutcome) {
                    //PLAYER DEFENDS SUCCESSFULLY
                    case "Success":
                        combatFlavorTextNum = 8;
                        break;
                    //PLAYER DEFENDS PERFECTLY
                    case "Perfect Success":
                        combatFlavorTextNum = 9;
                        break;
                    //PLAYER FAILS TO DEFEND
                    case "Failure":
                        combatFlavorTextNum = 10;
                        break;
                    //PLAYER CRITICALLY FAILS TO DEFEND
                    default:
                        combatFlavorTextNum = 11;
                        break;
                }
            }
        }
        //BOTH DEFEND                
        else if(playerAttack == false && monsterAttack == false){
            combatFlavorTextNum = 12;
        }
        else {
            System.out.println("Error in Model.combatCalc");
        }
    }
    
    public void combatFlavorText(){
        switch(combatFlavorTextNum) {
            //BOTH ATTACK
            case 1:
                combatFlavorText = "You and the "+creatureType+" strike against each other."
                        + "\nYou deal "+playerAttackValue+" damage to the "+creatureType+"."
                        + "\nThe "+creatureType+" deals "+monsterAttackValue+" damage to you.";
                break;
            //MONSTER CRITICAL DEFENSE: REFLECTS HALF OF PLAYER'S ATTACK BACK TO PLAYER
            case 2:
                combatFlavorText = "The "+creatureType+" evades your attack and launches a deadly riposte."
                        + "\nThe monster receives no damage and inflicts "+(playerAttackValue * monsterDefenseValue)+" to you.";
                break;
            //MONSTER DEFENDS SUCCESSFULLY
            case 3:
                combatFlavorText = "The "+creatureType+" braces itself as you press the"
                        + "\nattack, dealing "+(playerAttackValue * monsterDefenseValue)+" damage to it.";
                 break;
            //MONSTER DEFENDS PERFECTLY
            case 4:
                combatFlavorText = "The "+creatureType+" protects itself completely,"
                        + "\nreceiving no damage from your attack";
                 break;
            //MONSTER FAILS TO DEFEND
            case 5:
                combatFlavorText = "The "+creatureType+" defends itself, but you slide past and"
                        + "\ndeliver a blow, dealing "+(playerAttackValue * monsterDefenseValue)+" damage.";
                break;
            //MONSTER CRITICALLY FAILS TO DEFEND
            case 6:
                combatFlavorText = "The "+creatureType+" fails to defend itself, and you deliver"
                        + "\na devestating blow, dealing "+(playerAttackValue * monsterDefenseValue)+" damage.";
                break;
            //PLAYER CRITICAL DEFENSE: REFLECTS HALF OF THE MONSTER'S ATTACK BACK TO MONSTER
            case 7:
                combatFlavorText = "You skillfully parry the "+creatureType+"'s attack, receiving"
                        + "\nno damage and dealing "+(monsterAttackValue * playerDefenseValue)+" damage to the "+creatureType+".";
                break;
            //PLAYER DEFENDS SUCCESSFULLY
            case 8:
                combatFlavorText = "The "+creatureType+" lashes out as you brace yourself"
                        + "\nand deals "+(monsterAttackValue * playerDefenseValue)+" damage to you.";
                 break;
            //PLAYER DEFENDS PERFECTLY
            case 9:
                combatFlavorText = "You dodge the "+creatureType+"'s attack, and receive no damage.";
                break;
            //PLAYER FAILS TO DEFEND
            case 10:
                combatFlavorText = "You protect yourself, but the "+creatureType+" slides past your defenses and"
                        + "\ndelivers a blow, dealing "+(monsterAttackValue * playerDefenseValue)+" damage to you.";
                break;
            //PLAYER CRITICALLY FAILS TO DEFEND
            case 11:
                combatFlavorText = "You fail to defend yourself, and the "+creatureType+" delivers"
                        + "\na devestating blow, dealing "+(monsterAttackValue * playerDefenseValue)+" damage to you.";
                break;
            //BOTH DEFEND
            case 12:
                combatFlavorText = "Both you and the "+creatureType+" defend against blows"
                        + "\nthat do not come. Nothing happens.";
                 break;
            default:
                combatFlavorText = "Error in Model.combatFlavorText";
                break;
        }
        combatLoopCounter++;
    }
    
/* --------------------------------------------- */
/* SCORE CALCULATOR - POST COMBAT*/    
/* --------------------------------------------- */
    
    public void scoreModifierCalc(){
        switch(combatLoopCounter){
            //THE NUMBER OF TURNS REQUIRED TO DEFEAT THE MONSTER
            //INVERSE CORRELATION; MORE TURNS = LESS MODIFIER
            case 5:
                //50/12 = 4.166 - TURNS ARE ONLY EVER INTEGERS, SO THE LOWEST
                //POSSIBLE NUMBER OF TURNS IS 5
                scoreModifier = 160;
                break;
            case 6:
                scoreModifier = 80;
                break;
            case 7:
                scoreModifier = 40;
                break;
            case 8:
                scoreModifier = 20;
                break;
            case 9:
                scoreModifier = 15;
                break;
            case 10:
                scoreModifier = 10;
                break;
            case 11:
                scoreModifier = 9;
                break;
            case 12:
                scoreModifier = 8;
                break;
            case 13:
                scoreModifier = 7;
                break;
            case 14:
                scoreModifier = 6;
                break;
            case 15:
                scoreModifier = 5;
                break;
            case 16:
                scoreModifier = 4;
                break;
            case 17:
                scoreModifier = 3;
                break;
            case 18:
                scoreModifier = 2;
                break;
            case 19:
                scoreModifier = 1.75;
                break;
            case 20:
                scoreModifier = 1.50;
                break;   
            case 21:
                scoreModifier = 1.25;
                break;                   
            default:
                //MORE THEN 20 TURNS = NO SCORE MULTIPLIER
                scoreModifier = 1;
                break;
        }
    }
    
    public void scoreCalc(){
        //IF PLAYER WINS
        if(playerHealth > 0.00) {
            userScore = (playerHealth + Math.abs(monsterHealth)) * scoreModifier;
        }
        //IF PLAYER LOSES/TIES
        else {
            userScore = (50.00 - monsterHealth);
        }
    }
    
    public void sortHighScores(){
        //SELECTION SORT ALGORITHM TO ARRANGE HIGH SCORES
        int startScan, index, maxIndex;
        double maxValue;
        String maxScorerName;
        
        //REPLACES LAST ITEM IN ARRAY WITH NEW USER AND SCORE
        //ITEM 11 IN THE ARRAY WILL ALWAYS BE THE LOWEST SCORE
        if(userScore > highScoreValues[10]){
            highScoreValues[10] = userScore;
            highScorerNames[10] = getPlayerNameAndTitleForScore();
        }
       
        for(startScan = 0; startScan < (highScoreValues.length - 1); startScan++){
            maxIndex = startScan;
            maxScorerName =highScorerNames[startScan];
            maxValue = highScoreValues[startScan];
            //TRAVERSES THE HIGHSCOREVALUES ARRAY
            for(index = startScan + 1; index < highScoreValues.length; index++){
                if(highScoreValues[index] > maxValue) {
                    
                    //UPDATES LOCAL VARIABLES IF A HIGHER SCORE IS FOUND
                    maxValue = highScoreValues[index];
                    maxScorerName = highScorerNames[index];
                    maxIndex = index;
                }
            }
            //ARRANGES THE PARALLEL ARRAYS IN DESCENDING ORDER
            highScoreValues[maxIndex] = highScoreValues[startScan];
            highScoreValues[startScan] = maxValue;
            
            highScorerNames[maxIndex] = highScorerNames[startScan];
            highScorerNames[startScan] = maxScorerName;
        }
    }
    //METHOD CALLED IF PLAYER CHOOSES TO PLAY AGAIN
    public void resetGameData(){
        combatLoopCounter = 0;
        playerHealth = INITIAL_HEALTH;
        monsterHealth = INITIAL_HEALTH;
        highScoreStringConcat = "";
    }
}
