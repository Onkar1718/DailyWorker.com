package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Appointment;
import com.entity.Worker;

public class AppointmentDao {
	
	private Connection conn;

	public AppointmentDao(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addAppointment(Appointment ap)
	{
		boolean f=false;
		try {
			
			String sql="insert into appointment(user_id,full_name,gender,age,appoint_date,email,phno,requirement,worker_id,address,status)values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,ap.getUserId());
			ps.setString(2,ap.getFullName());
			ps.setString(3,ap.getGender());
			ps.setString(4,ap.getAge());
			ps.setString(5,ap.getAppoinDate());
			ps.setString(6,ap.getEmail());
			ps.setString(7,ap.getPhNo());
			ps.setString(8,ap.getRequirement());
			ps.setInt(9,ap.getWorkerId());
			ps.setString(10,ap.getAddress());
			ps.setString(11,ap.getStatus());
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Appointment> getAllAppointmentByLoginUser(int userId)
	{
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;
		
		try {
			String sql="select * from appointment where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setRequirement(rs.getString(9));
				ap.setWorkerId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}
			
			
		} catch (Exception e) {
			
		}
		
		return list;
	}
	public List<Appointment> getAllAppointmentByWorkerLogin(int workerId) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {

			String sql = "select * from appointment where worker_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, workerId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setRequirement(rs.getString(9));
				ap.setWorkerId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
