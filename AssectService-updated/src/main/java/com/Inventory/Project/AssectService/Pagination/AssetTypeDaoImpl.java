package com.Inventory.Project.AssectService.Pagination;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.Inventory.Project.AssectService.Exception.RecordNotFoundException;

@Repository
public class AssetTypeDaoImpl {

	@PersistenceContext
	EntityManager entityManager;
	
	public PagenationResponse getAllAssetTypes(Integer pagenumber, Integer pageSize, String search) throws RecordNotFoundException {
		long totalRecords = 0;

		StringBuilder queryString = new StringBuilder("select as1.* from asset_type1 as1");
		if (search != null) {

			queryString.append(" WHERE as1.assettype LIKE '%" + search + "%'");

		}
		queryString.append(" order by as1.lastmodefied_date DESC");
		
		int startingRow = 0;
		if (pagenumber == 1) {
			startingRow = 0;
		} else {
			startingRow = ((pagenumber - 1) * pageSize);
		}
		
		List<Object[]> resultList = entityManager
				.createNativeQuery(queryString + " limit " + startingRow + "," + pageSize).getResultList();
		List<AssetTypePagination> list = new ArrayList<>();

		List<Object[]> resultObj = entityManager.createNativeQuery(queryString.toString()).getResultList();
		if (!resultObj.isEmpty()) {
			totalRecords = Long.valueOf(resultObj.size());
		}
		
		for (Object[] obj : resultList) {
			AssetTypePagination assetype = new AssetTypePagination();
			assetype.setAssetId(Integer.parseInt(String.valueOf(obj[0])));
			assetype.setAssetStatus(Boolean.parseBoolean(String.valueOf(obj[1])));
			assetype.setAssetType(String.valueOf(obj[2]));			
			assetype.setCreatedBy(String.valueOf(obj[3]));
			assetype.setCreatedOn(String.valueOf(obj[4]));
			assetype.setLastmodefiedDate(String.valueOf(obj[5]));
			assetype.setUpdatedBy(String.valueOf(obj[6]));
			assetype.setUpdatedOn(String.valueOf(obj[7]));
			list.add(assetype);
		}
		if(!list.isEmpty()) {
		PagenationResponse assettypeResponse = new PagenationResponse();

		long totalPages = 1;
		if (totalRecords == 0) {
			assettypeResponse.setTotalNumberOfPages(Long.valueOf(0));
		} else {
			totalPages = totalRecords / pageSize;
			totalPages = ((totalRecords % pageSize > 0) ? (totalPages + 1) : totalPages);
		}
		assettypeResponse.setTotalNumberOfPages(totalPages);
		assettypeResponse.setTotalNumberOfRecords(totalRecords);
		assettypeResponse.setList(list);

		return assettypeResponse;
		}else {
			throw new RecordNotFoundException("No AssetType Data Found");
		}
		
	}
}
