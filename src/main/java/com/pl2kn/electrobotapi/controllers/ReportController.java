package com.pl2kn.electrobotapi.controllers;

import com.pl2kn.electrobotapi.exceptions.ReportNotFoundException;
import com.pl2kn.electrobotapi.models.Report;
import com.pl2kn.electrobotapi.repositories.ReportRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "https://electro-bot-ui.herokuapp.com/")
public class ReportController {

  private final ReportRepository reportRepository;

  public ReportController(ReportRepository reportRepository) {
    this.reportRepository = reportRepository;
  }

  @GetMapping("")
  public List<Report> index() {
    return reportRepository.findByResolveTimestampIsNull();
  }

  @PostMapping("")
  public Report create(@RequestBody Report report) {
    return reportRepository.save(report);
  }

  @PostMapping("/{id}/resolve")
  public Report resolve(@PathVariable Long id) {
    return reportRepository.findById(id)
        .map(report -> {
          report.setResolveTimestamp(System.currentTimeMillis());
          reportRepository.save(report);
          return report;
        })
        .orElseThrow(ReportNotFoundException::new);
  }
}
