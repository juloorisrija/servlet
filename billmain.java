package com.assignment7.jsf.bean;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


	@ManagedBean(name="bill")
	@SessionScoped
public class billmain {
	int meterId;
	int currentMeterReading;
	int previousMeterReading;
	String zone;
	String name;
	String subsidy;
	int  unitconsumed;
	long result=0;
	private static final List<BillConstruct> billList=new ArrayList<>();
	int flag=0;
	public String addBilldetails() {
		if(result==0)

		{

		return "/home1.xhtml";

		}
	billList.add(new BillConstruct(meterId,currentMeterReading,previousMeterReading,zone,result));
	return "/show.xhtml";
	}
	public void setMeterId(int meterId)
	{
	    this.meterId=meterId;
	}
	public int getMeterId() {
	    return meterId;
	}
	public int getCurrentMeterReading() {
	    return currentMeterReading;
	}
	public void setCurrentMeterReading(int currentMeterReading) {
	    this.currentMeterReading = currentMeterReading;
	}
	public int getPreviousMeterReading() {
	    return previousMeterReading;
	}
	public void setPreviousMeterReading(int previousMeterReading) {
	    this.previousMeterReading = previousMeterReading;
	}
	public String getZone() {
	    return zone;
	}
	public void setZone(String zone) {
	    this.zone = zone;
	}
	
	 

	public long addData() throws ClassNotFoundException, SQLException
	{
		Connection conn = Databaseconn.initializeDatabase();


	    if(flag==0)
	    {
	        PreparedStatement st;
	        PreparedStatement st1;
	        String query="select * from bill";
	        String query1="UPDATE bill SET result=?,currMeterReading=?,prevMeterReading =?,units_consumed=?,Subsidy=?  where MeterID=? ";
	        flag=1;
	        try {
	            BillConstruct b = new BillConstruct();
	            st=conn.prepareStatement(query);
	            st1=conn.prepareStatement(query1);
	            ResultSet rs = st.executeQuery();
	        //    System.out.println(getZone());

	        int temp=0;
	            while(rs.next())
	            {




	                System.out.println(rs.getInt("meterId"));
	                if(getMeterId()==rs.getInt("MeterID"))
	                {

	                    name=rs.getString("Name");
	                    temp=1;

	                    long cmrh=getCurrentMeterReading();
	                    long pmrh=getPreviousMeterReading();

	                    unitconsumed=(int)(cmrh-pmrh);
	                    st1.setInt(4, unitconsumed);

	                    if(getZone().equalsIgnoreCase("urban"))
	                    {
	                        result=(cmrh-pmrh)*6;
	                    }
	                    else if(getZone().equalsIgnoreCase("rural"))
	                    {
	                        result=(cmrh-pmrh)*4;

	                    }

	                    if((cmrh-pmrh)<100)
	                    {
	                        result=result-100;
	                        st1.setString(5, "App");
	                        subsidy="Applicable(₹100 only...)";
	                    }
	                    else
	                    {
	                        st1.setString(5, "Not");
	                        subsidy="Not Applicable";
	                    }
	                    st1.setLong(1, result);
	                    st1.setInt(2, getCurrentMeterReading());
	                    st1.setInt(3, getPreviousMeterReading());

	                    st1.setInt(6, getMeterId());
	                    st1.executeUpdate();
	                }


	            }
	            if(temp==0)
	            {
	                System.out.println("check me....");
	            }


	        } catch (SQLException e) {

	            e.printStackTrace();
	        }

	    }
	    return result;
	}
	public long getResult() {
	    return result;
	}
	public String getName() {
	    return name;
	}
	public String getSubsidy() {
	    return subsidy;
	}
	public int getUnitconsumed() {
	    return unitconsumed;
	}
	public List<BillConstruct> getStudents(){
	return billList;
	}
	}
