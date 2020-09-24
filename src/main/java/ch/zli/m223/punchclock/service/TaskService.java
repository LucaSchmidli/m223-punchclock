package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.Task;
import ch.zli.m223.punchclock.repository.EntryRepository;
import ch.zli.m223.punchclock.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public void updateTask(Long entryId, Task taskDetails){
        taskDetails.setId(entryId);
        taskRepository.saveAndFlush(taskDetails);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }
}