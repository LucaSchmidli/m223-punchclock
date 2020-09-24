
package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.Role;
import ch.zli.m223.punchclock.domain.Task;
import ch.zli.m223.punchclock.service.EntryService;
import ch.zli.m223.punchclock.service.RoleService;
import ch.zli.m223.punchclock.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    /**
     *
     * Gibt alle Rollen zurück
     *
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }
    /** Löscht eine Rolle
     * @param id Die ID der Rolle.
     *
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
    }
    /** Updatet eine Rolle
     * @param id Die ID der Rolle.
     * @param roleDetails Die Details der Rolle.
     */
    @PutMapping("/{roleId}")
    public void  updateRole(@PathVariable Long roleId,@Valid @RequestBody Role roleDetails)  {
        roleService.updateRole(roleId,roleDetails);
    }
    /** Erstellt eine Rolle
     * @param role Die einzutragende Rolle.
     *
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role createRole(@Valid @RequestBody Role role    ) {
        return roleService.createRole(role);
    }
}