class CalculateCriticalPath(selectedProject: Project) {
    var nodeList:ArrayList<CriticalNode> = ArrayList()
    var nodeMap:MutableMap<Task, CriticalNode> = mutableMapOf()
    init{
        for(task:Task in selectedProject.tasks){
            var newNode:CriticalNode = CriticalNode(task.name, task.timeFrame)
            nodeList.add(newNode)
            nodeMap[task] = newNode

        }

        for (task: Task in selectedProject.tasks) { //loop through all task objects
            var subTaskNameList: ArrayList<String> = task.subsequentTasks //get the tasks sub tasks
            for (subTaskName: String in subTaskNameList) { //loop through the strings of sub tasks
                for (subTask: Task in selectedProject.tasks) {
                    if (subTask.name == subTaskName) { //find the task object associated with the subtask string
                        nodeMap[task]!!.nextNodes.add(nodeMap[subTask]!!); //assign the subtask NODE to the task NODE
                    }
                }
            }
        }

        println("NodeList: $nodeMap")
    }
}