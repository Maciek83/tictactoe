package visualizations;

import com.sun.javafx.geom.Vec2d;
import players.Player;

import javax.swing.*;
import java.awt.*;

public class Field extends JButton
{
    private boolean isSealed = false;
    private String textToPut = " ";
    private Vec2d myPosition;

    public Vec2d getMyPosition()
    {
        return myPosition;
    }

    public String getTextToPut()
    {
        return textToPut;
    }

    public void setTextToPut(String textToPut)
    {
        this.textToPut = textToPut;
        this.setText(textToPut);

    }

    public boolean isSealed()
    {
        return isSealed;
    }

    public void setSealed(boolean sealed)
    {
        isSealed = sealed;
    }

    public Field(Player player, Vec2d myPosition)
    {
        this.myPosition = myPosition;
        this.addMouseListener(player);
        setFieldSize(75, 75);
        setFont();
    }

    private void setFieldSize(int x, int y)
    {
        this.setSize(x, y);
        this.setPreferredSize(new Dimension(x, y));
        this.setMaximumSize(new Dimension(x, y));
        this.setMinimumSize(new Dimension(x, y));

    }

    private void setFont()
    {
        this.setFont(new Font(getFont().getFontName(), getFont().getStyle(), 35));
    }

}
