package _03_Intro_to_Enums;

import java.util.Iterator;

import javax.swing.JOptionPane;

public enum StatesOfMatter {
	SOLID(0), LIQUID(25.55), GAS(100);
	
	private double celsiusTemp;
	
	StatesOfMatter(double celsiusTemp) {
        this.celsiusTemp = celsiusTemp;
    }
	
	public double getCelsiusTemp() {
        return celsiusTemp;
    }
	
	public static void main(String[] args) {
		
		StatesOfMatter[] sof = StatesOfMatter.values();
		
		String answer = JOptionPane.showInputDialog("Name a state of matter(all caps)");
		
		for (int i = 0; i < sof.length; i++) {
			if (sof[i].name().equals(answer)) {
				String msg = "State: " + sof[i] + " Order: " + sof[i].ordinal();
				JOptionPane.showMessageDialog(null, msg);
			}
			
		}
	}	
}
