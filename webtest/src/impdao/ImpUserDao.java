package impdao;

import java.sql.*;

import dao.UserDao;
import entity.User;
import util.Conn;

public class ImpUserDao implements UserDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public boolean findByUser(User u) {
        // TODO Auto-genereturn false;
        con = Conn.getCon();
        boolean flag = false;
        String sql = "select * from users where username=? and password=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getPwd());
            rs = ps.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return flag;
    }

    public boolean createUser(User u) {
        con = Conn.getCon();

        String sql = "INSERT INTO users (username,password) VALUES (?,?);";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getPwd());
            ps.execute();

		} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return true;
    }

    public boolean deleteUser(int id) {
        con = Conn.getCon();

        String sql = "delete from users where id = ? ;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return true;
    }

    public boolean updateUser(User u,int id) {
        con = Conn.getCon();

        String sql = "UPDATE users SET username = ? ,password = ? WHERE id = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getPwd());
            ps.setInt(3, id);
            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return true;
    }

}
