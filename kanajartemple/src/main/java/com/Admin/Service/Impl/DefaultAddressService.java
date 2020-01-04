package com.Admin.Service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Required;

import com.Admin.Service.AddressService;
import com.Admin.bean.Address;
import com.Admin.dao.AddressDao;

public class DefaultAddressService implements AddressService {
	
	private AddressDao addressDao;

	@Override
	public void save(Address address) {
		getAddressDao().save(address);
		
	}
	

	@Override
	public List<Address> getAddress() {
		return getAddressDao().getAddress();
	}

	@Override
	public Address getAddress(String id) {
		return getAddressDao().getAddress(id);
	}

	@Override
	public Integer update(Address address) {
		return getAddressDao().update(address);
	}

	@Override
	public void delete(String id) {
		getAddressDao().delete(id);
	}

	public AddressDao getAddressDao() {
		return addressDao;
	}

	@Required
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}


	@Override
	public List<Map<String, Object>> getInvitationAddress() {
		return getAddressDao().getInvitationAddress();
	}
	
	

}
