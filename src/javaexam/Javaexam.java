package javaexam;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Javaexam {
    
    static QuestionFrame qf;

    
    public static void main(String[] args) {
       
        qf = new QuestionFrame();
        qf.setSize(600,500);
       
        Dimension screendim =Toolkit.getDefaultToolkit().getScreenSize();
         Rectangle winDim = qf.getBounds();
        qf.setLocation((int)(screendim.getWidth()-winDim.width)/2,
                (int)(screendim.getHeight()-winDim.height)/2);
        qf.setVisible(true);
        qf.setResizable(false);
        
        qf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                final JDialog jd = new JDialog();
                jd.setModal(true);
                jd.setTitle("Exam System");
                JLabel msg=new JLabel("Do you want to exit?",JLabel.CENTER);
                
                final JButton b1 = new JButton("Ok");
                final JButton b2 = new JButton("Cancel");
                b1.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                      
                   System.exit(0);
                    
                    }
                    
                    
                });
                 b2.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                  // System.exit(0);
                    jd.hide();
                    }
                    
                    
                });
                 
                 JPanel p= new JPanel();
                 p.add(b1);
                 p.add(b2);
                 Container con = jd.getContentPane();
                 con.add(msg,BorderLayout.NORTH);
                 con.add(p,BorderLayout.SOUTH);
                 
                 jd.setSize(200,100);
                 
                   
        Dimension screendim =Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle winDim = jd.getBounds();
        jd.setLocation((int)(screendim.getWidth()-winDim.width)/2,
                (int)(screendim.getHeight()-winDim.height)/2);
        
        jd.show();
            }
          
            
});
    }
    
}
