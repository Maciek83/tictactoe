package visualizations;

import com.sun.javafx.geom.Vec2d;
import players.Player;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel
{
    private Field[][] boardFields = new Field[3][3];
    private GridLayout gridLayout = new GridLayout(3, 3);

    public Field[][] getBoardFields()
    {
        return boardFields;
    }

    public void setBoardFields(Field[][] boardFields)
    {
        this.boardFields = boardFields;
    }

    public Board(Player player)
    {
        createFields(player);
        addBoardFields();
        this.setLayout(gridLayout);
    }


    private void addBoardFields()
    {
        for (Field[] wiersz : boardFields)
        {
            for (Field field : wiersz)
            {
                this.add(field);
            }
        }
    }

    private void createFields( Player player)
    {
        for (int i = 0; i < boardFields.length; i++)
        {
            for (int j = 0; j < boardFields[i].length; j++)
            {
                Field pole = new Field(player, new Vec2d(i,j));

                boardFields[i][j] = pole;
            }
        }
    }

}
