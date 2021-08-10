import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App extends JFrame implements ActionListener, MouseListener {

    JTextField ans;
    JButton[] num = new JButton[10];
    JButton[] fun = new JButton[9];
    JButton add, sub, mul, div;
    JButton dec, eq, del, clr, neg;
    JPanel p = new JPanel(), main = new JPanel();

    Font f = new Font("Cambria Math", Font.BOLD, 30);
    double n1 = 0, n2, res;
    char op;

    App() {
        this.setDefaultCloseOperation(3);
        this.setTitle("Calculator");
        this.setSize(420, 550);
        this.getContentPane().setBackground(Color.blue);
        this.setLayout(null);

        ans = new JTextField();
        ans.setBounds(50, 25, 300, 50);
        ans.setFont(f);
        ans.setBackground(Color.DARK_GRAY);
        ans.setForeground(Color.ORANGE);
        ans.setEditable(false);
        this.add(ans);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        eq = new JButton("=");
        del = new JButton("DEL");
        clr = new JButton("CLR");
        neg = new JButton(String.format("%c", 177));

        fun[0] = add;
        fun[1] = sub;
        fun[2] = mul;
        fun[3] = div;
        fun[4] = dec;
        fun[5] = eq;
        fun[6] = del;
        fun[7] = clr;
        fun[8] = neg;

        for (int i = 0; i < 9; i++) {
            fun[i].addMouseListener(this);
            fun[i].addActionListener(this);
            fun[i].setFont(f);
            fun[i].setBorder(BorderFactory.createEmptyBorder());
            fun[i].setFocusable(false);
            fun[i].setBackground(Color.white);
        }

        for (int i = 0; i < 10; i++) {
            num[i] = new JButton(String.valueOf(i));
            num[i].addMouseListener(this);
            num[i].addActionListener(this);
            num[i].setFont(f);
            num[i].setBorder(BorderFactory.createEmptyBorder());
            num[i].setFocusable(false);
            num[i].setBackground(Color.white);
        }

        neg.setBounds(50, 430, 100, 50);
        del.setBounds(150, 430, 100, 50);
        clr.setBounds(250, 430, 100, 50);
        this.add(del);
        this.add(clr);
        this.add(neg);

        p.setBounds(50, 100, 300, 300);
        p.setBackground(Color.blue);
        p.setLayout(new GridLayout(4, 4));
        this.add(p);

        p.add(num[1]);
        p.add(num[2]);
        p.add(num[3]);
        p.add(add);
        p.add(num[4]);
        p.add(num[5]);
        p.add(num[6]);
        p.add(sub);
        p.add(num[7]);
        p.add(num[8]);
        p.add(num[9]);
        p.add(mul);
        p.add(dec);
        p.add(num[0]);
        p.add(eq);
        p.add(div);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == num[i]) {
                ans.setText(ans.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == dec) {
            ans.setText(ans.getText().concat(String.valueOf(".")));
        }

        if (e.getSource() == add) {
            n1 = Double.parseDouble(ans.getText());
            op = '+';
            ans.setText("");
        }

        if (e.getSource() == sub) {
            n1 = Double.parseDouble(ans.getText());
            op = '-';
            ans.setText("");
        }

        if (e.getSource() == mul) {
            n1 = Double.parseDouble(ans.getText());
            op = '*';
            ans.setText("");
        }

        if (e.getSource() == div) {
            n1 = Double.parseDouble(ans.getText());
            op = '/';
            ans.setText("");
        }

        if (e.getSource() == eq) {
            n2 = Double.parseDouble(ans.getText());

            switch (op) {
                case '+':
                    res = n1 + n2;
                    break;
                case '-':
                    res = n1 - n2;
                    break;
                case '*':
                    res = n1 * n2;
                    break;
                case '/':
                    res = n1 / n2;
                    break;
            }
            ans.setText(String.valueOf(res));
            n1 = res;
        }

        if (e.getSource() == del) {
            String string = ans.getText();
            ans.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                ans.setText(ans.getText() + string.charAt(i));
            }
        }

        if (e.getSource() == clr) {
            ans.setText("");
        }

        if (e.getSource() == neg) {
            Double x = Double.parseDouble(ans.getText());
            x *= -1;
            ans.setText(String.valueOf(x));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i < num.length; i++) {
            if (e.getSource() == num[i]) {
                num[i].setBackground(Color.LIGHT_GRAY);
            }
        }

        for (int i = 0; i < fun.length; i++) {
            if (e.getSource() == fun[i]) {
                fun[i].setBackground(Color.lightGray);
            }
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < fun.length; i++) {
            if (e.getSource() == fun[i]) {
                fun[i].setBackground(Color.white);
            }
        }
        
        for (int i = 0; i < num.length; i++){
            if (e.getSource() == num[i]) {
                num[i].setBackground(Color.white);
            }
        }
    }
}