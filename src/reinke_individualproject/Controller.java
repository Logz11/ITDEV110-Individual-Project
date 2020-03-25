package reinke_individualproject;


public class Controller {

    public void start(){
        
        View view = new View();
        Model model = new Model();
        
        model.generateEnvironment();
        model.generateIntroText();
        
        view.titleScreen();
        view.introduction(model.getRandomIntroText(), model.getEnvironment(), model.getEnvironmentDescription());
        model.setUserName(view.getUserName());
        
        do {
        model.setUserCombatStyleChoice(view.getUserCombatStyleChoice());
        model.setUserAffinity(view.getUserAffinity(model.getUserCombatStyleChoice(), model.getUserAffinityChoice()));
        view.displayASCIIArt(model.generateASCIIArt());
        
        
        
        view.getCreatureType(model.getCreatureType());
        
        
        System.exit(0);
    }
    
}
