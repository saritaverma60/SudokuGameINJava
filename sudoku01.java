/* importing packages STRART */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
/* importing packages END */


/*-------------------------MAIN--CLASS--START------------------- */
public class sudoku01
{   

   

   static int arr[][][] = new int[9][3][3]; 

   /*-----------MAIN--SUDOKU--FRAME--METHOD--START-------------------------------------- */
   static void frame()
    {
        
        Integration integration = new Integration();
        arr = integration.getQuestion();
        int i,j,k;

        JFrame f = new JFrame("suduko");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(420, 420);
        f.setResizable(false);
        f.setLocationRelativeTo(null);

        JPanel backPanel,b[]= new JPanel[9];

        backPanel = new JPanel();
        backPanel.setBackground(Color.BLACK);
        backPanel.setLayout(new GridLayout(3,3,3,2));

        for( i = 0; i < 9; i++)
        {   
            b[i] = new JPanel();
            b[i].setLayout(new GridLayout(3, 3, 1, 1));
            // b[i].setBackground(Color.BLACK); 
            // b[i].setOpaque(true);
            
        }
        for( i = 0; i < 9; i++)
        {
            for( j = 0; j < 3; j++)
            {
                for (  k = 0; k< 3; k++)
                {
 
                    if(arr[i][j][k] == 0){
                        JTextField permText = new JTextField();
                        permText.setHorizontalAlignment(JTextField.CENTER);
                        Font font = new Font("Comic Sans MS", Font.BOLD,18);
                        permText.setFont(font);
                        int block = i;
                        int row = j;
                        int col = k;
                          ((AbstractDocument) permText.getDocument()).setDocumentFilter(new SudokuDocumentFilter());

                          permText.addKeyListener(new KeyListener() {
                            
                            @Override
                            public void keyTyped(KeyEvent e){
                            }

                            
                            @Override
                            public void keyPressed(KeyEvent e){
                            }

                            @Override 
                            public void keyReleased(KeyEvent e)
                            {
                                /*----Input--Validation--Check---- */
                                System.out.println("block : " + block+" row : "+row + " col : " + col);

                                int v =0;
                                String val = permText.getText();
                                try {
                                     v = Integer.parseInt(val);
                                    
                                } catch (NumberFormatException ex) {
                                    // TODO: handle exception
                                     v= 0;
                                }
                                System.out.println("The value is : " + v);

                                //DV
                                // arr[block][row][col] = v;
                                //dv

                                // boolean valid = ;
                                if(isUnique(block, row, col, v))
                                {
                                    permText.setForeground(Color.GREEN);
                                    permText.setBorder( BorderFactory.createLineBorder(Color.black, 1, false));
                                }
                                else                 
                                {
                                    permText.setForeground(Color.RED);

                                }

                                int set = integration.setNumber;
                                boolean winner = integration.isWinner(set);
                                
                                if( winner == true)
                                {
                                    System.out.println("Yes you are the winner");
                                    new winnerFrame(f);
                                }

                            }
                            


                          });

                        b[i].add(permText);
                        
                        
                    } 
                    else{
                         Font font = new Font("Comic Sans MS", Font.BOLD,18);
                        JLabel permLabel = new JLabel();
                        permLabel.setFont(font);
                        permLabel.setToolTipText("Cannot Enter Here");

                        float re =(float) Math.random();
                        float gr =(float) Math.random();
                        float bl =(float) Math.random();

                        permLabel.setOpaque(true);
                        permLabel.setBackground(new Color(re, gr, bl, (float)0.3));
                        
                        
                        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                        permLabel.setBorder(blackBorder);
                        
                        
                       

                        permLabel.setText("  "+ arr[i][j][k]);
                        b[i].add(permLabel);
                        backPanel.add(b[i]);
                    }
                }
            }
        }


        
        f.add(backPanel);
        f.setVisible(true);
    }

    /*-----------MAIN--SUDOKU--FRAME--METHOD--END-------------------------------------- */

    /*--------------VALIDA--INPUT--CHECK--METHODE--START------------ */

     static boolean isUnique(int b, int r, int c, int val)
    {
        //  int block = 9; 
         int row = 3; 
         int col = 3;
         int qsnSet[][][] = arr;
        //  boolean flage = true;

        // checks in block
        
        for(int i = 0; i < row; i++)
        {
            for ( int j = 0; j < col; j++)
            {
                if(  i == r && j == c) continue;
                else if(qsnSet[b][i][j] == val)
                {
                   return false;
                }
            }
        }

        // checks in row and column

        int rowA[] = new int[2], colA[] = new int[2];

        switch(b)
        {  
        case 0:
            rowA[0] = 1;    rowA[1] = 2;
            colA[0] = 3;    colA[1] = 6;
            break;
        case 1:
            rowA[0] = 0;    rowA[1] = 2;
            colA[0] = 4;    colA[1] = 7;
            break;
        case 2:
            rowA[0] = 0;    rowA[1] = 1;
            colA[0] = 5;    colA[1] = 8;
            break;
        case 3:
            rowA[0] = 4;    rowA[1] = 5;
            colA[0] = 0;    colA[1] = 6;
            break;
        case 4:
            rowA[0] = 3;    rowA[1] = 5;
            colA[0] = 1;    colA[1] = 7;
            break;
        case 5:
            rowA[0] = 3;    rowA[1] = 4;
            colA[0] = 2;    colA[1] = 8;
            break;
        case 6:
            rowA[0] = 7;    rowA[1] = 8;
            colA[0] = 0;    colA[1] = 3;
            break;
        case 7:
            rowA[0] = 6;    rowA[1] = 8;
            colA[0] = 1;    colA[1] = 4;
            break;
        case 8:
            rowA[0] = 6;    rowA[1] = 7;
            colA[0] = 2;    colA[1] = 5;
            break;
        default : 
            System.out.println("Could not searched in row and column");
            return false;
        }

        for(int k = 0 ; k < 2; k++)
        {
            int block = rowA[k];
           
                for ( int j = 0; j < col; j++)
                {
                    

                    if(qsnSet[block][r][j] == val)
                    {
                        // flage = false;
                        return false;
                    }
                }
            
        }
        for(int k = 0 ; k < 2; k++)
        {
            int block = colA[k];
            
                for ( int j = 0; j < col; j++)
                {
                    // if(  i == r && j == c) continue;
                    System.out.print("bl: "+ k+ "row : " + j + " col : " + c);
                    if(qsnSet[block][j][c] == val)
                    {
                        // flage = false;
                        return false;
                    }
                }
                
            
        }



        arr[b][r][c] = val;
        return true;
    }

/*--------------VALIDA--INPUT--CHECK--METHODE--END------------ */


    
    /*---------------FILTRING--RESTRICTING--INPUT--CLASS--START---------------------- */

     static class SudokuDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr)
                throws BadLocationException {
            String newValue = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
            if (newValue.matches("[1-9]") && newValue.length() <= 1) {
                super.insertString(fb, offset, text, attr);
            }
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            String newValue = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
            if (newValue.matches("[1-9]") && newValue.length() <= 1) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }

    /*---------------FILTRING--RESTRICTING--INPUT--CLASS--END---------------------- */


    /*-----------FIRST--FRAME--CLASS--START-------------------------------- */
    
     static class frameOne extends JFrame
    {
        JButton jb;
        JLabel jl;
        ImageIcon img ;
        frameOne()
        {
            Font font = new Font("Comic Sans MS", Font.BOLD, 22);
            this.setTitle("SUDOKU--pmkvy project");
            this.setSize(420, 420);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
             img = new ImageIcon("phot/sudokuImg02.gif");
             
             jl = new JLabel(img);
             this.add(jl, BorderLayout.CENTER);
             changeFramelistener l = new changeFramelistener(this);
            this.setVisible(true);

            try{
            Thread.sleep(6000);
            }catch(Exception em){}

             jb = new JButton("CLICK TO START!");
             jb.setFont(font);
             jb.setForeground(new Color((float)Math.random(),(float)Math.random(),(float)Math.random(),(float)1.0));
             jb.setBackground(new Color((float)Math.random(),(float)Math.random(),(float)Math.random(),(float)0.5));
             this.add(jb,BorderLayout.SOUTH);
            jb.addActionListener(l);

            this.setVisible(true);
        }
    }
    /*-----------FIRST--FRAME--CLASS--START-------------------------------- */


    /*-----------CHANGE--FRAME--ACTION--LISTENER--CLASS--START--------------- */
    static class changeFramelistener implements ActionListener
    {
        JFrame mainframeObject ;
        changeFramelistener(JFrame mainframeObject){
            this.mainframeObject =mainframeObject;
        }

        @Override 
        public void actionPerformed( ActionEvent e)
        {
            frame();
            mainframeObject.setVisible(false);

        }
    }
    /*-----------CHANGE--FRAME--ACTION--LISTENER--CLASS--START--------------- */

    /*-------WINNER--FRAME--START-------------------------------------------- */

     static class winnerFrame extends JFrame
    {
        JButton jb;
        JLabel jl;
        String imgUrl;
        ImageIcon img ;
        winnerFrame(JFrame f)
        {
            f.setVisible(false);

            this.setSize(420, 420);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            int rand= 1+(int)(Math.random()*9);
            System.out.print("gif no :"+ rand);

            switch( rand ){

                case 1:
                imgUrl = "phot/giphy.gif";
                break;

                case 2:
                imgUrl = "phot/tenor.gif";
                break;

                case 3:
                imgUrl = "phot/khusi.gif";
                break;  

                case 4:
                imgUrl = "phot/humJeetGaye.gif";
                break;

                case 5:
                imgUrl = "phot/miracle.gif";
                break;

                case 6:
                imgUrl = "phot/noice.gif";
                break;

                case 7:
                imgUrl = "phot/shabaas.gif";
                break;

                case 8:
                imgUrl = "phot/winnerChickenDinner.gif";
                break;

                case 9:
                imgUrl = "phot/applause.gif";
                break;

                default:
                imgUrl = "phot/sudokuImg02.gif";
            }

            img = new ImageIcon(imgUrl);
            
            JPanel jp = new JPanel(  );
            JLabel jl = new JLabel(img);

            jp.add(jl, BorderLayout.CENTER);
            this.add(jp);
            this.setVisible(true);
        }
    }

    /*-------WINNER--FRAME--END-------------------------------------------- */


    /*---------------------------MAIN--METHOD--START------------------------------- */
    public static void main(String[] args) 
    {
        new frameOne();
    }
    /*---------------------------MAIN--METHOD--END------------------------------- */

}
/*------------MAIN--CLASS--END------------------------------------------- */


/*-----------------INTERGRATION--CLASS--START-------------------------------- */
 class Integration {

    int setNumber;


    public int[][][] getSolSet( int set)
    {   int block = 9;
        int row = 3;
        int col = 3;



        //SOLUTION SET 1

        int S1[][][]=  new int[block][row][col];

        S1[0][0][0] = 9;    S1[0][0][1] = 3;    S1[0][0][2] = 4;
        S1[0][1][0] = 8;    S1[0][1][1] = 2;    S1[0][1][2] = 6;
        S1[0][2][0] = 1;    S1[0][2][1] = 5;    S1[0][2][2] = 7;

        S1[1][0][0] = 5;    S1[1][0][1] = 6;    S1[1][0][2] = 8;
        S1[1][1][0] = 7;    S1[1][1][1] = 1;    S1[1][1][2] = 4;
        S1[1][2][0] = 9;    S1[1][2][1] = 2;    S1[1][2][2] = 3;

        S1[2][0][0] = 1;    S1[2][0][1] = 2;    S1[2][0][2] = 7;
        S1[2][1][0] = 5;    S1[2][1][1] = 9;    S1[2][1][2] = 3;
        S1[2][2][0] = 4;    S1[2][2][1] = 6;    S1[2][2][2] = 8;

        S1[3][0][0] = 2;    S1[3][0][1] = 7;    S1[3][0][2] = 8;
        S1[3][1][0] = 6;    S1[3][1][1] = 4;    S1[3][1][2] = 1;
        S1[3][2][0] = 3;    S1[3][2][1] = 9;    S1[3][2][2] = 5;

        S1[4][0][0] = 1;    S1[4][0][1] = 5;    S1[4][0][2] = 9;
        S1[4][1][0] = 3;    S1[4][1][1] = 8;    S1[4][1][2] = 7;
        S1[4][2][0] = 6;    S1[4][2][1] = 4;    S1[4][2][2] = 2;

        S1[5][0][0] = 3;    S1[5][0][1] = 4;    S1[5][0][2] = 6;
        S1[5][1][0] = 2;    S1[5][1][1] = 5;    S1[5][1][2] = 9;
        S1[5][2][0] = 7;    S1[5][2][1] = 8;    S1[5][2][2] = 1;

        S1[6][0][0] = 5;    S1[6][0][1] = 6;    S1[6][0][2] = 3;
        S1[6][1][0] = 7;    S1[6][1][1] = 8;    S1[6][1][2] = 9;
        S1[6][2][0] = 4;    S1[6][2][1] = 1;    S1[6][2][2] = 2;

        S1[7][0][0] = 4;    S1[7][0][1] = 9;    S1[7][0][2] = 1;
        S1[7][1][0] = 2;    S1[7][1][1] = 3;    S1[7][1][2] = 5;
        S1[7][2][0] = 8;    S1[7][2][1] = 7;    S1[7][2][2] = 6;

        S1[8][0][0] = 8;    S1[8][0][1] = 7;    S1[8][0][2] = 2;
        S1[8][1][0] = 6;    S1[8][1][1] = 1;    S1[8][1][2] = 4;
        S1[8][2][0] = 9;    S1[8][2][1] = 3;    S1[8][2][2] = 5;

        //SOLUTION SET 2

        int S2[][][]=  new int[block][row][col];

        S2[0][0][0] = 4;    S2[0][0][1] = 3;    S2[0][0][2] = 5;
        S2[0][1][0] = 6;    S2[0][1][1] = 8;    S2[0][1][2] = 2;
        S2[0][2][0] = 1;    S2[0][2][1] = 9;    S2[0][2][2] = 7;

        S2[1][0][0] = 2;    S2[1][0][1] = 6;    S2[1][0][2] = 9;
        S2[1][1][0] = 5;    S2[1][1][1] = 7;    S2[1][1][2] = 1;
        S2[1][2][0] = 8;    S2[1][2][1] = 3;    S2[1][2][2] = 4;

        S2[2][0][0] = 7;    S2[2][0][1] = 8;    S2[2][0][2] = 1;
        S2[2][1][0] = 4;    S2[2][1][1] = 9;    S2[2][1][2] = 3;
        S2[2][2][0] = 5;    S2[2][2][1] = 6;    S2[2][2][2] = 2;

        S2[3][0][0] = 8;    S2[3][0][1] = 2;    S2[3][0][2] = 6;
        S2[3][1][0] = 3;    S2[3][1][1] = 7;    S2[3][1][2] = 4;
        S2[3][2][0] = 9;    S2[3][2][1] = 5;    S2[3][2][2] = 1;

        S2[4][0][0] = 1;    S2[4][0][1] = 9;    S2[4][0][2] = 5;
        S2[4][1][0] = 6;    S2[4][1][1] = 8;    S2[4][1][2] = 2;
        S2[4][2][0] = 7;    S2[4][2][1] = 4;    S2[4][2][2] = 3;

        S2[5][0][0] = 3;    S2[5][0][1] = 4;    S2[5][0][2] = 7;
        S2[5][1][0] = 9;    S2[5][1][1] = 1;    S2[5][1][2] = 5;
        S2[5][2][0] = 6;    S2[5][2][1] = 2;    S2[5][2][2] = 8;

        S2[6][0][0] = 5;    S2[6][0][1] = 1;    S2[6][0][2] = 9;
        S2[6][1][0] = 2;    S2[6][1][1] = 4;    S2[6][1][2] = 8;
        S2[6][2][0] = 7;    S2[6][2][1] = 6;    S2[6][2][2] = 3;

        S2[7][0][0] = 3;    S2[7][0][1] = 2;    S2[7][0][2] = 6;
        S2[7][1][0] = 9;    S2[7][1][1] = 5;    S2[7][1][2] = 7;
        S2[7][2][0] = 4;    S2[7][2][1] = 1;    S2[7][2][2] = 8;

        S2[8][0][0] = 8;    S2[8][0][1] = 7;    S2[8][0][2] = 4;
        S2[8][1][0] = 1;    S2[8][1][1] = 3;    S2[8][1][2] = 6;
        S2[8][2][0] = 2;    S2[8][2][1] = 5;    S2[8][2][2] = 9;

        //SOLUTION SET 3

        int S3[][][]=  new int[block][row][col];

        S3[0][0][0] = 5;    S3[0][0][1] = 3;    S3[0][0][2] = 4;
        S3[0][1][0] = 6;    S3[0][1][1] = 7;    S3[0][1][2] = 2;
        S3[0][2][0] = 1;    S3[0][2][1] = 9;    S3[0][2][2] = 8;

        S3[1][0][0] = 6;    S3[1][0][1] = 7;    S3[1][0][2] = 8;
        S3[1][1][0] = 1;    S3[1][1][1] = 9;    S3[1][1][2] = 5;
        S3[1][2][0] = 3;    S3[1][2][1] = 4;    S3[1][2][2] = 2;

        S3[2][0][0] = 9;    S3[2][0][1] = 1;    S3[2][0][2] = 2;
        S3[2][1][0] = 3;    S3[2][1][1] = 4;    S3[2][1][2] = 8;
        S3[2][2][0] = 5;    S3[2][2][1] = 6;    S3[2][2][2] = 7;

        S3[3][0][0] = 8;    S3[3][0][1] = 5;    S3[3][0][2] = 9;
        S3[3][1][0] = 4;    S3[3][1][1] = 2;    S3[3][1][2] = 6;
        S3[3][2][0] = 7;    S3[3][2][1] = 1;    S3[3][2][2] = 3;

        S3[4][0][0] = 7;    S3[4][0][1] = 6;    S3[4][0][2] = 1;
        S3[4][1][0] = 8;    S3[4][1][1] = 5;    S3[4][1][2] = 3;
        S3[4][2][0] = 9;    S3[4][2][1] = 2;    S3[4][2][2] = 4;

        S3[5][0][0] = 4;    S3[5][0][1] = 2;    S3[5][0][2] = 3;
        S3[5][1][0] = 7;    S3[5][1][1] = 9;    S3[5][1][2] = 1;
        S3[5][2][0] = 8;    S3[5][2][1] = 5;    S3[5][2][2] = 6;

        S3[6][0][0] = 9;    S3[6][0][1] = 6;    S3[6][0][2] = 1;
        S3[6][1][0] = 2;    S3[6][1][1] = 8;    S3[6][1][2] = 7;
        S3[6][2][0] = 3;    S3[6][2][1] = 4;    S3[6][2][2] = 5;

        S3[7][0][0] = 5;    S3[7][0][1] = 3;    S3[7][0][2] = 7;
        S3[7][1][0] = 4;    S3[7][1][1] = 1;    S3[7][1][2] = 9;
        S3[7][2][0] = 2;    S3[7][2][1] = 8;    S3[7][2][2] = 6;

        S3[8][0][0] = 2;    S3[8][0][1] = 8;    S3[8][0][2] = 4;
        S3[8][1][0] = 6;    S3[8][1][1] = 3;    S3[8][1][2] = 5;
        S3[8][2][0] = 1;    S3[8][2][1] = 7;    S3[8][2][2] = 9;


        


        // //random generator for the sets
        //  int randNum =1+ (int)(Math.random()*3);


        switch(set)
        {
            case 1:System.out.println("set 1");
            return S1;
            
            case 2 : System.out.println("set 2");
            return S2;

            case 3 : System.out.println("3");
            return S3;

            default: 
            return null;
            

        }
        
    }


    /*-------GET--QUETIONSET--METHOD--START------------------------------------ */

    public int[][][] getQuestion(){

        setNumber = 1+ (int)(Math.random()*3);
        int[][][]temp = getSolSet(setNumber);

        int[][][] currentQuestionSet = new int[9][3][3];

        for(int i= 0;i<9;i++){
            for(int j=0;j<3;j++){
                for(int k = 0; k<3;k++){
                    currentQuestionSet[i][j][k] = temp[i][j][k];
                }
            }
        }

       // RANDOME HIDE
        for(int block = 0; block<9;block++){
            // int block = (int)(Math.random()*9);
            for(int i =0; i<5;i++){
                int row = (int)(Math.random()*3);
                int column = (int)(Math.random()*3);
                currentQuestionSet[block][row][column] = 0 ;
            }
        }

        return currentQuestionSet;
    }
    /*-------GET--QUETIONSET--METHOD--END------------------------------------ */


    /*----------IS--PLAYER--SUDOKU--EMPTY--METHOD--START----------------------- */

    
    /*----------IS--PLAYER--SUDOKU--EMPTY--METHOD--END------------------------- */


    /*-------IS--WINNER--METHOD--START---------------------------------------- */
     boolean isWinner(int set)
     {
        int solutionAraay [][][] = getSolSet(set);
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                for(int k = 0; k < 3; k++)
                {
                    if(solutionAraay[i][j][k] != sudoku01.arr[i][j][k])
                    return false;
                }
            }
        }
        return true;
     }

    /*-------IS--WINNER--METHOD--END---------------------------------------- */
}
/*-----------------INTERGRATION--CLASS--END-------------------------------- */


