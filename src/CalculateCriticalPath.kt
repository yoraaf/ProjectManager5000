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

        /*for(node:CriticalNode in nodeList){
            if(node.previousNodes.size<1){
                node.earliestStart = 0
                startingList.add(node) //if a node has no previous nodes, add it to the starting list
                calculateNextStep(node)
            }
        }*/
        var aaaaaaaaaaa = criticalPath(nodeList)
        println("NodeList: ")
        print(aaaaaaaaaaa)
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

    fun criticalPath(tasks: ArrayList<CriticalNode>?): Array<CriticalNode> {
        //tasks whose critical cost has been calculated
        val completed = HashSet<CriticalNode>()
        //tasks whose ciritcal cost needs to be calculated
        val remaining = HashSet(tasks) //TODO change so it looks less stolen

        //Backflow algorithm
        //while there are tasks whose critical cost isn't calculated.
        while (!remaining.isEmpty()) {
            var progress = false

            //find a new task to calculate
            val it = remaining.iterator()
            while (it.hasNext()) {
                val node = it.next()
                if (completed.containsAll(node.previousNodes)) {
                    //all dependencies calculated, critical cost is max dependency
                    //critical cost, plus our cost
                    var critical = 0
                    for (t in node.previousNodes) {
                        if (t.earliestFinish > critical) {
                            critical = t.earliestFinish
                        }
                    }
                    node.earliestFinish = critical + node.duration
                    //set task as calculated an remove
                    completed.add(node)
                    it.remove()
                    //note we are making progress
                    progress = true
                }
            }
            //If we haven't made any progress then a cycle must exist in
            //the graph and we wont be able to calculate the critical path
            if (!progress) throw RuntimeException("Cyclic dependency, algorithm stopped!")
        }

        //get the tasks
        val ret: Array<CriticalNode> = completed.toArray(arrayOfNulls(0))
        //create a priority list
        Arrays.sort(ret, Comparator { o1, o2 -> //sort by cost
            val i = o2.latestFinish - o1.latestFinish
            if (i != 0) return@Comparator i

            //using dependency as a tie breaker
            //note if a is dependent on b then
            //critical cost a must be >= critical cost of b
            if (o1.isDependent(o2)) return@Comparator -1
            if (o2.isDependent(o1)) 1 else 0
        })
        return ret
    }
}

