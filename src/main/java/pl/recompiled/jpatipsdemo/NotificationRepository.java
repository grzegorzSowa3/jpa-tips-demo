package pl.recompiled.jpatipsdemo;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface NotificationRepository extends CrudRepository<Notification, Long> {

}
