import javax.swing.*;

public class MyFrame extends JFrame {
  public MyFrame(){
    super(); 
    setBounds(200,100,520,200);
  }
  public MyFrame(String titolo){
    super(titolo);
    setBounds(700,300,460,260);
  }
}
