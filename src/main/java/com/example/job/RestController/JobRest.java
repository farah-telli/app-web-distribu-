package com.example.job.RestController;
import com.example.job.Services.JobService;
import com.example.job.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Service
@RestController
@RequestMapping("/jobs")
public class JobRest {


    @Autowired
        private JobService jobService;

        @GetMapping("/jobss")
        public List<Job> getAllJobs() {
            return jobService.getAllJobs();
        }

        @GetMapping("/{idOrService}")
        public Optional<Job> getJobByIdOrService(@PathVariable String idOrService) {
            try {
                Integer id = Integer.parseInt(idOrService);
                return jobService.getJobByIdOrName(id, null);
            } catch (NumberFormatException e) {
                return jobService.getJobByIdOrName(null, idOrService);
            }
        }

        @PutMapping("/{id}")
        public void updateJobState(@PathVariable Integer id, @RequestParam Boolean etat) {
            jobService.updateJobState(id, etat);
        }
    }


