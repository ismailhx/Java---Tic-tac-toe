import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import java.util.Random;

/**
 * This is a class for a medium level tic tac toe game.
 *
 * @author (Ismail Hendryx)
 * @version (18/03/2022)
 */

public class ticTactoe {
    // creates the components needed for the GUI
    private static JFrame frame;
    static JTextField username = new JTextField(35);
    static JLabel label1 = new JLabel("Hey there! What's your name?");
    static JButton Replay = new JButton("Re-play");
    static JButton Start = new JButton("Start");
    static JMenuItem menuitem1 = new JMenuItem("Reset");
    static JMenuItem menuitem2 = new JMenuItem("Quit");
    static JButton a = new JButton("");
    static JButton b = new JButton("");
    static JButton c = new JButton("");
    static JButton d = new JButton("");
    static JButton e = new JButton("");
    static JButton f = new JButton("");
    static JButton g = new JButton("");
    static JButton h = new JButton("");
    static JButton i = new JButton("");
    static JPanel middleGRID = new JPanel();
    static JMenuBar menubar = new JMenuBar();

    /**
     * Constructor for objects of class ticTactoe that makes the frame
     */

    public ticTactoe() {
        makeFrame();
    }

    /**
     * Creates the Swing frame and its content.
     * The frame and content pane are made with an orange background.
     * It has a starting frame size.
     * Jlabels, JPanels,buttons and button cells are made and added to a grid
     * layout.
     * Action listeners are added here and the JTextfield username is set.
     */

    static void makeFrame() {
        frame = new JFrame("GridLayout");
        Container maincontentPane = frame.getContentPane();
        maincontentPane.setLayout(new BorderLayout());
        maincontentPane.setBackground(Color.ORANGE);
        frame.setSize(520, 550);

        label1.setFont(new Font("Agency FB", Font.BOLD, 17));
        label1.setForeground(Color.DARK_GRAY);
        label1.setOpaque(true);
        label1.setBackground(Color.PINK);
        // makes a label
        username.setText("");

        JPanel topInput = new JPanel();
        topInput.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));
        maincontentPane.add(topInput, BorderLayout.NORTH);
        // makes an input space at the top
        topInput.setBackground(Color.ORANGE);
        topInput.add(label1);

        JPanel leftInput = new JPanel();
        leftInput.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 10));
        maincontentPane.add(leftInput, BorderLayout.WEST);
        // makes an input space at the left
        leftInput.setBackground(Color.ORANGE);

        // Right side
        JPanel rightInput = new JPanel();
        rightInput.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));
        maincontentPane.add(rightInput, BorderLayout.EAST);
        // makes an input space at the top
        rightInput.setBackground(Color.ORANGE);
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(2, 1, 0, 160));
        // 160 is the gap between the two buttons
        buttons.add(Start);
        buttons.add(Replay);
        buttons.setBackground(Color.ORANGE);
        rightInput.add(buttons);
        Start.setBackground(Color.GREEN);
        Start.setForeground(Color.ORANGE);
        Start.setFont(new Font("AGENCY FB", Font.BOLD, 25));
        Replay.setBackground(Color.red);
        Replay.setForeground(Color.ORANGE);
        Replay.setFont(new Font("AGENCY FB", Font.BOLD, 25));

        middleGRID.setLayout(new GridLayout(3, 3));
        // makes the grid layout with a space of 1 between rows and columns

        a.setBackground(Color.red);
        b.setBackground(Color.pink);
        c.setBackground(Color.red);
        d.setBackground(Color.pink);
        e.setBackground(Color.red);
        f.setBackground(Color.pink);
        g.setBackground(Color.red);
        h.setBackground(Color.pink);
        i.setBackground(Color.red);

        // makes the buttons
        middleGRID.add(a);
        middleGRID.add(b);
        middleGRID.add(c);
        middleGRID.add(d);
        middleGRID.add(e);
        middleGRID.add(f);
        middleGRID.add(g);
        middleGRID.add(h);
        middleGRID.add(i);
        // Adds the buttons

        Start.addActionListener(ev -> startGame());
        a.addActionListener(ev -> cell());
        b.addActionListener(ev -> cell1());
        c.addActionListener(ev -> cell2());
        d.addActionListener(ev -> cell3());
        e.addActionListener(ev -> cell4());
        f.addActionListener(ev -> cell5());
        g.addActionListener(ev -> cell6());
        h.addActionListener(ev -> cell7());
        i.addActionListener(ev -> cell8());

        // Gives the buttons action listeners

        // Styles the buttons

        maincontentPane.add(middleGRID);

        // a second label

        JLabel label2 = new JLabel("Please enter your username below:");
        label2.setFont(new Font("Agency FB", Font.BOLD, 14));
        label2.setForeground(Color.DARK_GRAY);
        label2.setOpaque(true);
        label2.setBackground(Color.PINK);

        JPanel bottomInput = new JPanel();
        bottomInput.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 20));
        maincontentPane.add(bottomInput, BorderLayout.SOUTH);
        // makes an input space at the bottom
        bottomInput.setBackground(Color.ORANGE);
        bottomInput.add(label2);
        bottomInput.add(username);
        username.setBackground(Color.PINK);
        username.setFont(new Font("AGENCY FB", Font.BOLD, 15));
        username.setForeground(Color.GRAY);
        username.setText("");
        makeMenu();

        frame.setVisible(true);

        username.addActionListener(ev -> usernameSetting());
        Replay.addActionListener(ev -> replay());
    }

    /**
     * makeMenu sets the menu.
     * It has a pink background with a font used all accross the GUI.
     * 2 menu items are added, reset and quit.
     * They both have Actionlisteners directed to two methods.
     *
     */
    public static void makeMenu() {
        frame.setJMenuBar(menubar);
        JMenu menu1 = new JMenu("Menu");
        // before we run this we need to add it to our menu bar
        menubar.add(menu1);
        menubar.setBackground(Color.PINK);
        menu1.setFont(new Font("Agency FB", Font.BOLD, 15));
        menu1.add(menuitem1); // adds the menu item to the menu option
        menu1.add(menuitem2); // added after menuitem1 as this is the order it was added in
        menuitem1.setForeground(Color.BLACK);
        menuitem1.setBackground(Color.green);
        menuitem1.setFont(new Font("Agency FB", Font.BOLD, 15));
        menuitem2.setForeground(Color.BLACK);
        menuitem2.setBackground(Color.RED);
        menuitem2.setFont(new Font("Agency FB", Font.BOLD, 15));
        // quits the window
        menuitem1.addActionListener(ev -> reset());
        menuitem2.addActionListener(e -> quit());
    }

    /**
     * startGame checks if the username is not empty, if so the button is diabled.
     * This means a game in play cannot be interrupted.
     *
     */
    public static void startGame()

    {
        if (!username.getText().equals("")) {
            Start.setBackground(Color.GRAY);
            Start.setText("In play");
            username.setEditable(false);
        }
    }

    /**
     * replay checks if any grid cells is not empty.
     * If not the method during the middle of a game session, or if the
     * current game session is finished, allows the user to “Re-play” to start a new
     * game session (without
     * changing username). It also restores the Start button and the grid cells back
     * to their original colours.
     *
     */
    public static void replay()

    {
        // keeps username same
        // label changes back
        // startbutton resets
        if (!(a.getText().equals("") && b.getText().equals("") && c.getText().equals("") && d.getText().equals("")
                && e.getText().equals("") && f.getText().equals("") && g.getText().equals("") && h.getText().equals("")
                && i.getText().equals(""))) {
            label1.setText(username.getText()
                    + " click 'Start' and a cell to place a nought. The AI will place an X after you.");
            username.setEditable(false);
            a.setText("");
            b.setText("");
            c.setText("");
            d.setText("");
            e.setText("");
            f.setText("");
            g.setText("");
            h.setText("");
            i.setText("");
            Start.setBackground(Color.GREEN);
            Start.setForeground(Color.ORANGE);
            menubar.setBackground(Color.PINK);
            Start.setText("Start");
        }
        a.setEnabled(true);
        b.setEnabled(true);
        c.setEnabled(true);
        d.setEnabled(true);
        e.setEnabled(true);
        f.setEnabled(true);
        g.setEnabled(true);
        h.setEnabled(true);
        i.setEnabled(true);

        a.setBackground(Color.red);
        b.setBackground(Color.pink);
        c.setBackground(Color.red);
        d.setBackground(Color.pink);
        e.setBackground(Color.red);
        f.setBackground(Color.pink);
        g.setBackground(Color.red);
        h.setBackground(Color.pink);
        i.setBackground(Color.red);

    }

    /**
     * This method quits the game.
     *
     */
    public static void quit()

    {
        System.exit(0);
    }

    /**
     * This resets the whole board and asks for a username and sets the grid cells
     * back their orignal colours.
     *
     */
    public static void reset()

    {
        label1.setText("Hey there! What's your name?");
        username.setText("");
        username.setEditable(true);
        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
        e.setText("");
        f.setText("");
        g.setText("");
        h.setText("");
        i.setText("");
        Start.setBackground(Color.GREEN);
        Start.setForeground(Color.ORANGE);
        menubar.setBackground(Color.PINK);
        Start.setText("Start");
        a.setEnabled(true);
        b.setEnabled(true);
        c.setEnabled(true);
        d.setEnabled(true);
        e.setEnabled(true);
        f.setEnabled(true);
        g.setEnabled(true);
        h.setEnabled(true);
        i.setEnabled(true);

        a.setBackground(Color.red);
        b.setBackground(Color.pink);
        c.setBackground(Color.red);
        d.setBackground(Color.pink);
        e.setBackground(Color.red);
        f.setBackground(Color.pink);
        g.setBackground(Color.red);
        h.setBackground(Color.pink);
        i.setBackground(Color.red);

    }

    /**
     * usernameSetting makes the JTextField accept all names except empty strings.
     *
     */
    public static void usernameSetting() {
        if (!username.getText().equals("")) {
            label1.setText(
                    username.getText() + " click 'Start' and then place a nought. The AI will place an X after you.");
        } else {
            label1.setText(" Please give a valid username. ");
        }
    }

    /**
     * draw checks the grid for a draw.
     *
     * @returns false if all cells arent filled or the winning conditions are met.
     * @ returns true if its a draw
     * 
     * 
     */
    public static boolean draw()

    {
        if (a.getText().equals("") ||
                b.getText().equals("") ||
                c.getText().equals("") ||
                d.getText().equals("") ||
                e.getText().equals("") ||
                f.getText().equals("") ||
                g.getText().equals("") ||
                h.getText().equals("") ||
                i.getText().equals("")) {
            return false;
        } else if (winningConditions() == true || winningConditions1() == true) {
            return false;
        } else {
            label1.setText(" (-.-) It's a draw! Well done. [-_-]");
            menubar.setBackground(Color.LIGHT_GRAY);
            a.setEnabled(false);
            b.setEnabled(false);
            c.setEnabled(false);
            d.setEnabled(false);
            e.setEnabled(false);
            f.setEnabled(false);
            g.setEnabled(false);
            h.setEnabled(false);
            i.setEnabled(false);
            return true;
        }

    }

    /**
     * winningConditions describes the 8 winning positions for O. If any of these
     * conditions are met, its game over.
     * 
     * @return true if O wins or false if O doesnt win
     */
    public static boolean winningConditions() {
        if ((a.getText().equals("O") && b.getText().equals("O") && c.getText().equals("O"))
                || (d.getText().equals("O") && e.getText().equals("O") && f.getText().equals("O"))
                || (g.getText().equals("O") && h.getText().equals("O") && i.getText().equals("O"))
                || (a.getText().equals("O") && d.getText().equals("O") && g.getText().equals("O"))
                || (b.getText().equals("O") && e.getText().equals("O") && h.getText().equals("O"))
                || (c.getText().equals("O") && f.getText().equals("O") && i.getText().equals("O"))
                || (a.getText().equals("O") && e.getText().equals("O") && i.getText().equals("O"))
                || (c.getText().equals("O") && e.getText().equals("O") && g.getText().equals("O"))) {
            label1.setText(username.getText() + " wins! (^.^)");
            menubar.setBackground(Color.GREEN);
            a.setEnabled(false);
            b.setEnabled(false);
            c.setEnabled(false);
            d.setEnabled(false);
            e.setEnabled(false);
            f.setEnabled(false);
            g.setEnabled(false);
            h.setEnabled(false);
            i.setEnabled(false);

            a.setBackground(Color.GREEN);
            b.setBackground(Color.GREEN);
            c.setBackground(Color.GREEN);
            d.setBackground(Color.GREEN);
            e.setBackground(Color.GREEN);
            f.setBackground(Color.GREEN);
            g.setBackground(Color.GREEN);
            h.setBackground(Color.GREEN);
            i.setBackground(Color.GREEN);

            return true;
        }
        // }
        else {
            return false;
        }
    }

    /**
     * winningConditions describes the 8 winning positions for O. If any of these
     * conditions are met, its game over.
     * 
     * @return true if X wins or false if X doesnt win
     */
    public static boolean winningConditions1() {
        if (((a.getText().equals("X") && b.getText().equals("X") && c.getText().equals("X"))
                || (d.getText().equals("X") && e.getText().equals("X") && f.getText().equals("X"))
                || (g.getText().equals("X") && h.getText().equals("X") && i.getText().equals("X"))
                || (a.getText().equals("X") && d.getText().equals("X") && g.getText().equals("X"))
                || (b.getText().equals("X") && e.getText().equals("X") && h.getText().equals("X"))
                || (c.getText().equals("X") && f.getText().equals("X") && i.getText().equals("X"))
                || (a.getText().equals("X") && e.getText().equals("X") && i.getText().equals("X"))
                || (c.getText().equals("X") && e.getText().equals("X") && g.getText().equals("X")))) {
            label1.setText("AI wins! [o_o]");
            menubar.setBackground(Color.CYAN);
            a.setEnabled(false);
            b.setEnabled(false);
            c.setEnabled(false);
            d.setEnabled(false);
            e.setEnabled(false);
            f.setEnabled(false);
            g.setEnabled(false);
            h.setEnabled(false);
            i.setEnabled(false);

            a.setBackground(Color.CYAN);
            b.setBackground(Color.CYAN);
            c.setBackground(Color.CYAN);
            d.setBackground(Color.CYAN);
            e.setBackground(Color.CYAN);
            f.setBackground(Color.CYAN);
            g.setBackground(Color.CYAN);
            h.setBackground(Color.CYAN);
            i.setBackground(Color.CYAN);

            return true;
        }
        // }
        else {
            return false;
        }
    }

    /**
     * winningPositions First looks for the win, where two X's are next to each
     * other it then places the X in the final spot.
     * If this is false it then looks at the O's looking for the win and blocks and
     * stops it.
     * It then looks at a bunch of other scenarios and it is programmed to make the
     * best moves according to those scenarios.
     * If none of these apply all 9 grid cells are gone through to see which is
     * empty and can be filled.
     *
     */
    public static void winningPositions() {

        if ((a.getText().equals("X") && b.getText().equals("X") && c.getText().equals("")) ||
                (b.getText().equals("X") && c.getText().equals("X") && a.getText().equals("")) ||
                (a.getText().equals("X") && c.getText().equals("X") && b.getText().equals(""))) {
            if (r() == true) {
                r();
            } else if (s() == true) {
                s();
            } else if (t() == true) {
                t();
            }
        } else if ((d.getText().equals("X") && e.getText().equals("X") && f.getText().equals("")) ||
                (d.getText().equals("X") && f.getText().equals("X") && e.getText().equals("")) ||
                (f.getText().equals("X") && e.getText().equals("X") && d.getText().equals(""))) {
            if (u() == true) {
                u();
            } else if (v() == true) {
                v();
            } else if (w() == true) {
                w();
            }
        }

        else if ((g.getText().equals("X") && h.getText().equals("X") && i.getText().equals("")) ||
                (g.getText().equals("X") && i.getText().equals("X") && h.getText().equals("")) ||
                (h.getText().equals("X") && g.getText().equals("X") && i.getText().equals(""))) {
            if (x() == true) {
                x();
            } else if (y() == true) {
                y();
            } else if (z() == true) {
                z();
            }
        }

        else if ((a.getText().equals("X") && d.getText().equals("X") && g.getText().equals("")) ||
                (a.getText().equals("X") && g.getText().equals("X") && d.getText().equals("")) ||
                (d.getText().equals("X") && g.getText().equals("X") && a.getText().equals(""))) {
            if (r() == true) {
                r();
            } else if (u() == true) {
                u();
            } else if (x() == true) {
                x();
            }
        }

        else if ((b.getText().equals("X") && e.getText().equals("X") && h.getText().equals("")) ||
                (b.getText().equals("X") && h.getText().equals("X") && e.getText().equals("")) ||
                (e.getText().equals("X") && h.getText().equals("X") && b.getText().equals(""))) {
            if (s() == true) {
                s();
            } else if (v() == true) {
                v();
            } else if (y() == true) {
                y();
            }
        }

        else if ((c.getText().equals("X") && f.getText().equals("X") && i.getText().equals("")) ||
                (c.getText().equals("X") && i.getText().equals("X") && f.getText().equals("")) ||
                (f.getText().equals("X") && i.getText().equals("X") && c.getText().equals(""))) {
            if (t() == true) {
                t();
            } else if (w() == true) {
                w();
            } else if (z() == true) {
                z();
            }
        }

        else if ((a.getText().equals("X") && e.getText().equals("X") && i.getText().equals("")) ||
                (a.getText().equals("X") && i.getText().equals("X") && e.getText().equals("")) ||
                (e.getText().equals("X") && i.getText().equals("X") && a.getText().equals(""))) {
            if (r() == true) {
                r();
            } else if (v() == true) {
                v();
            } else if (z() == true) {
                z();
            }
        }

        else if ((c.getText().equals("X") && e.getText().equals("X") && g.getText().equals("")) ||
                (c.getText().equals("X") && g.getText().equals("X") && e.getText().equals("")) ||
                (g.getText().equals("X") && e.getText().equals("X") && c.getText().equals(""))) {
            if (t() == true) {
                t();
            } else if (v() == true) {
                v();
            } else if (x() == true) {
                x();
            }
        }

        else if ((a.getText().equals("O") && b.getText().equals("O") && c.getText().equals("")) ||
                (b.getText().equals("O") && c.getText().equals("O") && a.getText().equals("")) ||
                (a.getText().equals("O") && c.getText().equals("O") && b.getText().equals(""))) {
            if (r() == true) {
                r();
            } else if (s() == true) {
                s();
            } else if (t() == true) {
                t();
            }
        } else if ((d.getText().equals("O") && e.getText().equals("O") && f.getText().equals("")) ||
                (d.getText().equals("O") && f.getText().equals("O") && e.getText().equals("")) ||
                (f.getText().equals("O") && e.getText().equals("O") && d.getText().equals(""))) {
            if (u() == true) {
                u();
            } else if (v() == true) {
                v();
            } else if (w() == true) {
                w();
            }
        }

        else if ((g.getText().equals("O") && h.getText().equals("O") && i.getText().equals("")) ||
                (g.getText().equals("O") && i.getText().equals("O") && h.getText().equals("")) ||
                (h.getText().equals("O") && g.getText().equals("O") && i.getText().equals(""))) {
            if (x() == true) {
                x();
            } else if (y() == true) {
                y();
            } else if (z() == true) {
                z();
            }
        }

        else if ((a.getText().equals("O") && d.getText().equals("O") && g.getText().equals("")) ||
                (a.getText().equals("O") && g.getText().equals("O") && d.getText().equals("")) ||
                (d.getText().equals("O") && g.getText().equals("O") && a.getText().equals(""))) {
            if (r() == true) {
                r();
            } else if (u() == true) {
                u();
            } else if (x() == true) {
                x();
            }
        }

        else if ((b.getText().equals("O") && e.getText().equals("O") && h.getText().equals("")) ||
                (b.getText().equals("O") && h.getText().equals("O") && e.getText().equals("")) ||
                (e.getText().equals("O") && h.getText().equals("O") && b.getText().equals(""))) {
            if (s() == true) {
                s();
            } else if (v() == true) {
                v();
            } else if (y() == true) {
                y();
            }
        }

        else if ((c.getText().equals("O") && f.getText().equals("O") && i.getText().equals("")) ||
                (c.getText().equals("O") && i.getText().equals("O") && f.getText().equals("")) ||
                (f.getText().equals("O") && i.getText().equals("O") && c.getText().equals(""))) {
            if (t() == true) {
                t();
            } else if (w() == true) {
                w();
            } else if (z() == true) {
                z();
            }
        }

        else if ((a.getText().equals("O") && e.getText().equals("O") && i.getText().equals("")) ||
                (a.getText().equals("O") && i.getText().equals("O") && e.getText().equals("")) ||
                (e.getText().equals("O") && i.getText().equals("O") && a.getText().equals(""))) {
            if (r() == true) {
                r();
            } else if (v() == true) {
                v();
            } else if (z() == true) {
                z();
            }
        }

        else if ((c.getText().equals("O") && e.getText().equals("O") && g.getText().equals("")) ||
                (c.getText().equals("O") && g.getText().equals("O") && e.getText().equals("")) ||
                (g.getText().equals("O") && e.getText().equals("O") && c.getText().equals(""))) {
            if (t() == true) {
                t();
            } else if (v() == true) {
                v();
            } else if (x() == true) {
                x();
            }
        }

        else if (a.getText().equals("O") && f.getText().equals("O") && c.getText().equals("")) {
            if (t() == true) {
                t();
            } else if (e.getText().equals("")) {
                v();
            } else if (a.getText().equals("")) {
                r();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (i.getText().equals("")) {
                z();
            } else if (f.getText().equals("")) {
                w();
            } else if (g.getText().equals("")) {
                x();
            } else if (h.getText().equals("")) {
                y();
            }
        }

        else if (a.getText().equals("O") && f.getText().equals("O") && c.getText().equals("")) {
            if (t() == true) {
                t();
            } else if (e.getText().equals("")) {
                v();
            } else if (a.getText().equals("")) {
                r();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (i.getText().equals("")) {
                z();
            } else if (f.getText().equals("")) {
                w();
            } else if (g.getText().equals("")) {
                x();
            } else if (h.getText().equals("")) {
                y();
            }
        }

        else if (a.getText().equals("O") && h.getText().equals("O") && g.getText().equals("")) {
            if (y() == true) {
                y();
            } else if (e.getText().equals("")) {
                v();
            } else if (a.getText().equals("")) {
                r();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (i.getText().equals("")) {
                z();
            } else if (f.getText().equals("")) {
                w();
            } else if (g.getText().equals("")) {
                x();
            } else if (c.getText().equals("")) {
                t();
            }
        }

        else if (b.getText().equals("O") && d.getText().equals("O") && a.getText().equals("")) {
            if (r() == true) {
                r();
            } else if (e.getText().equals("")) {
                v();
            } else if (c.getText().equals("")) {
                t();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (i.getText().equals("")) {
                z();
            } else if (f.getText().equals("")) {
                w();
            } else if (g.getText().equals("")) {
                x();
            } else if (h.getText().equals("")) {
                y();
            }
        }

        else if (b.getText().equals("O") && f.getText().equals("O") && c.getText().equals("")) {
            if (t() == true) {
                t();
            } else if (e.getText().equals("")) {
                v();
            } else if (a.getText().equals("")) {
                r();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (i.getText().equals("")) {
                z();
            } else if (f.getText().equals("")) {
                w();
            } else if (g.getText().equals("")) {
                x();
            } else if (h.getText().equals("")) {
                y();
            }
        }

        else if (b.getText().equals("O") && g.getText().equals("O") && a.getText().equals("")) {
            if (r() == true) {
                r();
            } else if (e.getText().equals("")) {
                v();
            } else if (c.getText().equals("")) {
                t();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (i.getText().equals("")) {
                z();
            } else if (f.getText().equals("")) {
                w();
            } else if (g.getText().equals("")) {
                x();
            } else if (h.getText().equals("")) {
                y();
            }
        }

        else if (b.getText().equals("O") && i.getText().equals("O") && c.getText().equals("")) {
            if (t() == true) {
                t();
            } else if (e.getText().equals("")) {
                v();
            } else if (a.getText().equals("")) {
                r();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (i.getText().equals("")) {
                z();
            } else if (f.getText().equals("")) {
                w();
            } else if (g.getText().equals("")) {
                x();
            } else if (h.getText().equals("")) {
                y();
            }
        }

        else if (c.getText().equals("O") && d.getText().equals("O") && a.getText().equals("")) {
            if (r() == true) {
                r();
            } else if (e.getText().equals("")) {
                v();
            } else if (i.getText().equals("")) {
                z();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (c.getText().equals("")) {
                t();
            } else if (f.getText().equals("")) {
                w();
            } else if (g.getText().equals("")) {
                x();
            } else if (h.getText().equals("")) {
                y();
            }
        }

        else if (c.getText().equals("O") && h.getText().equals("O") && i.getText().equals("")) {
            if (z() == true) {
                z();
            } else if (e.getText().equals("")) {
                v();
            } else if (a.getText().equals("")) {
                r();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (c.getText().equals("")) {
                t();
            } else if (f.getText().equals("")) {
                w();
            } else if (g.getText().equals("")) {
                x();
            } else if (h.getText().equals("")) {
                y();
            }
        }

        else if (d.getText().equals("O") && h.getText().equals("O") && g.getText().equals("")) {
            if (x() == true) {
                x();
            } else if (e.getText().equals("")) {
                v();
            } else if (a.getText().equals("")) {
                r();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (c.getText().equals("")) {
                t();
            } else if (f.getText().equals("")) {
                w();
            } else if (i.getText().equals("")) {
                z();
            } else if (h.getText().equals("")) {
                y();
            }
        }

        else if (d.getText().equals("O") && i.getText().equals("O") && g.getText().equals("")) {
            if (x() == true) {
                x();
            } else if (e.getText().equals("")) {
                v();
            } else if (a.getText().equals("")) {
                r();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (c.getText().equals("")) {
                t();
            } else if (f.getText().equals("")) {
                w();
            } else if (i.getText().equals("")) {
                z();
            } else if (h.getText().equals("")) {
                y();
            }
        }

        else if (f.getText().equals("O") && g.getText().equals("O") && i.getText().equals("")) {
            if (z() == true) {
                z();
            } else if (e.getText().equals("")) {
                v();
            } else if (a.getText().equals("")) {
                r();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (c.getText().equals("")) {
                t();
            } else if (f.getText().equals("")) {
                w();
            } else if (g.getText().equals("")) {
                x();
            } else if (h.getText().equals("")) {
                y();
            }
        }

        else if (f.getText().equals("O") && h.getText().equals("O") && i.getText().equals("")) {
            if (z() == true) {
                z();
            } else if (e.getText().equals("")) {
                v();
            } else if (a.getText().equals("")) {
                r();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (c.getText().equals("")) {
                t();
            } else if (f.getText().equals("")) {
                w();
            } else if (g.getText().equals("")) {
                x();
            } else if (h.getText().equals("")) {
                y();
            }
        }

        else {
            if (e.getText().equals("")) {
                v();
            } else if (a.getText().equals("")) {
                r();
            } else if (d.getText().equals("")) {
                u();
            } else if (b.getText().equals("")) {
                s();
            } else if (c.getText().equals("")) {
                t();
            } else if (f.getText().equals("")) {
                w();
            } else if (g.getText().equals("")) {
                x();
            } else if (h.getText().equals("")) {
                y();
            } else if (i.getText().equals("")) {
                z();
            }
        }
    }

    /**
     * cell checks if their is a winner and if the game is still in play.
     * It then adds an O if not which is followed by the addition of an X and a
     * series of checks to see the game result.
     *
     */
    public static void cell() {
        if (a.getText().equals("") && Start.getText().equals("In play")) {
            a.setText("O");
            a.setForeground(Color.GREEN);
            if (winningConditions() == true) {
                winningConditions();
            }
            // fills the middle first always
            else {
                winningPositions();
                if (winningConditions1() == true && winningConditions() == false) {
                    winningConditions1();
                }
            }
            if (draw() == true) {
                draw();
            }
        }

        a.setFont(new Font("Arial FB", Font.PLAIN, 60));
    }

    /**
     * cell1 checks if their is a winner and if the game is still in play.
     * It then adds an O if not which is followed by the addition of an X and a
     * series of checks to see the game result.
     *
     */
    public static void cell1() {
        if (b.getText().equals("") && Start.getText().equals("In play"))

        {
            b.setText("O");
            b.setForeground(Color.GREEN);
            if (winningConditions() == true) {
                winningConditions();
            } else {
                winningPositions();
                if (winningConditions1() == true && winningConditions() == false) {
                    winningConditions1();
                }
            }
            if (draw() == true) {
                draw();
            }
        }

        b.setFont(new Font("Arial FB", Font.PLAIN, 60));
    }

    /**
     * cell2 checks if their is a winner and if the game is still in play.
     * It then adds an O if not which is followed by the addition of an X and a
     * series of checks to see the game result.
     *
     */
    public static void cell2() {
        if (c.getText().equals("") && Start.getText().equals("In play"))

        {
            c.setText("O");
            c.setForeground(Color.GREEN);
            if (winningConditions() == true) {
                winningConditions();
            } else {
                winningPositions();
                if (winningConditions1() == true && winningConditions() == false) {
                    winningConditions1();
                }
            }
            if (draw() == true) {
                draw();
            }
        }

        c.setFont(new Font("Arial FB", Font.PLAIN, 60));
    }

    /**
     * cell3 checks if their is a winner and if the game is still in play.
     * It then adds an O if not which is followed by the addition of an X and a
     * series of checks to see the game result.
     *
     */
    public static void cell3() {
        if (d.getText().equals("") && Start.getText().equals("In play"))

        {
            d.setText("O");
            d.setForeground(Color.GREEN);
            if (winningConditions() == true) {
                winningConditions();
            } else {
                winningPositions();
                if (winningConditions1() == true && winningConditions() == false) {
                    winningConditions1();
                }
            }
            if (draw() == true) {
                draw();
            }
        }

        d.setFont(new Font("Arial FB", Font.PLAIN, 60));
    }

    /**
     * cell4 checks if their is a winner and if the game is still in play.
     * It then adds an O if not which is followed by the addition of an X and a
     * series of checks to see the game result.
     *
     */
    public static void cell4() {
        if (e.getText().equals("") && Start.getText().equals("In play"))

        {
            e.setText("O");
            e.setForeground(Color.GREEN);
            if (winningConditions() == true) {
                winningConditions();
            } else {
                winningPositions();
                if (winningConditions1() == true && winningConditions() == false) {
                    winningConditions1();
                }
            }
            if (draw() == true) {
                draw();
            }
        }

        e.setFont(new Font("Arial FB", Font.PLAIN, 60));
    }

    /**
     * cell5 checks if their is a winner and if the game is still in play.
     * It then adds an O if not which is followed by the addition of an X and a
     * series of checks to see the game result.
     *
     */
    public static void cell5() {
        if (f.getText().equals("") && Start.getText().equals("In play")) {
            f.setText("O");
            f.setForeground(Color.GREEN);
            if (winningConditions() == true) {
                winningConditions();
            } else {
                winningPositions();
                if (winningConditions1() == true && winningConditions() == false) {
                    winningConditions1();
                }
            }
            if (draw() == true) {
                draw();
            }
        }

        f.setFont(new Font("Arial FB", Font.PLAIN, 60));

    }

    /**
     * cell6 checks if their is a winner and if the game is still in play.
     * It then adds an O if not which is followed by the addition of an X and a
     * series of checks to see the game result.
     *
     */
    public static void cell6() {
        if (g.getText().equals("") && Start.getText().equals("In play"))

        {
            g.setText("O");
            g.setForeground(Color.GREEN);
            if (winningConditions() == true) {
                winningConditions();
            } else {
                winningPositions();
                if (winningConditions1() == true && winningConditions() == false) {
                    winningConditions1();
                }
            }
            if (draw() == true) {
                draw();
            }
        }
        g.setFont(new Font("Arial FB", Font.PLAIN, 60));
    }

    /**
     * cell7 checks if their is a winner and if the game is still in play.
     * It then adds an O if not which is followed by the addition of an X and a
     * series of checks to see the game result.
     *
     */
    public static void cell7() {
        if (h.getText().equals("") && Start.getText().equals("In play"))

        {
            h.setText("O");
            h.setForeground(Color.GREEN);
            if (winningConditions() == true) {
                winningConditions();
            } else {
                winningPositions();
                if (winningConditions1() == true && winningConditions() == false) {
                    winningConditions1();
                }
            }
            if (draw() == true) {
                draw();
            }
        }

        h.setFont(new Font("Arial FB", Font.PLAIN, 60));
    }

    /**
     * cell8 checks if their is a winner and if the game is still in play.
     * It then adds an O if not which is followed by the addition of an X and a
     * series of checks to see the game result.
     *
     */
    public static void cell8() {
        if (i.getText().equals("") && Start.getText().equals("In play"))

        {
            i.setText("O");
            i.setForeground(Color.GREEN);
            if (winningConditions() == true) {
                winningConditions();
            } else {
                winningPositions();
                if (winningConditions1() == true && winningConditions() == false) {
                    winningConditions1();
                }
            }
            if (draw() == true) {
                draw();
            }
        }

        i.setFont(new Font("Arial FB", Font.PLAIN, 60));
    }

    /**
     * @ returns true if it can add an X to the selected cell else its false.
     */
    public static boolean r() {
        if (a.getText().equals(""))

        {
            a.setText("X");
            a.setForeground(Color.CYAN);
            a.setFont(new Font("Arial FB", Font.PLAIN, 60));
            return true;
        } else {
            return false;
        }
    }

    /**
     * @ returns true if it can add an X to the selected cell else its false.
     */
    public static boolean s() {
        if (b.getText().equals(""))

        {
            b.setText("X");
            b.setForeground(Color.CYAN);
            b.setFont(new Font("Arial FB", Font.PLAIN, 60));
            return true;
        } else {
            return false;
        }
    }

    /**
     * @ returns true if it can add an X to the selected cell else its false.
     */
    public static boolean t() {
        if (c.getText().equals(""))

        {
            c.setText("X");
            c.setForeground(Color.CYAN);
            c.setFont(new Font("Arial FB", Font.PLAIN, 60));
            return true;
        } else {
            return false;
        }
    }

    /**
     * @ returns true if it can add an X to the selected cell else its false.
     */
    public static boolean u() {
        if (d.getText().equals(""))

        {
            d.setText("X");
            d.setForeground(Color.CYAN);
            d.setFont(new Font("Arial FB", Font.PLAIN, 60));
            return true;
        } else {
            return false;
        }
    }

    /**
     * @ returns true if it can add an X to the selected cell else its false.
     */
    public static boolean v() {
        if (e.getText().equals(""))

        {
            e.setText("X");
            e.setForeground(Color.CYAN);
            e.setFont(new Font("Arial FB", Font.PLAIN, 60));
            return true;
        } else {
            return false;
        }
    }

    /**
     * @ returns true if it can add an X to the selected cell else its false.
     */
    public static boolean w() {
        if (f.getText().equals(""))

        {
            f.setText("X");
            f.setForeground(Color.CYAN);
            f.setFont(new Font("Arial FB", Font.PLAIN, 60));
            return true;
        } else {
            return false;
        }
    }

    /**
     * @ returns true if it can add an X to the selected cell else its false.
     */
    public static boolean x() {
        if (g.getText().equals(""))

        {
            g.setText("X");
            g.setForeground(Color.CYAN);
            g.setFont(new Font("Arial FB", Font.PLAIN, 60));
            return true;
        } else {
            return false;
        }

    }

    /**
     * @ returns true if it can add an X to the selected cell else its false.
     */
    public static boolean y() {
        if (h.getText().equals(""))

        {
            h.setText("X");
            h.setForeground(Color.CYAN);
            h.setFont(new Font("Arial FB", Font.PLAIN, 60));
            return true;
        } else {
            return false;
        }

    }

    /**
     * @ returns true if it can add an X to the selected cell else its false.
     */
    public static boolean z() {
        if (i.getText().equals(""))

        {
            i.setText("X");
            i.setForeground(Color.CYAN);
            i.setFont(new Font("Arial FB", Font.PLAIN, 60));
            return true;
        } else {
            return false;
        }
    }
}
