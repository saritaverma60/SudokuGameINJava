package io.github.dvyadav.sudokufx;

public class GridNumbers {

    private Cell[][] cell = new Cell[9][9];
    private int row = 0;
    private int col = 0;



    public GridNumbers(){
        createGrid();
    }



    // return the aaray version of sudoku grid
    public int[][] getGridNumbersArray(){
        int[][] gridNumbers = new int[cell.length][cell[0].length];

        for(int i = 0; i < cell.length; i++){
            for(int j = 0; j < cell[0].length; j++){
                gridNumbers[i][j] = cell[i][j].getCellValue();
            }
        }

        return gridNumbers;
    }

    // print the output grid
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





    // main task performer
    public void createGrid(){

        //initialization of cell object
        for(row = 0; row < 9; row++){
            for(col = 0; col < 9; col++){
                cell[row][col] = new Cell();
            }
        }


        //iteration at each cell
        for(row = 0; row < 9; row++){
            for(col = 0; col < 9; col++){

                setNewValue_CheckDuplicate();

            }
        }

        printArray();
    }


    
    // beacktrack to cell and changes the value then proceed forwards with dupicate check
    public void stepBack_SetNewValue(int nRow, int nCol){

        // refilling the cuurent cell valid values after cahnges with previous cell
        cell[nRow][nCol].refillValidValues();

        // jumping one cell back
        if(row > 0 && col == 0){
            row = nRow - 1;
            col = cell[row].length - 1; //lset elemnt of that row
        }else{
            col = nCol - 1;
        }

        cell[row][col].removevalidNumber(cell[row][col].getCellValue());
        setNewValue_CheckDuplicate();
    }



    // sets new cell value then check for duplicate
    // if found. changes value from list of valid values for that cell 
    // in case of none available valid values, performs backtrack
    public void setNewValue_CheckDuplicate(){

        cell[row][col].setNewCellValue();

        // in case of all values used imply backtrack
        if(cell[row][col].isValidValuesEmpty()){
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


    // check duplicate value in row
    public boolean isPresentInRow( int value, final int constRow, int col){

        for(int i  = 0; i < cell[constRow].length; i++ ){
            
            if( i == col){
                continue;
            }
            else if( cell[constRow][i].getCellValue() == value){
                return true;
            }
        }
        
        return false;
    }


    // check duplicate value in col
    public boolean isPresentInCol( int value, int row, final int constCol){
        
        for(int i  = 0; i < cell.length; i++ ){

            if( i == row){
                continue;
            }
            else if( cell[i][constCol].getCellValue() == value){
                return true;
            }
        }

        return false;
    }


    // check duplicate value in block
    public boolean isPresentInBlock(int value, int row, int col){

        int rowHead = row - (row % 3);
		int colHead = col - (col % 3);

        for(int i = rowHead; i < (rowHead + 3); i++){
            for(int j = colHead; j < (colHead + 3); j++){
                
                if (i == row && j == col) {
                    continue;
                }
                else if(cell[i][j].getCellValue() == value){
                    return true;
                }
            }
        }
        return false;


    }

    

}
