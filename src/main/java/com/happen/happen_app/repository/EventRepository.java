package com.happen.happen_app.repository;

import com.happen.happen_app.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
