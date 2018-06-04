package beans;

import java.sql.Date;

/**
 *
 * @author adrien
 */
public class FeeBean {

     private int id;
     private double amount;
     private Date date;
     private int iduser;
     private String status;

    public FeeBean() {
    }

    public FeeBean(int id, double amount, Date date, int iduser, String status) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.iduser = iduser;
        this.status = status;
    }
     
      public FeeBean(double amount, Date date, int iduser, String status) {
        this.amount = amount;
        this.date = date;
        this.iduser = iduser;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FeeBean{" + "id=" + id + ", amount=" + amount + ", date=" + date + ", iduser=" + iduser + ", status=" + status + '}';
    }
       
}
