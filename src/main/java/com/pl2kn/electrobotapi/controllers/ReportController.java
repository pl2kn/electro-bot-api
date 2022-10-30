package com.pl2kn.electrobotapi.controllers;

import com.pl2kn.electrobotapi.models.Report;
import com.pl2kn.electrobotapi.repositories.ReportRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReportController {

  private final ReportRepository reportRepository;

  public ReportController(ReportRepository reportRepository) {
    this.reportRepository = reportRepository;
  }

  @GetMapping("/reports")
  public List<Report> index() {
    return reportRepository.findByResolveTimestampIsNull();
  }
}
