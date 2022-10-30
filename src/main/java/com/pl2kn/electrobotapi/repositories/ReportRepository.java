package com.pl2kn.electrobotapi.repositories;

import com.pl2kn.electrobotapi.models.Report;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

  List<Report> findByResolveTimestampIsNull();
}
