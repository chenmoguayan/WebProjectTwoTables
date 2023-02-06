package org.qingqiao.dao;

import org.qingqiao.bean.Animal;
import org.qingqiao.bean.City;
import org.qingqiao.bean.Type;
import org.qingqiao.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author hj
 * @data 2023/2/1 15:59
 */
public class AnimalDao {
    Connection conn = JDBCUtil.getConn();

    public ArrayList<Animal> queryAll() {
        ArrayList<Animal> list = new ArrayList<>();
        String sql = "select a.*,t.name tname from animal a join type t on a.tid = t.tid";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Type type = new Type(rs.getInt(5),rs.getString(6));
                list.add(new Animal(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),type));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int insert(Animal animal) {
        int i = 0;
        String sql = "insert into animal values(null,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, animal.getName());
            ps.setInt(2,animal.getAge());
            ps.setString(3, animal.getSex());
            ps.setInt(4, animal.getType().getTid());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    public ArrayList<Type> getTypr(){
        ArrayList<Type> list = new ArrayList<>();
        String sql = "select * from type";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Type(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Animal queryById(int id) {
        Animal animal = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from animal where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Type type = new Type(rs.getInt(5),"");
                animal = new Animal(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),type);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animal;
    }

    public int update(int id, Animal animal) {
        int i = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update animal set name = ?,age = ?,sex = ?,tid = ? where id = ?");
            ps.setString(1, animal.getName());
            ps.setInt(2,animal.getAge());
            ps.setString(3, animal.getSex());
            ps.setInt(4, animal.getType().getTid());
            ps.setInt(5, id);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
    public int delete(int id){
        int i = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("delete from animal where id = ?");
            ps.setInt(1, id);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    public ArrayList<City> getCity(String pid) {
        ArrayList<City> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select id,name,pid from city where pid = ?");
            ps.setString(1, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new City(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
