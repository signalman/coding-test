package Algorithm.day49;

public class 혼자하는틱택토 {
    char[][] myBoard;
    String[] _board;
    int answer = 0;
    public int solution(String[] board) {
        myBoard = new char[3][3];
        _board = board;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                myBoard[i][j] = '.';
            }
        }
        playGame(myBoard, 'O');
        return answer;
    }
    void playGame(char[][] myBoard, char turn){
        if(findAnswer(myBoard, _board)){
            answer = 1;
            return;
        }
        if(isFinished(myBoard)) return;


        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(myBoard[i][j] == '.'){
                    myBoard[i][j] = turn;
                    playGame(myBoard, (char)('O' + 'X' - turn));
                    myBoard[i][j] = '.';
                }
            }
        }
    }

    public boolean findAnswer(char[][] myBoard, String[] board){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(myBoard[i][j] != board[i].charAt(j)) return false;
            }
        }
        return true;
    }
    public boolean isFinished(char[][] board){

        if(
            board[0][0] != '.' && board[0][0] == board[0][1] && board[0][1] == board[0][2] ||
                board[1][0] != '.' && board[1][0] == board[1][1] && board[1][1] == board[1][2] ||
                board[2][0] != '.' && board[2][0] == board[2][1] && board[2][1] == board[2][2] ||

                board[0][0] != '.' && board[0][0] == board[1][0] && board[1][0] == board[2][0] ||
                board[0][1] != '.' && board[0][1] == board[1][1] && board[1][1] == board[2][1] ||
                board[0][2] != '.' && board[0][2] == board[1][2] && board[1][2] == board[2][2] ||

                board[0][0] != '.' && board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
                board[0][2] != '.' && board[0][2] == board[1][1] && board[1][1] == board[2][0]
        ) return true;
        return false;
    }
}
