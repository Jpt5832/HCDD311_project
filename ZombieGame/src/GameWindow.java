import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class GameWindow extends JFrame {

      //JFrame frame = new JFrame();
	/** Class Objects **/
	public static Player ply = new Player();
	public static Weapon wpn;
	public static Item itm;
	public static ImageIcon icon;
	public static JPanel p4;
	
	/** Objects within the Game Window Class **/	
	Font borderFonts = new Font("MV Boli", Font.PLAIN, 16);
	Font healthFont = new Font("Webdings", Font.BOLD, 14);
	
	public static JButton weapon, attack, item, moveForward, moveBackward;

      //@SuppressWarnings("deprecation")
	public GameWindow() {
    	  
	      final int FRAME_WIDTH = 650;
	      final int FRAME_HEIGHT = 600;
	            
	      //frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	      //frame.setTitle("An empty frame");
	      //frame.setVisible(true);
	      //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      Container c = getContentPane();
	      
	      /******** Panel 1: GAME LOGO ********/
	      JPanel p1 = new JPanel();
	      String logoLocation = "/Users/jaysontroxel/IdeaProjects1/ZombieGame/src/images/Game Window class resources and images/zombie_text2.png";
	      icon = new ImageIcon(new ImageIcon(logoLocation).getImage().getScaledInstance(550, 100, Image.SCALE_DEFAULT));      
	      JLabel lblLogo = new JLabel(icon);
	      lblLogo.setBackground(Color.BLACK);
	      lblLogo.setOpaque(true);
	      p1.add(lblLogo);
	      /*******************************************************************/
	      
	      /******** Panel 2: PLAYER MOVEMENT BUTTONS ********/
	      JPanel p2 = new JPanel();
	      //p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
	      icon = new ImageIcon("/Users/jaysontroxel/IdeaProjects1/ZombieGame/src/images/Game Window class resources and images/upArrowSmall.png");
	      p2.add(new JButton("", icon));
	      icon = new ImageIcon("/Users/jaysontroxel/IdeaProjects1/ZombieGame/src/images/Game Window class resources and images/downArrowSmall.png");
	      p2.add(new JButton("", icon));
	      p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
	      //p2.setAlignmentX(Component.CENTER_ALIGNMENT);
	      //p2.setAlignmentY(Component.CENTER_ALIGNMENT);
	      //p2.setBorder(BorderFactory.createTitledBorder("MOVEMENT"));
	      p2.setBorder(BorderFactory.createTitledBorder(null, "MOVEMENT", TitledBorder.CENTER, TitledBorder.TOP, borderFonts, Color.black));
	      /*******************************************************************/
	      
	      /******** Panel 3: GAME OUTPUT ********/
	      JPanel p3 = new JPanel();
	      
	      String Location = "C:/Users/jvo101//eclipse-workspace/ZombieGame/src/resources/openingscene.gif";
	      
	      
	      icon = new ImageIcon(new ImageIcon(Location).getImage().getScaledInstance(345, 395, Image.SCALE_DEFAULT));      
	                  
	      
	      JLabel lbl3 = new JLabel(icon);
	      
	      //JLabel lbl3 = new JLabel("Some Text");
	      lbl3.setPreferredSize(new Dimension(350, 400));
	      lbl3.setBackground(Color.WHITE);
	      //lbl3.setBackground(new Color(100, 20, 70));
	      //lbl3.setForeground(Color.???);
	      lbl3.setOpaque(true);
	      //label.setVerticalAlignment(JLabel.TOP);
	      lbl3.setFont(new Font("Verdana", Font.PLAIN, 18));
	      //p3.setAlignmentX(Component.CENTER_ALIGNMENT);
	      p3.add(lbl3);
	      // ------------------------------------------------
	      
	      Location = "C:/Users/jvo101//eclipse-workspace/ZombieGame/src/resources/openingnarrative.gif";
	      icon = new ImageIcon(new ImageIcon(Location).getImage().getScaledInstance(345, 395, Image.SCALE_DEFAULT));    
	      //lbl3 = new JLabel(icon);
	      lbl3.setIcon(icon);
	      
	      /*******************************************************************/
	      
	      /******** Panel 4: THE PLAYER'S STATUS ********/
	      //JPanel p4 = new JPanel();
	      JLabel lblPlayerName = new JLabel(ply.playerName);
	      lblPlayerName.setFont(new Font("Bahnschrift", Font.BOLD, 18));
	      lblPlayerName.setAlignmentX(CENTER_ALIGNMENT);
	      //lblPlayerName.setAlignmentY(BOTTOM_ALIGNMENT);
	      
	      JLabel lblPlayerHealth = new JLabel("Health: " + ply.updatePH());
	      lblPlayerHealth.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	      lblPlayerHealth.setAlignmentX(CENTER_ALIGNMENT);
	      //lblPlayerHealth.setAlignmentY(CENTER_ALIGNMENT);
	      
	      JLabel lblPlayerLives = new JLabel("Lives: " + ply.lives);
	      lblPlayerLives.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	      lblPlayerLives.setAlignmentX(CENTER_ALIGNMENT);
	      //lblPlayerLives.setAlignmentY(CENTER_ALIGNMENT);
	      
	      JLabel lblPlayerScore = new JLabel("Score: " + ply.score);
	      lblPlayerScore.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	      lblPlayerScore.setAlignmentX(CENTER_ALIGNMENT);
	      //lblPlayerScore.setAlignmentY(CENTER_ALIGNMENT);
	      
	      JLabel lblPlayerExp = new JLabel("Exp: " + ply.exp);
	      lblPlayerExp.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	      lblPlayerExp.setAlignmentX(CENTER_ALIGNMENT);
	      //lblPlayerExp.setAlignmentY(CENTER_ALIGNMENT);
	      
	      String str = "<html><br><br><div style='text-align: center;'><b>Current<br>Weapon:</b><br>";
	      JLabel lblCurrWpn = new JLabel(str + wpn.weaponName + "</div></html>", SwingConstants.CENTER);
	      //JLabel lblCurrWpn1 = new JLabel("Weapon:" + wpn.weaponName);
	      lblCurrWpn.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
	      lblCurrWpn.setAlignmentX(CENTER_ALIGNMENT);

	      
	      p4 = new JPanel();
	     
	      p4.add(lblPlayerName);
	      p4.add(lblPlayerHealth);
	      p4.add(lblPlayerLives);
	      p4.add(lblPlayerScore);
	      p4.add(lblPlayerExp);
	      p4.add(lblCurrWpn);
	      
	      p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
	      p4.setPreferredSize(new Dimension(150, 200));
	      p4.setAlignmentY(Component.CENTER_ALIGNMENT);
	      //p4.setAlignmentY(CENTER_ALIGNMENT);
	      //p4.setBorder(BorderFactory.createTitledBorder("PLAYER STATUS")); //with just String argument
	      p4.setBorder(BorderFactory.createTitledBorder(null, "PLAYER STATUS", TitledBorder.CENTER, TitledBorder.TOP, borderFonts, Color.black));
	      //p4.setBorder(BorderFactory.createLineBorder(Color.blue));
	      /*******************************************************************/
	      
	      /******** Panel 5: GAME ACTIONS ********/
	      JPanel p5 = new JPanel();
	      //p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));
	      
	      //p5.add(new JButton("ATTACK"), JButton.CENTER);
	      logoLocation = "/Users/jaysontroxel/IdeaProjects1/ZombieGame/src/images/Game Window class resources and images/btnAttack_image.gif";
	      icon = new ImageIcon(new ImageIcon(logoLocation).getImage().getScaledInstance(170, 80, Image.SCALE_DEFAULT));
	      attack = new JButton(icon);
	      p5.add(attack, JButton.CENTER);
	      //p5.add(new JButton("", icon), JButton.CENTER);
	      
	      attack.addActionListener(new java.awt.event.ActionListener() {
	    	  @Override
	          public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		  String logoLocation = "/Users/jaysontroxel/IdeaProjects1/ZombieGame/src/images/Game Window class resources and images/btnAttack_image.gif";
	    	      icon = new ImageIcon(new ImageIcon(logoLocation).getImage().getScaledInstance(170, 80, Image.SCALE_DEFAULT));
	    	      attack.setIcon(icon);
	    		 
	    	  }
	      });
	      
	      
	      item = new JButton("USE ITEM");
	      p5.add(item, JButton.CENTER);
	      
	      item.addActionListener(new java.awt.event.ActionListener() {
	    	  @Override
	          public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		  
	    		  itm = new Item();
	    		      		  
	    		  //String logoLocation = "C:/Users/jvo101//eclipse-workspace/ZombieGame/src/resources/btnAttack_image.gif";
	    	      //icon = new ImageIcon(new ImageIcon(logoLocation).getImage().getScaledInstance(170, 80, Image.SCALE_DEFAULT));
	    	      //attack.setIcon(icon);
	    		  
	    	  }
	      });
	      
	      
	      
	      weapon = new JButton("--[=====>");
	      p5.add(weapon, JButton.CENTER);
	      
	      weapon.addActionListener(new java.awt.event.ActionListener() {
	    	  @Override
	          public void actionPerformed(java.awt.event.ActionEvent evt) {
	    		  icon = new ImageIcon("/Users/jaysontroxel/IdeaProjects1/ZombieGame/src/images/Game Window class resources and images/weapons_select.png");
	    		  String weaponSelection = (String) JOptionPane.showInputDialog(c, icon, "SELECT A WEAPON", JOptionPane.QUESTION_MESSAGE, null, null, "");
	              System.out.println("\n ******** selected weapon is " + weaponSelection + "\n");
	              wpn.weaponSelect(Integer.parseInt(weaponSelection));
	              lblCurrWpn.setHorizontalAlignment(SwingConstants.CENTER);
	              lblCurrWpn.setVerticalAlignment(SwingConstants.CENTER);
	              lblCurrWpn.setText(str + wpn.weaponName + "</html>");
	              
	    	  }
	      });
	      
	      p5.setAlignmentX(Component.CENTER_ALIGNMENT);
	      p5.setBorder(BorderFactory.createTitledBorder(null,  "* * * ACTIONS * * *", TitledBorder.CENTER, TitledBorder.TOP, borderFonts));
	      
	      //p5.setComponentPopupMenu(null)
	      /*******************************************************************/
	      
	      
	      c.setLayout(new BorderLayout());
	      c.add(p1, BorderLayout.NORTH);
	      c.add(p2, BorderLayout.WEST);
	      c.add(p3, BorderLayout.CENTER);
	      c.add(p4, BorderLayout.EAST);
	      //p4.setAlignmentY(CENTER_ALIGNMENT);
	      c.add(p5, BorderLayout.SOUTH);
	      
	 
	      //show();
	      pack();
	      
	      setSize(FRAME_WIDTH, FRAME_HEIGHT);
	      setTitle("Z O M B I E  G A M E");
	      setVisible(true);	      
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
	
	public static void WindowUpdate() {
		//private g = GameWindow();
		//this.dispose();
		//this.dispose();
		//GameWindow();
	}
	
	/** --- MAIN METHOD --- **/
    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread (EDT)
        javax.swing.SwingUtilities.invokeLater(() -> {
            new GameWindow();
        });
    }
	
}

