package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.Role;
import ch.zli.m223.punchclock.domain.Task;
import ch.zli.m223.punchclock.repository.EntryRepository;
import ch.zli.m223.punchclock.repository.RoleRepository;
import ch.zli.m223.punchclock.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }

    public void updateRole(Long roleId, Role roleDetails){
        roleDetails.setId(roleId);
        roleRepository.saveAndFlush(roleDetails);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}