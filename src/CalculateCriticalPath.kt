import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.set


class CalculateCriticalPath(selectedProject: Project) {
    var nodeList:ArrayList<CriticalNode> = ArrayList()
    var nodeMap:MutableMap<Task, CriticalNode> = mutableMapOf()
    var startingList:ArrayList<CriticalNode> = ArrayList()
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
                        nodeMap[subTask]!!.previousNodes.add(nodeMap[task]!!); //assign the subtask NODE to the task NODE
                    }
                }
            }
        }

        for(node:CriticalNode in nodeList){
            if(node.previousNodes.size<1){
                node.earliestStart = 0
                startingList.add(node) //if a node has no previous nodes, add it to the starting list
                calculateNextStep(node)
            }
        }
        println("NodeList: ")
    }
    private fun calculateNextStep(node:CriticalNode){
        if(node.earliestStart==0){
            node.earliestFinish = node.duration

        }else{
            if(node.nextNodes.size>1){
                var longestNode:CriticalNode = node.nextNodes[0]
                for(item:CriticalNode in node.nextNodes){
                    if(longestNode.earliestFinish<item.earliestFinish){
                        longestNode = item
                    }
                }
            }
            //node.earliestStart = node.previousNodes
        }
    }
}

