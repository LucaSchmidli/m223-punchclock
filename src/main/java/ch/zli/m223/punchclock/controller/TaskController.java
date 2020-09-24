
package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.Task;
import ch.zli.m223.punchclock.service.EntryService;
import ch.zli.m223.punchclock.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    /** Gibt alle Tasks zurück
     *
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }
    /** Löscht eine Task
     * @param id Die id der Task
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
    /** Updatet eine Task
     * @param id Die id der Task
     * @param taskDetails Die Details der Task
     */
    @PutMapping("/{taskId}")
    public void  updateTask(@PathVariable Long taskId,@Valid @RequestBody Task taskDetails)  {
        taskService.updateTask(taskId,taskDetails);
    }
    /** Erstellt eine Task
     * @param task Die Task
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@Valid @RequestBody Task task) {
        return taskService.createTask(task);
    }
}