package com.example.job.Repositories;

import com.example.job.entities.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Integer> {


    @Query("select j from Job j where j.service like :service")
    public Page<Job> jobByService(@Param("service") String n, Pageable pageable);
        List<Job> findByEtat(Boolean etat);
        Optional<Job> findByIdOrService(Integer id, String service);
    }


