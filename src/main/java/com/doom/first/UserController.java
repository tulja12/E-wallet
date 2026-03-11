package com.doom.first;

import java.util.List;
import com.doom.first.model.Credentials;
import com.doom.first.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credentials")
public class UserController {

    private final Repository repo ;

    public UserController(Repository repo) {
        this.repo = repo ;
    }

    @GetMapping("/")
    public List<Credentials> displayAll() {
        return repo.findAll() ;
    }

}
