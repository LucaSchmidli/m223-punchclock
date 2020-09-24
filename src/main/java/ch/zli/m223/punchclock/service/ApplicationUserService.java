package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class ApplicationUserService implements UserDetailsService {
    private ApplicationUserRepository applicationUserRepository;

    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }

    public void deleteUser(Long id){
        applicationUserRepository.deleteById(id);
    }

    public void updateUser(Long userId, ApplicationUser userDetails){
        userDetails.setId(userId);
        applicationUserRepository.saveAndFlush(userDetails);
    }
    public List<ApplicationUser> findAll() {
        return  applicationUserRepository.findAll();
    }

    public Optional<ApplicationUser> getUser(Long id) {
        return  applicationUserRepository.findById(id);
    }
}