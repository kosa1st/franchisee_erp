package main.java.com.ouibak.erp.domain.statistics;

import java.sql.SQLException;
import java.util.List;

public interface StatisticsService {

    void getProductList() throws SQLException;

    List<List<Integer>> getStatistics(String productName) throws SQLException;
}
