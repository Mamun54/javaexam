
package javaexam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Man
 */
public class Review  extends JDialog{
    
    QuestionFrame qf =new QuestionFrame();
    private JButton[] qButton =new JButton[10];
    
    public Review(final QuestionFrame qf)
    {
        setTitle("Review");
        setModal(true);
        this.qf=qf;
        Container con =getContentPane();
       JPanel pane =new JPanel();
       
       if(this.qf.maxQue<2)
       {
           pane.setLayout(new GridLayout(1,2));
       }
       if(this.qf.maxQue<4)
       {
           pane.setLayout(new GridLayout(2,2));
       }
       if(this.qf.maxQue<6)
       {
           pane.setLayout(new GridLayout(3,2));
       }
       if(this.qf.maxQue<8)
       {
           pane.setLayout(new GridLayout(4,2));
       }
       if(this.qf.maxQue<10)
       {
           pane.setLayout(new GridLayout(5,2));
       }
       
        int j=0;
        for (int i = 0; i < this.qf.maxQue; i++) {
            
            j=i+1;
            qButton[i] =new JButton("Que No:" + j +"/10");
            
            if(this.qf.ansOption[i][5]==true)
            {
                qButton[i].setBackground(Color.red);
            }
            qButton [i].addActionListener(new ActionList());
            pane.add(qButton[i]);
        }
        
        JButton ok =new JButton("Ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dispose();
   
            }
        });
        con.add(pane,BorderLayout.CENTER);
        con.add(ok,BorderLayout.SOUTH);
       setSize(600,400);
       setVisible(true);
    }
    
    class ActionList implements ActionListener{
        
        
        int i;

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String s =e.getActionCommand();
            if(s.length()==11)
            {
                s=s.substring(7,8);
            }
            else
            {
                s=s.substring(7,8);
            }
            i= new Integer(s).intValue();
            qf.quesNo= i;
            qf.makeQues(i);
            
   
        }
    }
    
}
