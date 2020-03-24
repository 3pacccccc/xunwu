package com.imooc.repository;


import com.imooc.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void findOneTest() {
        User user = repository.findOne(new Long(2));
        Assert.assertEquals(user.getPhoneNumber(), "13999999999");
    }

    @Test
    public void createTest() {
        User user = new User();
        user.setName("xiaoma");
        user.setPhoneNumber("138888");
        user.setStatus(2);
        User result = repository.save(user);
        Assert.assertNotNull(result);
    }

    @Test
    public void deleteTest() {
        User user = repository.findOne(new Long("9"));
        Assert.assertNotNull(user);
        repository.delete(new Long("9"));
        User result = repository.findOne(new Long("9"));
        Assert.assertNull(result);
    }

    @Test
    public void updateTest() {
        User user = repository.findOne(new Long("5"));
        user.setStatus(2);
        User result = repository.save(user);
        Assert.assertEquals(2, result.getStatus());
    }
}
