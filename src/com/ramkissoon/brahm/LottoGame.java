package com.ramkissoon.brahm;

import java.util.Arrays;
import java.util.Random;

public abstract class LottoGame {
	//	 PRIVATE INSTANCE VARIABLES +++++++++++++++	
	private int _elementNum;
	private int _setSize;
	
	// PROTECTED REFERENCE VARIABLES +++++++++++++++++
	protected int[] _elementArray;
	protected int[] _numberArray;
	
	// CONSTRUCTOR ++++++++++++++++++++
	public LottoGame(int elementNum, int setSize) {
		this._elementNum = elementNum;
		this._setSize = setSize;
	}
	
	public void pickElements(){
		Random rnd = new Random(); 	// random seed
		int rndElement;
		int index = 0;
		
		this._Initialize(); 	// reset the Array Structures
		while (index < this._elementNum){
			rndElement = rnd.nextInt(this._setSize) + 1;
			// check if rndElement has been chosen
			if(this._numberArray[rndElement] != -1){
				this._elementArray[index] = rndElement;
				this._numberArray[rndElement] = -1;
				index++;
			}
		}		
		// Sort the Element Array
		Arrays.sort(this._elementArray);
	}
	
	// Private Methods ++++++++++++++++++++++++
		private void _Initialize(){
			this._elementArray = new int[this._elementNum];
			this._numberArray = new int[this._setSize + 1];	// ignore 0 index
			
			for( int num = 1; num < this._numberArray.length; num++){
				this._numberArray[num] = num;
			}
		}
}
