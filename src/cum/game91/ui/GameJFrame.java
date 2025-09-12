package cum.game91.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameJFrame extends JFrame {

    private JLabel imgLabel;
    private JButton prevButton, nextButton;
    private int currentIndex = 0;

    private final String[] images = {
            "/img/1.jpg",
            "/img/2.jpg",
            "/img/3.jpg",
            "/img/4.jpg",
            "/img/5.jpg",
            "/img/6.jpg",
            "/img/7.jpg",
            "/img/8.jpg",
            "/img/9.jpg",
            "/img/10.jpg",
            "/img/11.jpg",
            "/img/12.jpg",
            "/img/13.jpg",
            "/img/14.jpg",
            "/img/15.jpg",
            "/img/91.jpg"
    };

    public GameJFrame() {
        // init window
        initJFrame();

        // init menubar
        initJMenuBar();

        // init img
        initImg();

        //
        this.setVisible(true);
    }

    private void initImg() {
        imgLabel = new JLabel();
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        updateImage();
        add(imgLabel, BorderLayout.CENTER);

        // button panel
        JPanel buttonPanel = new JPanel();
        prevButton = new JButton("<<<");
        nextButton = new JButton(">>>");

        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // button actions
        prevButton.addActionListener(e -> showImage((currentIndex - 1 + images.length) % images.length));
        nextButton.addActionListener(e -> showImage((currentIndex + 1) % images.length));
    }

    private void showImage(int idx) {
        currentIndex = idx;
        java.net.URL url = GameJFrame.class.getResource(images[idx]);
        if (url == null) {
            // helpful message if a resource is missing
            imgLabel.setText("Missing resource: " + images[idx]);
            return;
        }
        ImageIcon icon = new ImageIcon(url);
        imgLabel.setIcon(icon);
        imgLabel.setText(null);
    }

    private void updateImage() {
        ImageIcon icon = new ImageIcon(images[currentIndex]);
        imgLabel.setIcon(icon);
    }

    private void showPreviousImage() {
        if (currentIndex > 0) {
            currentIndex--;
            updateImage();
        } else {
            JOptionPane.showMessageDialog(this, "已经到顶了喵～");
        }
    }

    private void showNextImage() {
        if (currentIndex < images.length - 1) {
            currentIndex++;
            updateImage();
        } else {
            JOptionPane.showMessageDialog(this, "已经到底了喵～");
        }
    }

    private void initJMenuBar() {
        // initialize menu
        JMenuBar menuBar = new JMenuBar();

        // create options
        JMenu functionMenu = new JMenu("功能");
        JMenu topupMenu = new JMenu("充值");
        JMenu aboutMenu = new JMenu("关于我们");
        JMenu helpMenu = new JMenu("帮助");

        // init functionMenu
        JMenuItem refreshMenuItem = new JMenuItem("刷新");
        refreshMenuItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "刷新成功！");
        });
        JMenuItem logoutMenuItem = new JMenuItem("登出");
        logoutMenuItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "我不会写怎么登出");
        });
        JMenuItem exitMenuItem = new JMenuItem("退出91");
        exitMenuItem.addActionListener(e -> {
            System.exit(0);
        });
        functionMenu.add(refreshMenuItem);
        functionMenu.add(logoutMenuItem);
        functionMenu.add(exitMenuItem);

        // init topupMenu
        JMenuItem vipMenuItem = new JMenuItem("91vip");
        vipMenuItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "错误(91)，请前往自定义充值");
        });
        JMenuItem coinMenuItem = new JMenuItem("91币");
        coinMenuItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "错误(78)，请前往自定义充值");
        });
        JMenuItem customMenuItem = new JMenuItem("自定义充值");
        customMenuItem.addActionListener(e -> {
            ImageIcon icon = new ImageIcon("resources/img/91.jpg");
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(427, 640, Image.SCALE_SMOOTH);
            ImageIcon smallIcon = new ImageIcon(newImg);
            JOptionPane.showMessageDialog(
                    this,                       // parent component (your JFrame)
                    "自定义充值",        // message text
                    "限时特惠：一次性充值¥9999即可获得永久91vip！",             // dialog title
                    JOptionPane.INFORMATION_MESSAGE,
                    smallIcon                        // the icon to show
            );
        });
        topupMenu.add(vipMenuItem);
        topupMenu.add(coinMenuItem);
        topupMenu.add(customMenuItem);

        // init aboutMenu
        JMenuItem introMenuItem = new JMenuItem("创始人：爆炸鱼");
        introMenuItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼\n爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼\n爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼\n爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼\n爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼\n爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼\n爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼\n爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼\n爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼\n爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼爆炸鱼牛逼\n");
        });
        JMenuItem nineoneMenuItem = new JMenuItem("关于91");
        nineoneMenuItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "当前版本：v1" +
                    ".0（试用版）。欢迎来到91大平台。想解锁终极完整超级豪华高清无损DLC版请充值91vip。");
        });
        JMenuItem adMenuItem = new JMenuItem("赞助商：广告位招租");
        adMenuItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "广告位招租");
        });
        aboutMenu.add(introMenuItem);
        aboutMenu.add(nineoneMenuItem);
        aboutMenu.add(adMenuItem);

        // init helpMenu
        JMenuItem daohelpMenuItem = new JMenuItem("帮我导");
        daohelpMenuItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "[充值91vip后解锁该内容]");
        });
        JMenuItem daoselfMenuItem = new JMenuItem("怎么导");
        daoselfMenuItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "[充值91vip后解锁该内容]");
        });
        JMenuItem guideMenuItem = new JMenuItem("91帮助文档");
        guideMenuItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "[充值91vip后解锁该内容]");
        });
        JMenuItem recoverMenuItem = new JMenuItem("导后恢复指南");
        recoverMenuItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "[充值91vip后解锁该内容]");
        });
        helpMenu.add(daohelpMenuItem);
        helpMenu.add(daoselfMenuItem);
        helpMenu.add(guideMenuItem);
        helpMenu.add(recoverMenuItem);

        // init final menu
        menuBar.add(functionMenu);
        menuBar.add(topupMenu);
        menuBar.add(aboutMenu);
        menuBar.add(helpMenu);

        // set menu bar
        this.setJMenuBar(menuBar);
    }

    private void initJFrame() {
        // set width and height
        this.setSize(603, 680);
        // window title
        this.setTitle("91");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
