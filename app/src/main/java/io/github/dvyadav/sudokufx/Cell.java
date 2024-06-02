package io.github.dvyadav.sudokufx;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    
    private static int objectCounter = 0;

    //identity-number of cell
    private int cellId = 0;

    //list of valid values
    private List<Integer> validValues = new ArrayList<>();

    // cell self-value
    private int value = 0;




    Cell(){

        //assign cellID
        objectCounter++;
        cellId = objectCounter;

        refillValidValues();
    }

    public int getCellId(){
        return this.cellId;
    }

    public int getCellValue(){
        return this.value;
    }

    public boolean isValidValuesEmpty(){
        return validValues.isEmpty();
    }

    // cell should have some permissible values while its creation
    public void refillValidValues(){

        for(int i = 1 ; i <= 9; i++){
            validValues.add(i);
        }
        
    }


    //return false if no-more number can be elimianated i.e. list is empty
    public boolean removevalidNumber(int num){

        if(validValues.size() < 1){
            return false;
        }
        
        validValues.remove(Integer.valueOf(num));
        return true;
    }


    public void setNewCellValue(){
        if(validValues.isEmpty()){
            value = 0;
            return;
        }
        value = validValues.get((int)(Math.random() * validValues.size()));
    }

    
    @Override
    public String toString(){
        return "Cell id:"+this.cellId+" value:"+this.value+" possibleValues:"+this.validValues;
    }

}
