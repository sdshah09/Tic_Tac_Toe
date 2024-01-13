import java.util.*;

public class TTT{
    static String[] board;
    static String currentplayer;

    static String whowins(){
        for(int i=0;i<8;i++){
            String val = null;
            switch (i) {
                case 0:
                    val = board[0]+board[1]+board[2];
                    break;
                case 1:
                    val = board[3]+board[4]+board[5];
                    break;
                case 2:
                    val = board[6]+board[7]+board[8];
                    break;
                case 3:
                    val = board[0]+board[3]+board[6];
                    break;
                case 4:
                    val = board[1]+board[4]+board[7];
                    break;
                case 5:
                    val = board[2]+board[5]+board[8];
                    break;
                case 6:
                    val = board[0]+board[4]+board[8];
                    break;
                case 7:
                    val = board[2]+board[4]+board[6];
                    break;
            }
            if (val.equals("XXX")){
                return "X";
            }
            else if (val.equals("OOO")) {
                return "O";
            }
            
            
        }
        for(int a = 0;a<9;a++){
            if(Arrays.asList(board).contains(String.valueOf(a+1))){
                break;
            }
            else if(a==8){
                return "draw";
            }
        }
        System.out.println(
            currentplayer + "'s turn; enter a slot number to place "
            + currentplayer + " in:");
        return null;
    }
    static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                           + board[1] + " | " + board[2]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                           + board[4] + " | " + board[5]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                           + board[7] + " | " + board[8]
                           + " |");
        System.out.println("|---|---|---|");
    }


    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        board = new String[9];
        String userChoice;
        do {
            System.out.println("Enter 'X' or 'O' to choose your symbol:");
            userChoice = in.nextLine().toUpperCase();
        } while (!userChoice.equals("X") && !userChoice.equals("O"));
        currentplayer = userChoice;
        String winner = null;
        for(int i=0;i<9;i++){
            board[i] = String.valueOf(i+1);
        }
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();
        // System.out.println(turn+" will start the game");
        while(winner==null){
            int numinput;
            try{
                numinput = in.nextInt();
                if(!(numinput>0 && numinput<=9)){
                    System.out.println(
                        "Invalid input; re-enter slot number:");
                        continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                    "Invalid input; re-enter slot number:");
                continue;
            }

            if(board[numinput-1].equals(String.valueOf(numinput))){
                board[numinput-1]=currentplayer;
                if (currentplayer.equals("X")) {
                    currentplayer = "O";
                }
                else {
                    currentplayer = "X";
                }

                printBoard();
                winner = whowins();
            }
            else {
                System.out.println(
                    "Slot already taken; re-enter slot number:");
            }
        }
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                "It's a draw! Thanks for playing.");
        }
    
        // For winner -to display Congratulations! message.
        else {
            System.out.println(
                "Congratulations! " + winner
                + "'s have won! Thanks for playing.");
        }
        in.close();
        
    }
}