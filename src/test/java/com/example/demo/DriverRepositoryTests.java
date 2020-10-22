package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Driver;
import com.example.demo.domain.DriverRepository;


@RunWith(SpringRunner.class)
@DataJpaTest

class DriverRepositoryTests {
	
    @Autowired
    private DriverRepository repository;
    
    @Test
    public void createNewDriver( ) {
    	Driver user = new Driver("heikki", "$2y$12$rsZm62HqAAdJ9xeMEspBguXDmlMjXaBCgBcs5wRxikzdcakS/lht6", "ADMIN");
		repository.save(user);
		assertThat(user.getRole()).isNotNull();
    }
    
    @Test
    public  void findDriver() {
    	Driver user = new Driver("heikki", "$2y$12$rsZm62HqAAdJ9xeMEspBguXDmlMjXaBCgBcs5wRxikzdcakS/lht6", "ADMIN");
		repository.save(user);
    	Driver user1 = repository.findByUsername("heikki");
    	
    	assertThat(user1.getRole()).isEqualTo("ADMIN");
    	//assertThat(user1.getRole()).isNotNull();
		// TODO Auto-generated method stub
	}
    
    @Test
    public void deleteUser() {
    	Driver user = new Driver("heikki", "$2y$12$rsZm62HqAAdJ9xeMEspBguXDmlMjXaBCgBcs5wRxikzdcakS/lht6", "ADMIN");
		repository.save(user);
		Driver user1 = repository.findByUsername("heikki");
		Long id = user1.getId();
		repository.deleteById(id);
		Driver user2 = repository.findByUsername("heikki");
		assertThat(user2).isNull();
    }
    
    
}