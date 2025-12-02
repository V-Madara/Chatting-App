package Code;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.*;

public class Server extends JFrame implements ActionListener, KeyListener {

    JTextField text;
    JButton send;
    JPanel a1;
    Box vertical = Box.createVerticalBox();

    Server() {

        // Top Green Bar
        setLayout(null);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        add(p1);

        // Creating Back Button and Making it Work
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 25, 25);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.exit(0);
            }
        });

        // Giving Profile Image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        Image i5 = i4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(45, 15, 40, 40);
        p1.add(profile);

        // Giving Video Image
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300, 20, 30, 30);
        p1.add(video);

        // Giving Phone Image
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(360, 20, 30, 30);
        p1.add(phone);

        // Giving Three Dots Image
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(15, 30, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel dots = new JLabel(i15);
        dots.setBounds(420, 20, 15, 30);
        p1.add(dots);

        // Writing the Name of the User:
        JLabel name = new JLabel("Yuna");
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(name);

        // Writing the Status of the User:
        JLabel status = new JLabel("Active Now");
        status.setBounds(110, 35, 100, 14);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(status);

        // Creating New Panel For Text Area
        a1 = new JPanel();
        a1.setBounds(5, 75, 440, 570);
        add(a1);

        // Creating TextField
        text = new JTextField();
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        text.addKeyListener(this);
        add(text);

        // Adding Send Button
        send = new JButton("Send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        send.addActionListener(this);
        add(send);

        // Setting the Frame
        setSize(450, 700);
        setLocation(200, 50);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void keyPressed(KeyEvent ae) {
        int keyCode = ae.getKeyCode();
        KeyEvent.getKeyText(keyCode);

        // Example: Close window with ESC
        if (keyCode == KeyEvent.VK_ENTER) {
            String out = text.getText();
            JPanel p2 = formateLabel(out);
            a1.setLayout(new BorderLayout());
            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));

            a1.add(vertical, BorderLayout.PAGE_START);

            text.setText("");
            repaint();
            invalidate();
            validate();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No action needed for keyReleased in this context
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No action needed for keyTyped in this context
    }

    // Must be overrided after implementing ActionListener
    @Override
    public void actionPerformed(ActionEvent ae) {
        String out = text.getText();
        JPanel p2 = formateLabel(out);
        a1.setLayout(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));

        a1.add(vertical, BorderLayout.PAGE_START);

        text.setText("");
        repaint();
        invalidate();
        validate();
    }

    public static JPanel formateLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 20));
        panel.add(output);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));

        panel.add(time);

        return panel;
    }

    public static void main(String[] args) {
        new Server();
    }
}
