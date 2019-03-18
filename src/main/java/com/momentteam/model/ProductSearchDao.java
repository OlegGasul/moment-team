package com.momentteam.model;

import com.momentteam.model.entity.Sale;
import com.momentteam.model.search.SaleSearchFilter;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSearchDao {

  @Autowired
  protected SessionFactory sessionFactory;

  @Transactional
  public List<Sale> searchForSales(SaleSearchFilter filter) {
    Session session = sessionFactory.getCurrentSession();

    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Sale> query = builder.createQuery(Sale.class);
    Root<Sale> root = query.from(Sale.class);

    List<Predicate> predicates = new LinkedList<>();

    if (filter.getDateFrom() != null) {
      predicates.add(builder.greaterThanOrEqualTo(root.<LocalDate>get("saleDate"), filter.getDateFrom()));
    }

    if (filter.getDateTo() != null) {
      predicates.add(builder.lessThanOrEqualTo(root.<LocalDate>get("saleDate"), filter.getDateTo()));
    }

    query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));

    return session.createQuery(query).getResultList();
  }



}
