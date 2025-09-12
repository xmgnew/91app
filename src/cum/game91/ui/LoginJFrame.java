package cum.game91.ui;

import javax.swing.*;
import java.awt.*;

public class LoginJFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginJFrame(){
        initUI();
    }

    private void initUI() {
        this.setTitle("登陆91");
        this.setSize(400, 260);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));

        // Title
        JLabel title = new JLabel("登陆", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 18f));
        this.add(title, BorderLayout.NORTH);

        // Form
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(6, 8, 6, 8);
        gc.anchor = GridBagConstraints.WEST;

        gc.gridx = 0; gc.gridy = 0;
        form.add(new JLabel("用户名:"), gc);
        gc.gridx = 1;
        usernameField = new JTextField(16);
        form.add(usernameField, gc);

        gc.gridx = 0; gc.gridy = 1;
        form.add(new JLabel("密码:"), gc);
        gc.gridx = 1;
        passwordField = new JPasswordField(16);
        form.add(passwordField, gc);

        this.add(form, BorderLayout.CENTER);

        // Buttons
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton loginBtn = new JButton("登陆");
        JButton registerBtn = new JButton("注册");
        JButton resetBtn = new JButton("重置");
        buttons.add(resetBtn);
        buttons.add(registerBtn);
        buttons.add(loginBtn);
        this.add(buttons, BorderLayout.SOUTH);

        // Actions
        loginBtn.addActionListener(e -> doLogin());
        registerBtn.addActionListener(e -> new RegisterJFrame());
        resetBtn.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });

        // Enter key triggers login
        this.getRootPane().setDefaultButton(loginBtn);

        this.setVisible(true);
    }

    private void doLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入用户名。");
            return;
        }
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入密码。");
            return;
        }

        boolean ok = AuthService.authenticate(username, password);
        if (ok) {
            JOptionPane.showMessageDialog(this, "登陆成功，欢迎" + username + "登陆91!");
            new GameJFrame();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "无效的用户名或密码。");
        }
    }
}
