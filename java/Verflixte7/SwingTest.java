import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingTest {
  private JFrame fenster;
  private JLabel text;
  private JPanel panel;

  public SwingTest() {
    fenster = new JFrame("Verflixte 7");
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenster.setSize(800, 600);

    panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    text = new JLabel("Spiele das Spiel Verflixte 7");
    text.setHorizontalAlignment(JLabel.CENTER);

    panel.add(text);
    fenster.add(panel);
  }

  public void show() {
    fenster.setVisible(true);
  }

  public static void main(String[] args) {
    SwingTest fenster = new SwingTest();
    fenster.show();
  }
}
