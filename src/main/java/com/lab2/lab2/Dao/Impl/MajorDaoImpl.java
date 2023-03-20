package com.lab2.lab2.Dao.Impl;

import com.lab2.lab2.DB.DBUtil;
import com.lab2.lab2.Dao.MajorDao;
import com.lab2.lab2.Entity.Major;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MajorDaoImpl implements MajorDao {

    @Override
    public void add(Major major){
        DBUtil dbutil =new DBUtil();
        String mid = major.getMid();
        String mname = major.getMname();
        dbutil.executeUpdate("insert into major(mid,mname) values('"+mid+"','"+mname+"')");
        try {
            dbutil.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modify(Major major) {
        DBUtil dbutil =new DBUtil();
        String mid = major.getMid();
        String mname = major.getMname();
        dbutil.executeUpdate("update major set mname = '" + mname +"''where mid = '"+ mid + "'");
        try {
            dbutil.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String mid) {
        DBUtil dbutil =new DBUtil();
        dbutil.executeUpdate("delete from major where mid = '"+ mid + "'");
        try {
            dbutil.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Major getByMid(String mid) {
        DBUtil dbutil =new DBUtil();
        ResultSet rs = dbutil.executeQuery("select * from major where mid"+mid+"'");
        String mname;
        try {
            if(rs.next()){
                mname= rs.getString("mname");
                return new Major(mid,mname);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                dbutil.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }

    @Override
    public List<Major> getAll(String sql) {
        DBUtil dbutil =new DBUtil();
        ResultSet rs = dbutil.executeQuery(sql);
        List<Major> majorList=new ArrayList<>();
        String mid,mname;
        try {
            while (rs.next()){
                mid = rs.getString("mid");
                mname= rs.getString("mname");
                majorList.add(new Major(mname,mid));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                dbutil.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return majorList;
        }
    }
}
