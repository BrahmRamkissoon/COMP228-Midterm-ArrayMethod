package com.ramkissoon.brahm;

import java.util.Random;

public class Lotto649 extends LottoGame implements IBonusNumber {

	public Lotto649(int elementNum, int setSize) {
		super(elementNum, setSize);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int bonusNumber() {
		Random rnd = new Random();
		int number = 0;
		int rndElement;

		int index = 0; // assign sentinel variable for while loop
		while (index < 10) {
			rndElement = rnd.nextInt(49) + 1;
			// Check to see if rndElement has already been chosen
			if (this._numberArray[rndElement] != -1) {
				number = rndElement;
				// set flag -1 to indicate rndElement has been chosen
				this._numberArray[rndElement] = -1;
				// increment sentinel variable
				index++;
			}
		}
		return number;
	}

	@Override
	public String toString(){
		String output = "";
		int setNum = 5;
		
		output += "5 SETS OF NUMBERS USING ARRAYS \n";
		output += "+++++++++++++++++++++++++++++++++\n";
		
		for(int count = 0; count < setNum; count++){
			this.pickElements();
			
			for ( int element = 0; element < this._elementArray.length; element++){
				if (element > 0){
					output += ", ";
				}
				output += this._elementArray[element];
			}
			output += " + Bonus: " + this.bonusNumber() + "\n";
		}
		output += "++++++++++++++++++++++++++++++++++\n";
		
		return output;			
			}
}
