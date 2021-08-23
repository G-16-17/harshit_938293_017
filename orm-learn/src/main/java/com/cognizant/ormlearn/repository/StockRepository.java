package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {
	
	@Query("select s from Stock s where s.code=?1 and (Month(s.date)=?2) and Year(s.date)=?3")
	public List<Stock> findStockByCodeandMonthandYear(String code, int month, int year);
	
	@Query("select s from Stock s where s.code='Googl' and s.stClose > 1250")
	public List<Stock> findGooglStockByPrice();
	
	@Query(value = "select * from Stock  where st_code='FB' order by st_volume desc LIMIT 3",nativeQuery = true)
	public List<Stock> findFBbyVoulme();
	
	@Query(value = "select * from Stock  where st_code='NFLX' order by st_volume asc LIMIT 3",nativeQuery = true)
	public List<Stock> findNflxbyVoulme();
	
	
	
}
