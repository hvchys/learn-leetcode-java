package algoProblems.x_3_n_queens.backTrack;

public class run {
    // driver program to test above function
    public static void main(String args[]) {
        for(int i = 0; i < 5; i++){
            NQueenProblem Queen = new NQueenProblem(8);
            Queen.getOneSolution();
            System.out.println("\n\n");
        }

    }
}

