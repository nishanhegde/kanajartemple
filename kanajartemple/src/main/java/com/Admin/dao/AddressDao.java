package com.Admin.dao;

import java.util.List;
import java.util.Map;

import com.Admin.bean.Address;

public interface AddressDao {

	public void save(Address address);

	public List<Address> getAddress();

	public Address getAddress(String id);

	public Integer update(Address address);

	public void delete(String id);
	
	public List<Map<String, Object>> getInvitationAddress();
}
