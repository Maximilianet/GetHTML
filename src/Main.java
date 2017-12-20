import java.awt.event.*;
import java.io.InputStream;
import java.net.*;
import javax.swing.*;
public class Main extends JFrame implements ActionListener{
    JTextField textField;
    JTextArea textArea;
    JButton jButton;
    JLabel jLabel;
    Main(){
        super("Просмотр кода страницы");
        jLabel=new JLabel("Введите URL:");
        jLabel.setBounds(50,50,250,20);

        textField=new JTextField("http://www.vk.ru");
        textField.setBounds(50,100,250,20);

        jButton=new JButton("Посмотреть код страницы");
        jButton.setBounds(50, 150,180,30);
        jButton.addActionListener(this);

        textArea=new JTextArea();
        JScrollPane sp=new JScrollPane(textArea);
        sp.setBounds(50,200,350,250);

        add(jLabel);add(textField);add(jButton);add(sp);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String s=textField.getText();
        if(s==null){}
        else{
            try{
                URL url=new URL(s);
                URLConnection uc=url.openConnection();

                InputStream is=uc.getInputStream();
                int i;
                StringBuilder sb=new StringBuilder();
                while((i=is.read())!=-1){
                    sb.append((char)i);
                }
                String source=sb.toString();
                textArea.setText(source);
            }catch(Exception ex){JOptionPane.showMessageDialog(this,"Exception: "+ex);}
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}