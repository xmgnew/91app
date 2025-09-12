package cum.game91.ui;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private static final Map<String, String> USERS = new HashMap<>();

    static {
        // default demo account
        USERS.put("admin", "123456");
    }

    public static synchronized boolean register(String username, String password) throws IllegalArgumentException {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("用户名不能为空。");
        }
        if (password == null || password.length() < 4) {
            throw new IllegalArgumentException("密码长度不能小于4位。");
        }
        if (USERS.containsKey(username)) {
            throw new IllegalArgumentException("用户名已存在。");
        }
        USERS.put(username, password);
        return true;
    }

    public static synchronized boolean authenticate(String username, String password) {
        if (username == null || password == null) return false;
        String stored = USERS.get(username);
        return stored != null && stored.equals(password);
    }
}
