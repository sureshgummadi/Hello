package com.Inventory.Project.AssectService.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Inventory.Project.AssectService.Model.RamTypeMaster;

@Repository
public interface RamTypeDao extends JpaRepository<RamTypeMaster, Integer> {
	@Query(value = "select rm.* from `ram_type_master` rm where rm.ramtype_status=?",nativeQuery=true)
	List<RamTypeMaster> findByRamtypeStatus(Boolean ramtypeStatus);

//    Page<RamTypeMaster> findByHarddiskCapacityTypeContaining(String harddiskCapacityType, Pageable pageable);
	Page<RamTypeMaster> findByramtypeName(String ramtypeName, Pageable pageable);

//    Page<RamTypeMaster> findByRamtypeName(String ramtypeName, Pageable pageable);
//    Page<RamTypeMaster> findByramCapacityContaining(String ramtypeName, Pageable pageable);
	Page<RamTypeMaster> findByRamtypeNameContaining(String ramtypeName, Pageable pageable);

	RamTypeMaster findByRamtypeName(String stringCellValue);
	@Query(value = "select rm.* from `ram_type_master` rm where ramtype_id=?",nativeQuery=true)
	Optional<RamTypeMaster> findByRamTypeId(Integer ramTypeId);

}