package players;

import visualizations.Field;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Player extends MouseAdapter
{
    private Field clickedField;
    private String playWith = "x";
    private boolean myTurn=true;

    public String getPlayWith()
    {
        return playWith;
    }

    public void setPlayWith(String playWith)
    {
        this.playWith = playWith;
    }

    public Field getClickedField()
    {
        return clickedField;
    }

    public boolean isMyTurn()
    {
        return myTurn;
    }

    public void setMyTurn(boolean myTurn)
    {
        this.myTurn = myTurn;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        clickedField = (Field) e.getSource();

        if(!myTurn || clickedField.isSealed())
        {
            e.consume();

        }
        else
        {
            myTurn = false;
            clickedField.setSealed(true);
            clickedField.setTextToPut(playWith);
        }
    }



}
