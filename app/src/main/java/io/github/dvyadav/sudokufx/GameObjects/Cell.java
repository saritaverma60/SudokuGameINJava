package io.github.dvyadav.sudokufx.GameObjects;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    
    //identity-number of cell
    int cellId;

    //list of valid values
    List<Integer> validValues = new ArrayList<>();

    // cell self-value
    int value;




    Cell(){

        //assign cellID
        cellId++;

        refillValidValues();
    }

    // cell should have some permissible values while its creation
    void refillValidValues(){

        for(int i = 0 ; i < 9; i++){
            validValues.add(i);
        }
        
    }


    //return false if no-more number can be elimianated i.e. list is empty
    boolean removevalidNumber(int num){

        if(validValues.size() < 1){
            return false;
        }
        
        validValues.remove(Integer.valueOf(num));
        return true;
    }


    void setNewcellValue(){
        value = validValues.get((int)(Math.random() * validValues.size()));
    }

    
    @Override
    public String toString(){
        return "Cell id:"+this.cellId+" value:"+this.value+" possibleValues:"+this.validValues;
    }

}
