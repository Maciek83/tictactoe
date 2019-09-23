package players;

import visualizations.Board;
import visualizations.Field;

import java.util.Random;

public class Robot
{

    private String character = "o";

    private Field choosedField;


    public String getCharacter()
    {
        return character;
    }

    public void setCharacter(String character)
    {
        this.character = character;
    }

    public Field getChoosedField()
    {
        return choosedField;
    }
    private Field chooseField(Board board)
    {
        int randomX = new Random().nextInt(board.getBoardFields().length);
        int ramdomY = new Random().nextInt(board.getBoardFields().length);

        if (board.getBoardFields()[randomX][ramdomY].isSealed())
        {
            return chooseField(board);
        }
        else
        {
            choosedField = board.getBoardFields()[randomX][ramdomY];
            choosedField.setSealed(true);
            return choosedField;
        }

    }

    public void tickField(Board board)
    {
        Field temp = chooseField(board);

        temp.setTextToPut(character);

    }


}
