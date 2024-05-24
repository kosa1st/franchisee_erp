package main.java.com.ouibak.erp.domain.orderRequest;

import main.java.com.ouibak.erp.dao.DBDaoImpl;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl extends DBDaoImpl implements OrderDao{
    private static OrderDaoImpl dao;

    public OrderDaoImpl(){

    }

    public static OrderDaoImpl getInstance(){
        if (dao == null){ dao = new OrderDaoImpl();}
        return dao;
    }

    // order시 insert order
    // 새로 생성된 order_idx return
//    public int TestMethod(String sqlQuery) throws SQLException {
//        CallableStatement cstmt = getCStmt(sqlQuery);
//        cstmt.setInt(1, 1);
//        cstmt.registerOutParameter(2, Types.INTEGER);
//        cstmt.execute();
//        int order_idx = cstmt.getInt(2);
//        return order_idx;
//    }

    //test 발주 내용 list넣기
//    public void TestMethod2(String sqlQuery, List<int[]> list) throws SQLException {
//        PreparedStatement pstmt = getPreStmt(sqlQuery);
//        for (int[] arr: list) {
//            pstmt.setInt(1, arr[0]);
//            pstmt.setInt(2, arr[1]);
//            pstmt.setInt(3, arr[2]);
//
//            pstmt.addBatch();
//        }
//        pstmt.executeBatch();
//        pstmt.clearBatch();
//
//    }


    @Override
    public Map<String, Integer> getAllProduct(String sqlQuery) throws SQLException {
        ResultSet rs = getData(sqlQuery);
        Map<String, Integer> map = new HashMap<>();
        while (rs.next()) {
            map.put(rs.getString(1), rs.getInt(2));
        }
        return map;
    }

    @Override
    public int craeteOrder(String sqlQuery) throws SQLException {
        CallableStatement cstmt = getCStmt(sqlQuery);
        cstmt.setInt(1, 1);
        cstmt.registerOutParameter(2, Types.INTEGER);
        cstmt.execute();
        int order_idx = cstmt.getInt(2);
        return order_idx;
    }

    @Override
    public void addOrderList(String sqlQuery, int orderId, List<Object[]> list) throws SQLException {
        PreparedStatement pstmt = getPreStmt(sqlQuery);
        for (Object[] arr: list) {
            //franchisee_num
            pstmt.setInt(1, orderId);
            //product name
            pstmt.setString(2, String.valueOf(arr[0]));
            //count
            pstmt.setInt(3, Integer.parseInt((String.valueOf(arr[1]))));

            pstmt.addBatch();
        }
        pstmt.executeBatch();
        pstmt.clearBatch();
    }
}
