import java.awt.*;
// divyanshu yafa
import javax.swing.*;
import javax.swing.border.Border;


public class FirstIntegration
{   
   static int arr[][][] = new int[9][3][3]; 
   static void frame()
    {

        Integration integration = new Integration();
        arr = integration.getQuestion();
       

        JFrame f = new JFrame("suduko");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(420, 420);
        f.setResizable(false);
        f.setLocationRelativeTo(null);

        JPanel backPanel,b[]= new JPanel[9];

        backPanel = new JPanel();
        backPanel.setBackground(new Color(0,0,0));
        backPanel.setLayout(new GridLayout(3,3,2,2));

        for(int i = 0; i < 9; i++)
        {   
            b[i] = new JPanel();
            b[i].setLayout(new GridLayout(3, 3, 1, 1));
            
            b[i].setBackground(Color.gray); 
        }
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                for ( int k = 0; k< 3; k++)
                {

                    if(arr[i][j][k] == 0){
                        JTextField permText = new JTextField();
                        b[i].add(permText);
                        continue;
                    }
                    JLabel permLabel = new JLabel();
                    Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                    permLabel.setBorder(blackBorder);
                    permLabel.setText("     "+ arr[i][j][k]);
                     b[i].add(permLabel);
                    backPanel.add(b[i]);
                }
            }
        }

        f.add(backPanel);
        f.setVisible(true);
    }


    public static void main(String[] args) {
        frame();
    }
}

 class Integration {


    public int[][][] getSolSet()
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
        S2[6][1][0] = 2;    S2[6][1][1] = 2;    S2[6][1][2] = 8;
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


        


        //random generator for the sets
         int randNum =1+ (int)(Math.random()*3);


        switch(randNum)
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


    public int[][][] getQuestion(){

        int[][][]temp = getSolSet();

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
            for(int i =0; i<9;i++){
                int row = (int)(Math.random()*3);
                int column = (int)(Math.random()*3);
                currentQuestionSet[block][row][column] = 0 ;
            }
        }

        return currentQuestionSet;
    }

   
}

