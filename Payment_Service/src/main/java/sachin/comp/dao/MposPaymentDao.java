package sachin.comp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sachin.comp.entity.MposPayment;

@Repository
public interface MposPaymentDao extends JpaRepository<MposPayment, Long> {
}

