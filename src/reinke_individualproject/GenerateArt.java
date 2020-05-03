package reinke_individualproject;

import java.awt.BorderLayout;
import javax.swing.*;

public class GenerateArt {
    
    public void generateWeaponFlavorArt(int userCombatStyleChoice, int userAffinity){
        
        String url = "", flavorText = "", blankLineForSpacing = " ";
        
        //SPEAR FLAVOR ART
        if(userCombatStyleChoice == 0 && userAffinity == 0){
            url = "C:\\Users\\Logan\\Pictures\\RockPaperFireball\\spear.jpg";
            flavorText = "\"A well-aimed spear is worth three.\" -- Tad Williams";
        }
        //SWORD FLAVOR ART
        else if(userCombatStyleChoice == 0 && userAffinity == 1){
            url = "C:\\Users\\Logan\\Pictures\\RockPaperFireball\\sword.jpg";
            flavorText = "\"[after giving Arya her sword] First lesson: stick them with the pointy end.\""
                + " -- Jon Snow, Game of Thrones, S01 E02";
        }
        //BOW FLAVOR ART
        else if(userCombatStyleChoice == 0 && userAffinity == 2){
            url = "C:\\Users\\Logan\\Pictures\\RockPaperFireball\\bow.jpg";
            flavorText = ("\"Every aspect of human technology has a dark size, including the bow and arrow,\""
                + " -- Margaret Atwood");
        }
        //FIRE FLAVOR ART
        else if(userCombatStyleChoice == 1 && userAffinity == 0){
            url = "C:\\Users\\Logan\\Pictures\\RockPaperFireball\\fire.jpg";
            flavorText = ("\"	Fire is always dancing, leaping and whirling, seeking more fuel. It never rests, so why should I?\""
                + " -- Chandra Nalaar, Wildfire Elemental, Magic 2020");
        }
        //ICE FLAVOR ART
        else if(userCombatStyleChoice == 1 && userAffinity == 1){
            url = "C:\\Users\\Logan\\Pictures\\RockPaperFireball\\ice.jpg";
            flavorText = ("\"If you're skating on thin ice, you might as well dance,\""
                + " -- Anita Shreve");
        }
        //LIGHTNING FLAVOR ART
        else if(userCombatStyleChoice == 1 && userAffinity == 2){
            url = "C:\\Users\\Logan\\Pictures\\RockPaperFireball\\lightning.jpg";
            flavorText = ("\"If Lightning is the anger of the gods, then the gods are"
                + "mostly concerned with trees,\" -- Lao Tzu");
        } else {
            JOptionPane.showMessageDialog(null, "Error in GenerateArt.generateWeaponFlavorArt");
        }
        
        //INSTANTIATING OBJECTS FOR TEXT, FORMAT, AND PICTURE
        JLabel text = new JLabel(flavorText);
        JLabel spacing = new JLabel(blankLineForSpacing);
        
        ImageIcon combatFlavorPicture = new ImageIcon(url);
        JLabel frame = new JLabel(combatFlavorPicture);
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        //CENTERS THE FLAVOR TEXT ABOVE THE PICTURE
        text.setHorizontalAlignment(JLabel.CENTER);
        
        //ARRANGES ALL JLABEL ELEMENTS WITHIN THE PANEL
        panel.add(frame, BorderLayout.SOUTH);
        panel.add(text, BorderLayout.NORTH);
        panel.add(spacing, BorderLayout.CENTER);
        
        //DISPLAYS PANEL
        JOptionPane.showMessageDialog(null, panel, "Display Image", JOptionPane.PLAIN_MESSAGE);
        
        
    }

}
