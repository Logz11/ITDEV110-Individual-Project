package reinke_individualproject;

public class Controller {

    public void start(){
        
        int userConfirmationNumForClassAndAffinity;
        int userConfirmationNumForGame;
        View view = new View();
        Model model = new Model();
        GenerateArt gen = new GenerateArt();
        
        view.titleScreen();
            
        do{
            model.generateEnvironment();
            model.generateIntroText();
            view.introduction(model.getRandomIntroText(), model.getEnvironment(), model.getEnvironmentDescription());
            model.setUserName(view.getUserName());

            //USER SELECTS THEIR COMBAT STYLE AND AFFINITY IN A USER-CONTROLLED LOOP W/ SENTINEL VALUE -1
            do {
                model.setUserCombatStyleChoice(view.getUserCombatStyleChoice());
                model.setUserAffinity(view.getUserAffinity(model.getUserCombatStyleChoice()));
                gen.generateWeaponFlavorArt(model.getUserCombatStyleChoice(), model.getUserAffinity());
                userConfirmationNumForClassAndAffinity = view.getUserConfirmation(model.getUserAffinityChoice());
            }
            while (userConfirmationNumForClassAndAffinity != 1 );

            model.determineAdvantage();
            view.displayUserTitleAndQuarry(model.getCreatureType(), model.getUserName(), 
                    model.getPlayerCharacterTitle(), model.getUserAffinityChoice(), model.getEnvironment(), model.getCreatureDescription());

            view.beginCombat(model.getCreatureType());

            //COMBAT LOOP
            do {
                model.generateMonsterAction();
                model.getAttackValue();
                model.setUserAttackOrDefend(view.getUserAttackOrDefend());
                model.getDefenseValue();
                model.combatCalc();
                model.combatFlavorText();
                view.combatTurnResults(model.getCombatLoopCounter(), model.getCombatFlavorText());
                view.displayHealthTotals(model.getMonsterHealth(), model.getPlayerHealth());
            }
            while(model.getMonsterHealth() > 0.0 && model.getPlayerHealth() > 0.0);
            
            /*POST-COMBAT CALCULATE & DISPLAY SCORE,
            GET USER REPLAY & LOOP OR TERMINATE PROGRAM*/
            view.combatOutcomeMessage(model.getMonsterHealth(), model.getPlayerHealth(), model.getCombatLoopCounter());
            model.scoreModifierCalc();
            model.scoreCalc();
            view.displayUserScore(model.getUserScore());
            /*view.displayHighScores();*/
            userConfirmationNumForGame = view.userPlayAgain();
        } while (userConfirmationNumForGame == 1);
        
        view.exitMessage(model.getUserName(), model.getPlayerCharacterTitle());
        System.exit(0);
    }
    
}
