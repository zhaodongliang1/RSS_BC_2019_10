package com.ysd.RSS.dao;

import com.ysd.RSS.entity.Memberships;

public interface MembershipsDao {
	/**
	 * 根据专业查询
	 * @param mem_specialty
	 * @return
	 */
	Memberships selectMembershipsBySpecialty(String mem_specialty);
}
