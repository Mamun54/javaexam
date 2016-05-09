/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexam;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author Man
 */
public class Timer extends Thread{
    
    QuestionFrame qf;
    private int min,sec;
    private String sMin,sSec;

    public Timer(QuestionFrame qf) {
        
        this.qf=qf;
        
    }
    
    public void run()
    {
        min=79;
        sec =60;
        while(true)
        {
            try {
                sleep(1000);
            } catch (Exception e) {
            }
            sec-=1;
            if(sec<1)
            {
                min-=1;
                sec=60;
                
            }
            if(min<10)
            {
                sMin="0"+min;
                
            }
            else
            {
                sMin="" + min;
            }
             if(sec<10)
            {
                sSec="0"+sec;
                
            }
            else
            {
                sSec="" + sec;
            }
            
            qf.timer.setText("Timer: "+sMin+":"+sSec);
            if(min<1 && sec==1)
            {
                final JDialog jd =new JDialog(qf, true);
                JLabel lb1 =new JLabel("Time Up",JLabel.CENTER);
                JButton b1 = new JButton ("Ok end Test");
                b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        qf.next.setEnabled(false);
                        qf.previous.setEnabled(false);
                        qf.mark.setEnabled(false);
                        jd.dispose();
                   
                    }
                });
                Container con = jd.getContentPane();
                con.add(lb1,BorderLayout.NORTH);
                con.add(b1,BorderLayout.SOUTH);
                jd.setSize(150,100);
                jd.setVisible(true);
                break;
            }
        }
    }
 
    
}
