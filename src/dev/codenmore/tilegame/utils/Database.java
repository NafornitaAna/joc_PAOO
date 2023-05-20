package dev.codenmore.tilegame.utils;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.creatures.Player2;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.items.Item;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.State;

import java.sql.*;

public class Database
{
    private String filePath;
    private final Connection connection;
    public Database(String filePath) throws ClassNotFoundException, SQLException
    {
        this.filePath = filePath;
        this.connection = DriverManager.getConnection("jdbc:sqlite:" + filePath);
    }

    public void createNewTable()
    {
        String sql = "CREATE TABLE IF NOT EXISTS catOClock (\n"
                + " level integer NOT NULL,\n"
                + " scorPlayer1 integer NOT NULL,\n"
                + " scorPlayer2 integer NOT NULL, \n"
                + " harta string NOT NULL\n"
                + ");";

        try
        {
            Statement stmt = this.connection.createStatement();
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void insert(Handler handler, Player player, Player2 player2)
    {
        String sql = "INSERT INTO catOClock(level, scorPlayer1, scorPlayer2, harta) VALUES(?,?,?,?)";
        int lvl=0;
        try
        {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            if(State.getState()== handler.getGame().menuState)
            {
                pstmt.setDouble(1, 0);
                lvl=0;
            }
            if(State.getState()== handler.getGame().gameState)
            {
                pstmt.setDouble(1, 1);
                lvl=1;
            }
            if(State.getState()== handler.getGame().gameState2)
            {
                pstmt.setDouble(1, 2);
                lvl=2;
            }
            if(State.getState()== handler.getGame().gameState3)
            {
                pstmt.setDouble(1, 3);
                lvl=3;
            }
            pstmt.setDouble(2, player.getInventory().getInventoryItems().getCount());
            pstmt.setDouble(3, player2.getInventory().getInventoryItems2().getCount());
            pstmt.setString(4, "res/worlds/world" + lvl + ".txt");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dropTable()
    {
        String url = "jdbc:sqlite:database.db";

        // SQL statement for creating a new table
        String sql = "DROP TABLE IF EXISTS 'catOClock' ";

        try
        {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public String selectAll()
    {
        String sql = "SELECT * FROM catOClock";
        String rez = null;
        try
        {
            Connection conn = this.connection;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next())
            {
                rez= rs.getString("level") + " " +
                        rs.getInt("scorPlayer1") + " " +
                        rs.getInt("scorPlayer2") + " " +
                        rs.getInt("harta");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return rez;
    }

    public void printAll()
    {
        String sql = "SELECT * FROM catOClock";
        String rez = null;
        try
        {
            Connection conn = this.connection;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                rez= rs.getString("level") + " " +
                        rs.getInt("scorPlayer1") + " " +
                        rs.getInt("scorPlayer2") + " " +
                        rs.getInt("harta");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(rez);
    }
    public void restoreData(Handler handler){
        if (this.selectAll() != null) {
            String[] date=this.selectAll().split(" ");
            int level = Integer.parseInt(date[0]);
            if(level==0||level==1)
            {
                State.setState(handler.getGame().gameState);
            }
            if(level==2)
            {
                State.setState(handler.getGame().gameState2);
            }
            if(level==3)
            {
                State.setState(handler.getGame().gameState3);
            }

            int scorPlayer1 = Integer.parseInt(date[1]);
            handler.getWorld().getEntityManager().getPlayer().getInventory().setInventoryItems(new Item(Assets.xp,"xp",0));
            handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems().setCount(scorPlayer1);

            int scorPlayer2 = Integer.parseInt(date[2]);
            handler.getWorld().getEntityManager().getPlayer2().getInventory().setInventoryItems2(new Item(Assets.xp,"xp",0));
            handler.getWorld().getEntityManager().getPlayer2().getInventory().getInventoryItems2().setCount(scorPlayer2);
        }

    }

    public int getLevel()
    {
        if (this.selectAll() != null) {
            String[] date = this.selectAll().split(" ");
            int level = Integer.parseInt(date[0]);
            return level;
        }
        return -1;
    }

}
