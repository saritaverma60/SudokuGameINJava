package io.github.dvyadav.sudokufx;

public class GridNumbers {

    private Cell[][] cell = new Cell[9][9];
    private int row = 0;
    private int col = 0;



    public GridNumbers(){
        createGrid();
    }




    public int[][] getGridNumbers(){
        int[][] gridNumbers = new int[cell.length][cell[0].length];

        for(int i = 0; i < cell.length; i++){
            for(int j = 0; j < cell[0].length; j++){
                gridNumbers[i][j] = cell[i][j].getCellValue();
            }
        }

        return gridNumbers;
    }

    public void printArray(){
        String outputArr = "";
		for(int i =0; i< 9; i++){
			for(int j = 0; j< 9; j++){
				outputArr += "\t"+cell[i][j].getCellValue();
                if(j == 2 || j == 5) outputArr += "\t|";
			}
			outputArr += "\n";
            if(i == 2 || i == 5) outputArr += "\t------------------------------------------------------------------------------------\n";
		}
		System.out.println(outputArr);
	}






    public void createGrid(){

        // declaration + initialization
        for(row = 0; row < 9; row++){
            for(col = 0; col < 9; col++){
                cell[row][col] = new Cell();
            }
        }


        for(row = 0; row < 9; row++){
            for(col = 0; col < 9; col++){
                printArray();

                setNewValue_CheckDuplicate();

            }
        }

        printArray();
    }


    

    public void stepBack_SetNewValue(int nRow, int nCol){
        System.out.println("no new value availbale to set");

        // refilling the cuurent cell valid values after cahnges with previous cell
        cell[nRow][nCol].refillValidValues();

        // jumping one cell back
        if(row > 0 && col == 0){
            row = nRow - 1;
            col = cell[row].length - 1; //lset elemnt of that row
        }else{
            col = nCol - 1;
        }
        System.out.println("Jumping at row:"+row+" and col:"+ col);
        System.out.println("Jumping to cell:" + cell[row][col]);

        cell[row][col].removevalidNumber(cell[row][col].getCellValue());
        setNewValue_CheckDuplicate();
    }




    public void setNewValue_CheckDuplicate(){

        cell[row][col].setNewCellValue();
        /* TODO: remove me --> */System.out.println(cell[row][col]);

        // in case of all values used imply backtrack
        if(cell[row][col].isValidValuesEmpty()){
            System.out.println("no new value availbale to set");
            stepBack_SetNewValue(row, col);
            return;
        }
        
        // if presenr in row or col or block
        if(isPresentInRow(cell[row][col].getCellValue(), row, col) || 
           isPresentInCol(cell[row][col].getCellValue(), row, col) || 
           isPresentInBlock(cell[row][col].getCellValue(), row, col)){

               //update lsit of valid numbers
               cell[row][col].removevalidNumber(cell[row][col].getCellValue());
               
               
               // setting nwe Value from availbale values
               setNewValue_CheckDuplicate();
               
        }  
    }


    
    public boolean isPresentInRow( int value, final int constRow, int col){
        /* TODO:remove me later */ System.out.println("is "+value+" present in row "+constRow+"?");

        for(int i  = 0; i < cell[constRow].length; i++ ){
            /* TODO:remove me later */ System.out.println("Checking is-present in col:"+i+" of row:"+ constRow);
            
            if( i == col){
                /* TODO:remove me later */ System.out.println("Skipping self-Check at col:"+i+" of row:"+ constRow);
                continue;
            }
            else if( cell[constRow][i].getCellValue() == value){
                /* TODO:remove me later */ System.out.println("found duplicate at col:"+i+" of row:"+ constRow);
                return true;
            }
        }
        
        /* TODO:remove me later */ System.out.println("Not found duplicate in row:"+ constRow);
        return false;
    }


    
    public boolean isPresentInCol( int value, int row, final int constCol){
        /* TODO:remove me later */ System.out.println("is "+value+" present in col "+constCol+"?");
        
        for(int i  = 0; i < cell.length; i++ ){
            /* TODO:remove me later */ System.out.println("Checking is-present in row:"+i+" of col:"+ constCol);

            if( i == row){
                /* TODO:remove me later */ System.out.println("Skipping self-Check at row:"+i+" of col:"+ constCol);
                continue;
            }
            else if( cell[i][constCol].getCellValue() == value){
                /* TODO:remove me later */ System.out.println("found duplicate at row:"+i+" of col:"+ constCol);
                return true;
            }
        }

        /* TODO:remove me later */ System.out.println("Not found duplicate in col:"+ constCol);
        return false;
    }



    public boolean isPresentInBlock(int value, int row, int col){
        /* TODO:remove me later */ System.out.println("is "+value+" present in its block containing ("+row+","+col+")?");

        int rowHead = row - (row % 3);
		int colHead = col - (col % 3);

        for(int i = rowHead; i < (rowHead + 3); i++){
            for(int j = colHead; j < (colHead + 3); j++){
                /* TODO: remove me later-> */System.out.println("inside Block, Checking at ("+i+","+j+")");
                
                if (i == row && j == col) {
                    /* TODO: remove me later-> */System.out.println("Skipping self-Check at ("+i+","+j+")");
                    continue;
                }
                else if(cell[i][j].getCellValue() == value){
                    /* TODO: remove me later-> */System.out.println("Duplicate found at ("+i+","+j+")");
                    return true;
                }
            }
        }
        /* TODO: remove me later-> */System.out.println("No Duplicate found in Block containing ("+row+","+col+")");
        return false;


    }

    

}
