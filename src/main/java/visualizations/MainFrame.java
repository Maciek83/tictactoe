package visualizations;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private Board board;
    private Label info = new Label();


    public MainFrame(Board board) throws HeadlessException
    {
        setupMainFrame();

        this.board = board;
        info.setText("Game Info");
        info.setAlignment(1);
        info.setBounds(2,2,50,50);

        setupElementsInLayout();

    }

    public Label getInfo()
    {
        return info;
    }

    public void setInfo(Label info)
    {
        this.info = info;
    }

    private void setupElementsInLayout()
    {
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);

        this.add(info,BorderLayout.NORTH);
        this.add(board,BorderLayout.CENTER);

    }

    private void setupMainFrame()
    {
        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        centerThis();
    }

    private void centerThis()
    {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        this.setSize(400,400);

        int frameWidth = this.getSize().width;
        int frameHeight = this.getSize().height;

        this.setLocation((width-frameWidth)/2,(height-frameHeight)/2);
    }

}
