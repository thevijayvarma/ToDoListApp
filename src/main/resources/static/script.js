
    function addTask() {
    const taskInput = document.getElementById('newTaskInput');
    const taskList = document.getElementById('taskList');
    const taskCount = document.getElementById('taskCount');

    const taskValue = taskInput.value.trim();
    if (taskValue === '') {
    alert('Please enter a task');
    return;
}

    // Create new task item
    const taskItem = document.createElement('div');
    taskItem.classList.add('task-item');

    const checkbox = document.createElement('input');
    checkbox.type = 'checkbox';
    checkbox.style.marginRight = '10px';

    const label = document.createElement('label');
    label.textContent = taskValue;
    label.style.flex = '1';

    const deleteButton = document.createElement('button');
    deleteButton.textContent = 'Delete';
    deleteButton.onclick = function () {
    deleteTask(deleteButton);
};

    // Append the elements
    taskItem.appendChild(checkbox);
    taskItem.appendChild(label);
    taskItem.appendChild(deleteButton);
    taskList.appendChild(taskItem);

    // Clear input field and update task count
    taskInput.value = '';
    updateTaskCount();
}

    function deleteTask(button) {
    const taskItem = button.parentElement;
    taskItem.remove();
    updateTaskCount();
}

    function updateTaskCount() {
    const taskList = document.getElementById('taskList');
    const taskCount = document.getElementById('taskCount');
    const tasks = taskList.getElementsByClassName('task-item');
    taskCount.textContent = `${tasks.length} task${tasks.length !== 1 ? 's' : ''}`;
}
