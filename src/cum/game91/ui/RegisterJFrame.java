package cum.game91.ui;

import javax.swing.*;
import java.awt.*;

public class RegisterJFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmField;

    public RegisterJFrame() {
        initUI();
    }

    private void initUI() {
        this.setTitle("注册91");
        this.setSize(420, 320);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("创建账号", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 18f));
        this.add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(6, 8, 6, 8);
        gc.anchor = GridBagConstraints.WEST;

        gc.gridx = 0; gc.gridy = 0;
        form.add(new JLabel("用户名:"), gc);
        gc.gridx = 1;
        usernameField = new JTextField(18);
        form.add(usernameField, gc);

        gc.gridx = 0; gc.gridy = 1;
        form.add(new JLabel("密码:"), gc);
        gc.gridx = 1;
        passwordField = new JPasswordField(18);
        form.add(passwordField, gc);

        gc.gridx = 0; gc.gridy = 2;
        form.add(new JLabel("确认密码:"), gc);
        gc.gridx = 1;
        confirmField = new JPasswordField(18);
        form.add(confirmField, gc);

        this.add(form, BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton cancelBtn = new JButton("取消");
        JButton registerBtn = new JButton("注册");
        buttons.add(cancelBtn);
        buttons.add(registerBtn);
        this.add(buttons, BorderLayout.SOUTH);

        cancelBtn.addActionListener(e -> this.dispose());
        registerBtn.addActionListener(e -> doRegister());

        this.setVisible(true);
    }

    private void doRegister() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirm  = new String(confirmField.getPassword());

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入用户名。");
            return;
        }
        if (password.length() < 4) {
            JOptionPane.showMessageDialog(this, "密码长度不能小于4位，");
            return;
        }
        if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "密码不匹配。");
            return;
        }

        try {
            boolean ok = AuthService.register(username, password);
            if (ok) {
                JOptionPane.showMessageDialog(this, "注册成功，请登录。");
                this.dispose();
                new LoginJFrame();
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
