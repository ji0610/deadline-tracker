package io.github.ji0610.deadlinetracker.deadline;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface DeadlineRepository extends JpaRepository<Deadline, Long> {
    List<Deadline> findByCourseIdOrderByDueAtAsc(Long courseId);

    List<Deadline> findByDueAtAfterOrderByDueAtAsc(Instant now);
}
