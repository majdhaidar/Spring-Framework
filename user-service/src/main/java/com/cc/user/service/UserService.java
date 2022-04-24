package com.cc.user.service;

import com.cc.user.entity.User;
import com.cc.user.repository.UserRepository;
import com.cc.user.vo.Department;
import com.cc.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author MajdHaidar
 * @date 4/19/22
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside saveUser of UserService");
        return  userRepository.save(user);
    }

    public ResponseTemplateVO returnUserDepartmentById(Long id) {
        log.info("inside returnUserDepartmentById of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User savedUser = userRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid/Missing User Id "+id));
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+savedUser.getDepartmentId(),
                Department.class);
        vo.setUser(savedUser);
        vo.setDepartment(department);
        return vo;
    }
}
