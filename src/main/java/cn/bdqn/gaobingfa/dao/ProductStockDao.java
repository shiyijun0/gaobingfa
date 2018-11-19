package cn.bdqn.gaobingfa.dao;

import cn.bdqn.gaobingfa.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductStockDao extends JpaRepository<ProductStock,Integer> {

    ProductStock findByProductId(String productId);
   @Transactional
    @Modifying
    @Query(value = "update product_stock set stock=stock-1,orders=orders+1 where product_id=?1",nativeQuery = true)
    int update(String productId);
    @Transactional
    @Modifying
    @Query(value = "insert into product_stock(order_id,orders) VALUES (?1,?2)",nativeQuery = true)
    int insert(String orderId,int orders);
}
