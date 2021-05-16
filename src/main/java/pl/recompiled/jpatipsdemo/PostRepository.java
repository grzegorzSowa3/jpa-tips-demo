package pl.recompiled.jpatipsdemo;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface PostRepository extends CrudRepository<Post, Long> {

}
