fun main() {
    menuList()
}

val taskList = mutableListOf("Item 1", "Item 2", "Item 3")

fun menuList() {
    println("Welcome to Task Manager")
    println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-")

    while (true) {
        println("---------------------------------")
        println("1. Add Task")
        println("2. Remove Task")
        println("3. Mark Task Complete")
        println("4. List Tasks")
        println("5. Quit")
        println("Select an option to proceed:")
        println("---------------------------------")

        val menuList = listOf("Add Task", "Remove Task", "Mark Task Complete", "List Tasks", "Quit")

        val option = readlnOrNull()

        println("The selected option is ${menuList[option?.toInt()!! - 1]}")

        try {
            checkItemSelected(option.toInt())
        } catch (e: Exception) {
            println("Please enter the correct option")
        }

        if (option == "5") {
            quitManager()
            break
        }
    }
}


fun checkItemSelected(option: Int) {
    when (option) {
        1 -> addTask()
        2 -> removeTask()
        3 -> markTaskComplete()
        4 -> listTasks()
        5 -> quitManager()

    }
}

fun addTask() {
    while (true) {
        print("Please Enter the task or 'exit' to end: ")
        val taskItem = readlnOrNull()

        if (taskItem == "exit" || taskItem.isNullOrBlank()) {
            quitManager()
            break
        } else {
            taskList.add(taskItem)
        }
    }
}

fun getTaskList(taskList: List<String>) {
    if (taskList.isEmpty()) {
        println("Task List Is Empty, Add Task")
    }

    for (opt in taskList.indices) {
        println("${opt + 1}. ${taskList[opt]}")
    }
}

fun removeTask() {
    println("Enter the option of the task to remove it")

    getTaskList(taskList)

    val opt = readlnOrNull()
    try {

        val index = opt?.toInt()?.minus(1)
        if (index in taskList.indices) {

            println("Task: '${taskList[index!!]}' Removed")
            taskList.removeAt(index)

        }


    } catch (e: Exception) {
        println("Please enter the correct option")
    }

}

fun markTaskComplete() {
    println("Select an option to mark a task as completed")

    getTaskList(taskList)

    val optCompleted = readlnOrNull()

    try {
        val selectedOption = optCompleted?.toInt()?.minus(1)

        if (selectedOption in taskList.indices) {
            println("Done: ✔  ${taskList[selectedOption!!]}")
            taskList.removeAt(selectedOption)
        }
    } catch (e: Exception) {
        println("Please enter the correct option")
    }
}

fun listTasks() {
    getTaskList(taskList)
}

fun quitManager() {
    println("You have exited successfully")
}