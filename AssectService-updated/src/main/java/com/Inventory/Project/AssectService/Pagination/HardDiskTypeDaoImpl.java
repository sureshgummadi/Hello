package com.Inventory.Project.AssectService.Pagination;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.Inventory.Project.AssectService.Exception.RecordNotFoundException;

@Repository
public class HardDiskTypeDaoImpl {

	@PersistenceContext
	EntityManager entityManager;
	
	public PagenationResponse getAllHardDiskTyps(Integer pagenumber, Integer pageSize, String search) throws RecordNotFoundException {
		long totalRecords = 0;

		StringBuilder queryString = new StringBuilder("select h1.hard_disk_type_id,h1.harddisk_type,h1.harddisk_status,h1.created_by,h1.updated_by,h1.created_on,h1.updated_on,h1.lastmodefied_date from `hard_disk_type_master` h1");
		if (search != null) {

			queryString.append(" where h1.harddisk_type LIKE '%" + search + "%'");

		}
		queryString.append(" order by h1.lastmodefied_date DESC");
		
		int startingRow = 0;
		if (pagenumber == 1) {
			startingRow = 0;
		} else {
			startingRow = ((pagenumber - 1) * pageSize);
		}
		
		List<Object[]> resultList = entityManager.createNativeQuery(queryString + " limit " + startingRow + "," + pageSize).getResultList();
		List<HardDiskTypePagination> list = new ArrayList<>();

		List<Object[]> resultObj = entityManager.createNativeQuery(queryString.toString()).getResultList();
		if (!resultObj.isEmpty()) {
			totalRecords = Long.valueOf(resultObj.size());
		}
		for (Object[] obj : resultList) {
			HardDiskTypePagination hardPagination = new HardDiskTypePagination();
			hardPagination.setHardDiskTypeId(Integer.parseInt(String.valueOf(obj[0])));
			hardPagination.setCreatedBy(String.valueOf(obj[3]));
			hardPagination.setCreatedOn(String.valueOf(obj[5]));
			hardPagination.setHardDiskStatus(Boolean.parseBoolean(String.valueOf(obj[2])));
			hardPagination.setHardDiskType(String.valueOf(obj[1]));
			hardPagination.setUpdatedBy(String.valueOf(obj[4]));
			hardPagination.setUpdatedOn(String.valueOf(obj[6]));
			list.add(hardPagination);
		}
		if(!list.isEmpty()) {
		PagenationResponse harddiskResponse = new PagenationResponse();

		long totalPages = 1;
		if (totalRecords == 0) {
			harddiskResponse.setTotalNumberOfPages(Long.valueOf(0));
		} else {
			totalPages = totalRecords / pageSize;
			totalPages = ((totalRecords % pageSize > 0) ? (totalPages + 1) : totalPages);
		}
		harddiskResponse.setTotalNumberOfPages(totalPages);
		harddiskResponse.setTotalNumberOfRecords(totalRecords);
		harddiskResponse.setList(list);

		return harddiskResponse;
		}else {
			throw new RecordNotFoundException("No HardDiskType Data Found");
		}
	}
}
