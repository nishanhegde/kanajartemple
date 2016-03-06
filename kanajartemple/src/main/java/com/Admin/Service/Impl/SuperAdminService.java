package com.Admin.Service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Admin.bean.Donation;
import com.Admin.bean.Pooje;
import com.Admin.bean.Poojebean;
import com.Admin.dao.impl.SuperAdminDao;

@Service("service")
public class SuperAdminService {
	
	@Autowired
	private SuperAdminDao dao;

	public SuperAdminDao getDao() {
		return dao;
	}

	public void setDao(SuperAdminDao dao) {
		this.dao = dao;
	}
	

	public Integer CUDPooje(Pooje pbean,String code)
	{
		return dao.CUDPooje(pbean,code);
	}
	
	public Integer CUDDonation(Donation dbean,String code)
	{
		return dao.CUDDonation(dbean,code);
	}
	
	public List<Map<String,Object>> getAdmin() {
		return dao.getAdmin();
	}
	
	public List<Map<String,Object>> getAdminToReject() {
		return dao.getAdminToReject();
	}
	
	public Integer approveAdmin(String id)
	{
		return dao.approveAdmin(id);
	}
	
	public Integer rejectAdmin(String id)
	{
		return dao.rejectAdmin(id);
	}
	
	public Integer deleteAdmin(String id)
	{
		return dao.deleteAdmin(id);
	}
}
