import players.Player;
import players.Robot;
import visualizations.Board;
import visualizations.MainFrame;

import javax.swing.*;

public class Game
{
    private Player player;
    private Robot robot;
    private Board board;
    private MainFrame mainFrame;

    public Game()
    {
        createPlayers();
        createBoard();
        askXorO();

        while (!GameManager.gameOver)
        {

            if(!player.isMyTurn())
            {
                waitMilisecounds(1000);

                GameManager.logMessageOnLabel(mainFrame.getInfo(),"Robot turn.");

                robot.tickField(board);

                if(robot.getChoosedField() != null)
                {
                    if(GameManager.checkVictoryConditions(board,robot.getCharacter(),robot.getChoosedField()))
                    {
                        GameManager.logMessageOnLabel(mainFrame.getInfo(),"Robot won!");
                        GameManager.gameOver = true;
                        break;
                    }
                }

                if(GameManager.checkIfAllFieldsAreChecked(board))
                {
                    GameManager.logMessageOnLabel(mainFrame.getInfo(),"The game ended in draw.");
                    GameManager.gameOver = true;
                    break;
                }

                player.setMyTurn(true);
            }

            if(player.isMyTurn())
            {
                waitMilisecounds(1000);

                if(player.getClickedField() != null)
                {
                    if(GameManager.checkVictoryConditions(board,player.getPlayWith(),player.getClickedField()))
                    {
                        GameManager.logMessageOnLabel(mainFrame.getInfo(),"You won!");
                        player.setMyTurn(false);
                        GameManager.gameOver = true;
                        break;
                    }
                }

                if(GameManager.checkIfAllFieldsAreChecked(board))
                {
                    GameManager.logMessageOnLabel(mainFrame.getInfo(),"The game ended in draw.");
                    player.setMyTurn(false);
                    GameManager.gameOver = true;
                    break;
                }

                GameManager.logMessageOnLabel(mainFrame.getInfo(),"Player turn.");

            }

        }
    }

    private void waitMilisecounds(int howMuch)
    {
        try
        {
            Thread.sleep(howMuch);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void createPlayers()
    {
        player = new Player();
        robot = new Robot();
    }

    private void createBoard()
    {
        board = new Board(player);

        mainFrame = new MainFrame(board);
    }

    private void askXorO()
    {
        Object[] options = {"x","o"};
        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showOptionDialog(mainFrame,"Do you want play 'x' or 'o' ?","Choose",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        if (response == JOptionPane.NO_OPTION) {

            player.setMyTurn(false);
            player.setPlayWith("o");
            robot.setCharacter("x");
        } else if (response == JOptionPane.YES_OPTION) {

            player.setMyTurn(true);
            player.setPlayWith("x");
            robot.setCharacter("o");
        } else if (response == JOptionPane.CLOSED_OPTION) {

            player.setMyTurn(true);
            player.setPlayWith("x");
            robot.setCharacter("o");
        }
    }


}
