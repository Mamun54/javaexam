/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexam;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.time.Clock.system;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Man
 */
public class ExamResult extends JDialog {
    
    JLabel totQues,totAns,totWrong,per,grade;
    JButton jb;
    int correct;
    
    public ExamResult(final QuestionFrame fm)
    {
        totQues = new JLabel("Total Question");
        totAns= new JLabel("Correct Answer");
        totWrong= new JLabel("InCorrect Answer");
        per= new JLabel("Percentage of Marks");
        grade= new JLabel("Grade");
        jb =new JButton("OK");
        setTitle("Exam Result");
        setModal(true);
        
        for (int i = 0; i < fm.maxQue; i++) {
            
            StringBuffer s = new StringBuffer();
            
            for (int j = 0; j < 5; j++) {
                
                
                if(fm.ansOption[i][j] ==true)
                {
                   s.append(j+1+",");
                }
                
            }
            
            if(s.length()!=0)
            {
                s.deleteCharAt(s.length()-1);
            }
            
            if(fm.quesOption[i][6].equals(new String(s)))
            {
                correct+=1;
            }
            
        }
        
        Container content = getContentPane();
        JPanel con =new JPanel();
        con.setLayout(new GridLayout(5,2));
        con.add(totQues);
        con.add(new JLabel(""+ fm.maxQue ));
        con.add(totAns);
        con.add(new JLabel("" +correct ));
        con.add(totWrong);
        con.add(new JLabel((fm.maxQue - correct)+""));  
        con.add(per);
        int b=0;
        b=correct * 100/ fm.maxQue;
        
        con.add(new JLabel(b + "%"));
        con.add(grade);
        
        if(b<65)
        {
            con.add(new JLabel("Failed"));
        }
        else{
            con.add(new JLabel("Passed"));
        }
        
        content.add(con,BorderLayout.NORTH);
        jb.addActionListener(new ActionListener() {
            private Object system;
           
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        content.add(jb);
        setSize(300,200);
        setVisible(true);
         
    }
    
}
