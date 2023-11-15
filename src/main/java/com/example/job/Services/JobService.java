package com.example.job.Services;

import com.example.job.Repositories.JobRepository;
import com.example.job.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {


    @Autowired
        private JobRepository jobRepository;

        public List<Job> getAllJobs() {
            return (List<Job>) jobRepository.findAll();
        }

        public Optional<Job> getJobByIdOrName(Integer id, String name) {
            return jobRepository.findByIdOrService(id, name);
        }

        public void updateJobState(Integer id, Boolean etat) {
            Optional<Job> optionalJob = jobRepository.findById(id);
            optionalJob.ifPresent(job -> {
                job.setEtat(etat);
                jobRepository.save(job);
            });
        }
    }


