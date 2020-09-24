package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import ch.zli.m223.punchclock.service.ApplicationUserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private ApplicationUserService userService;
    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder, ApplicationUserService userService) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }
    /** Gibt alle User zurück
     *
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicationUser> getAllEntries() {
        return userService.findAll();
    }
    /** Erstellt einen neuen Nutzer
     * @param user Der User der Erstellt werden soll.
     */
    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);

    }
    /** Löscht einen user
     * @param id Die id des user
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEntry(@PathVariable Long id){
        userService.deleteUser(id);
    }
    /** Gibt einen User zurück
     * @param id Die id des Users
     */
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ApplicationUser> getSingle(@PathVariable Long id){
       return userService.getUser(id);
    }
    /** Updatet einen User
     * @param id Die id des Users
     * @param userDetails Die neuen Nutzerdaten.
     */
    @PutMapping("/{userId}")
    public void  updateEmployee(@PathVariable Long userId,@Valid @RequestBody ApplicationUser userDetails)  {
        userService.updateUser(userId,userDetails);
    }
}
