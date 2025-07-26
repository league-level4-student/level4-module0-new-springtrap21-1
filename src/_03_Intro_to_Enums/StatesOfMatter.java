package _03_Intro_to_Enums;

import java.util.Iterator;
import java.util.Random;

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

	public double convertToFahrenheit() {
		return (celsiusTemp * 9 / 5) + 32;
	}

	public static void main(String[] args) {

		StatesOfMatter[] sof = StatesOfMatter.values();

		String answer = JOptionPane.showInputDialog("Name a state of matter");

		for (int i = 0; i < sof.length; i++) {
			if (sof[i].name().equalsIgnoreCase(answer)) {
				String msg = "State: " + sof[i] + " Order: " + sof[i].ordinal();
				JOptionPane.showMessageDialog(null, msg);
			}

		}

		StatesOfMatter[] states = StatesOfMatter.values();

		Random rnd = new Random();

		StatesOfMatter rndState = states[rnd.nextInt(states.length)];

		System.out.println("State and it's tempatures: " + rndState + " In Celsius " + rndState.getCelsiusTemp()
				+ " In Fahrenheit " + rndState.convertToFahrenheit());

		switch (rndState) {
		case SOLID:
			System.out.println("Favorite solid food: sushi");
			break;
		case LIQUID:
			System.out.println("Favorite liquid drink: grape sprite");
			break;
		case GAS:
			System.out.println("Favorite gas use: Steam for boiling Pasta");
			break;
		}
	}
}
