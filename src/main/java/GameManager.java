import com.sun.javafx.geom.Vec2d;
import visualizations.Board;
import visualizations.Field;

import java.awt.*;

public class GameManager
{
    private static GameManager ourInstance = new GameManager();

    public static GameManager getInstance()
    {
        return ourInstance;
    }

    public static boolean gameOver = false;


    private GameManager()
    {

    }

    public static boolean checkIfAllFieldsAreChecked(Board board)
    {
        for (Field[] wiersz : board.getBoardFields())
        {
            for (Field field : wiersz)
            {
                if (!field.isSealed())
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkVictoryConditions(Board board, String tick, Field clickedField)
    {
        return checkVictoryForRows(board, tick, clickedField) || checkVictoryForColumns(board, tick, clickedField) || checkVictoryForDiagonals(board, tick);
    }

    private static boolean checkVictoryForRows(Board board, String tick, Field clickedField)
    {
        for (int i = 0; i < board.getBoardFields().length; i++)
        {
            Field[] wiersz = board.getBoardFields()[(int) clickedField.getMyPosition().x];
            if (!wiersz[i].getTextToPut().equals(tick))
            {
                return false;
            }
        }

        return true;
    }

    private static boolean checkVictoryForColumns(Board board, String tick, Field clickedField)
    {
        for (int i = 0; i < board.getBoardFields().length; i++)
        {
            for (int j = 0; j < board.getBoardFields()[i].length; j++)
            {
                int columnIndex = (int) clickedField.getMyPosition().y;
                if (!board.getBoardFields()[i][columnIndex].getTextToPut().equals(tick))
                {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkVictoryForDiagonals(Board board, String tick)
    {

        Vec2d[] diagonalPositions1 =
                {
                        new Vec2d(0,0),
                        new Vec2d(1,1),
                        new Vec2d(2,2)
                };

        Vec2d[] diagonalPositions2 =
                {
                        new Vec2d(0,2),
                        new Vec2d(1,1),
                        new Vec2d(2,0)
                };

        boolean checkDiagonal1 = checkDiagonal(diagonalPositions1,board,tick);
        boolean checkDiagonal2 = checkDiagonal(diagonalPositions2,board,tick);

        return checkDiagonal1 || checkDiagonal2;
    }

    private static boolean checkDiagonal(Vec2d [] diagonal, Board board, String tick)
    {
        for (Vec2d vector:diagonal)
        {
            if(!board.getBoardFields()[(int)vector.x][(int)vector.y].getTextToPut().equals(tick))
            {
                return false;
            }
        }

        return true;
    }

    public static void logMessageOnLabel(Label label, String textOnLabel)
    {
        label.setText(textOnLabel);
    }

}
