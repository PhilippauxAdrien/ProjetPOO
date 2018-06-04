package dao;

import beans.FeeBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.Status;

/**
 *
 * @author adrien
 */
public class FeeDao {

    public static int save(FeeBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("insert into fee(amount,date,iduser,status) values(?,?,?,?)");
		ps.setDouble(1, bean.getAmount());
		ps.setDate(2,bean.getDate());
		ps.setInt(3,bean.getIduser());
		ps.setString(4,bean.getStatus());;
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){
            System.out.println(ex);
        }
	return status;
}

public static int update(FeeBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("update fee set amount=?,date=?,iduser=?,status=? where id=?");
		ps.setDouble(1,bean.getAmount());
		ps.setDate(2,bean.getDate());
		ps.setInt(3,bean.getIduser());
		ps.setString(4,bean.getStatus());
		ps.setInt(5,bean.getId());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){
            System.out.println(ex);
        }
	return status;
}	

public static int updateStatus(int id, String status){
	int st=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("update fee set status=? where id=?");
		ps.setString(1,status);
		ps.setInt(2,id);
		st=ps.executeUpdate();
		con.close();
	}catch(Exception ex){
            System.out.println(ex);
        }
	return st;
}

    public static int delete(int id){
            int status=0;
            try{
                    Connection con=DB.getCon();
                    PreparedStatement ps=con.prepareStatement("delete from fee where id=?");
                    ps.setInt(1,id);
                    status=ps.executeUpdate();
                    con.close();
            }catch(Exception ex){
                System.out.println(ex);
            }
            return status;
    }

    public static List<FeeBean> getAllDue(){
            List<FeeBean> list=new ArrayList<FeeBean>();
            try{
                    Connection con=DB.getCon();
                    PreparedStatement ps=con.prepareStatement("select * from fee where status=?");
                    ps.setString(1, Status.SUBMITTED.getValue());
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                            FeeBean bean=new FeeBean();
                            bean.setId(rs.getInt(1));
                            bean.setAmount(rs.getDouble(2));
                            bean.setDate(rs.getDate(3));
                            bean.setIduser(rs.getInt(4));
                            bean.setStatus(rs.getString(5));
                            list.add(bean);
                    }
                    con.close();
            }catch(Exception ex){
                System.out.println(ex);
            }

            return list;
    }
    
    public static List<FeeBean> getAll(){
            List<FeeBean> list=new ArrayList<FeeBean>();
            try{
                    Connection con=DB.getCon();
                    PreparedStatement ps=con.prepareStatement("select * from fee");
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                            FeeBean bean=new FeeBean();
                            bean.setId(rs.getInt(1));
                            bean.setAmount(rs.getDouble(2));
                            bean.setDate(rs.getDate(3));
                            bean.setIduser(rs.getInt(4));
                            bean.setStatus(rs.getString(5));
                            list.add(bean);
                    }
                    con.close();
            }catch(Exception ex){
                System.out.println(ex);
            }

            return list;
    }

    public static FeeBean getRecordById(int id){
            FeeBean bean=new FeeBean();
            try{
                    Connection con=DB.getCon();
                    PreparedStatement ps=con.prepareStatement("select * from fee where id=?");
                    ps.setInt(1,id);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                            bean.setId(rs.getInt(1));
                            bean.setAmount(rs.getDouble(2));
                            bean.setDate(rs.getDate(3));
                            bean.setIduser(rs.getInt(4));
                            bean.setStatus(rs.getString(5));
                    }
                    con.close();
            }catch(Exception ex){
                System.out.println(ex);
            }

            return bean;
    }
    
     public static List<FeeBean> getAllByStatus(Status status){
            List<FeeBean> list=new ArrayList<FeeBean>();
            try{
                    Connection con=DB.getCon();
                    PreparedStatement ps=con.prepareStatement("select * from fee where status=?");
                    ps.setString(1,status.getValue());
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                            FeeBean bean=new FeeBean();
                            bean.setId(rs.getInt(1));
                            bean.setAmount(rs.getDouble(2));
                            bean.setDate(rs.getDate(3));
                            bean.setIduser(rs.getInt(4));
                            bean.setStatus(rs.getString(5));
                            list.add(bean);
                    }
                    con.close();
            }catch(Exception ex){
                System.out.println(ex);
            }

            return list;
    }
}
